package dataReader;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import homePage.Login;
import reporting.TestLogger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static dataReader.GoogleSheetReader.getSheetsService;

public class GoogleSheet extends Login {
    Login loginObject = PageFactory.initElements(driver,Login.class);
    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        // Build a new authorized API client service.
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }
    public List<String> signInByInvalidIdPass(String spreadsheetId, String range) throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<List<Object>> col2Value = getSpreadSheetRecords(spreadsheetId, range);
        List<String> actual = new ArrayList<>();
        for (List row : col2Value) {
            Thread.sleep(3000);
            inputValueInTextBoxByWebElement(loginTextBox, row.get(1).toString());
            inputValueInTextBoxByWebElement(passwordTextBox, row.get(2).toString());
            Thread.sleep(3000);
            actual.add(getTextByWebElement(errorMessage));
            System.out.println(getTextByWebElement(errorMessage));
            clearInputBox(loginTextBox);
            clearInputBox(passwordTextBox) ;
            Thread.sleep(3000);
        }
        return actual;
    }
    public void inputValueInTextBoxByWebElement(WebElement webElement, String value){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        webElement.sendKeys(value + Keys.ENTER);
    }
    public void clearInputBox(WebElement webElement){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        webElement.clear();
    }
    public String getTextByWebElement(WebElement webElement){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String text = webElement.getText();
        return text;
    }
    public void sendSpreadSheetIdAndRange(String spreadsheetId, String range) throws InterruptedException, IOException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.navigate().to("https://ecams.geico.com/ecams/login.xhtml?r=true");
        Thread.sleep(1000);
        List<String> actualErrorMessage = signInByInvalidIdPass(spreadsheetId, range);
        loginObject.clickSubmit();
        List<List<Object>> expectedErrorMessage = getSpreadSheetRecords(spreadsheetId, range);
        for (int index=0;index<expectedErrorMessage.size();index++) {
            Assert.assertTrue(actualErrorMessage.get(index).contains(actualErrorMessage.get(index)));
        }
    }
}

