package homePage;

import base.CommonAPI;
import dataReader.XlsDataReaderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.Iterator;
public class Login extends CommonAPI {
    @FindBy(id = "userName")
    public static WebElement loginTextBox;
    @FindBy(id = "userPassword")
    public static WebElement passwordTextBox;
    @FindBy(id = "loginButton")
    public static WebElement loginButton;
    @FindBy(id="userPassword-msgs")
    public static WebElement errorMessage;

    public static void navigateToLoginPage(){
        TestLogger.log(Login.class.getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.navigate().to("https://ecams.geico.com/ecams/login.xhtml?r=true");
    }
    public void clickSubmit(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        loginButton.click();
    }
    public void clearInputBox(WebElement webElement){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        webElement.clear();
    }

    public String SendLoginInfo(String email, String password) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        loginTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000);
        clickSubmit();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userPassword-msgs")));
        String errMessage = errorMessage.getText();
        clearInputBox(loginTextBox);
        clearInputBox(passwordTextBox);
        return errMessage;
    }
    @DataProvider
    public Iterator<Object[]> supplyData(){
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        ArrayList<Object[]> testData =
                XlsDataReaderUtil.getDataFromExcel();
        return testData.iterator();
    }
    @DataProvider
    public Iterator<Object[]> supplyMongoData(){
        //TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        ArrayList<Object[]> testData =
                XlsDataReaderUtil.getDataFromExcel();
        return testData.iterator();
    }
}