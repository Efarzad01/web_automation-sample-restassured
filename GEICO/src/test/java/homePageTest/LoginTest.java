package homePageTest;

import homePage.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class LoginTest extends Login {
    Login loginObject;
    @BeforeMethod
    public void init(){
        loginObject = PageFactory.initElements(driver,Login.class);
    }
//    @DataProvider
//    public Iterator<Object[]> supplyData(){
//        ArrayList<Object[]> testData = XlsDataReaderUtil.getDataFromExcel();
//        return testData.iterator();
//    }
    @Test(dataProvider = "supplyData")
    public void signInWithInvalidIDPassUsingExcel(String email, String passCode, String message) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        navigateToLoginPage();
        String errMessage = SendLoginInfo(email, passCode);
        Assert.assertEquals(message,errMessage);
    }
}
