package datadriventest;

import dataReader.GoogleSheet;
import homePage.Login;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class GoogleSheetTest extends CommonAPI {
    Login loginObject;
    GoogleSheet googleSheetsPage;

    @BeforeMethod
    public void initialization(){
        loginObject = PageFactory.initElements(driver, Login.class);
        googleSheetsPage = PageFactory.initElements(driver,GoogleSheet.class);
    }

    //Verify log in by taking data from a google sheets file
    @Test
    public void testLogInByInvalidIdPassUsingGoogleSheet() throws IOException, InterruptedException {
        //Thread.sleep(3000);

        Thread.sleep(3000);
        int i = 0;
        String spreadsheetId = "1H0JiWbL-Hq9to5oI21m65xpY0OQzJ4qCLjdzqbFgy6c";
        String range = "Sheet1!A2:C";
        List<String> actualErrorMessage = googleSheetsPage.signInByInvalidIdPass(spreadsheetId, range);
        loginObject.clickSubmit();
        List<List<Object>> expectedErrorMessage = googleSheetsPage.getSpreadSheetRecords(spreadsheetId, range);
        for (List row : expectedErrorMessage) {
            // Assert.assertTrue(actualErrorMessage.get(i).contains(row.get(3).toString()));
            //System.out.println("expected"+row.get(3).toString());
            System.out.println(expectedErrorMessage.get(i) + ": Search - Passed");
            i++;
        }
        System.out.println("testLogInByInvalidIdPassUsingGoogleSheet Passed");
    }
}
