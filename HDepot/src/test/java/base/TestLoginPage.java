package base;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends LoginPage {
    Home objHomePage;
    LoginPage objLoginPage;

    @BeforeMethod
    public void initializePageObjects() {
        objHomePage = PageFactory.initElements(driver, Home.class);
        objLoginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    //T3HOM_LP_TC01 verify Email address box status
    @Test(enabled=true)
    public void testEmailBox() {
        objHomePage.goToLoginPage();
        boolean actual = objLoginPage.checkEmailTextBoxEnable();
        Assert.assertEquals(actual,true);
        System.out.println("testEmailBox test passed");
    }
    //T3HOM_LP_TC02 verify Password box status
    @Test(enabled=true)
    public void testPasswordBox() {
        objHomePage.goToLoginPage();
        boolean actual = objLoginPage.checkPasswordTextBoxEnable();
        Assert.assertEquals(actual,true);
        System.out.println("testPasswordBox test passed");
    }
    //T3HOM_LP_TC03 Verify SignIn button as with wrong credentials, Signin button is disabled
    @Test(enabled=true)
    public void testSignInButton() {
        objHomePage.goToLoginPage();
        boolean actual = objLoginPage.checkSignInButton();
        Assert.assertEquals(actual,true);
        System.out.println("testClearBox test passed");
    }
    //T3HOM_LP_TC04 Invalid email id throw error message
    @Test(enabled=false)
    public void testInvalidEmail() {
        objHomePage.goToLoginPage();
        String actualError = objLoginPage.invalidEmail();
        String expectedError = "Please provide your email address, formatted as you@domain.com.";
        Assert.assertTrue(actualError.contains(expectedError));
        System.out.println("testInvalidEmail test passed");
    }
    //T3HOM_LP_TC05 Invalid password throw error message
    @Test(enabled=true)
    public void testInvalidPassword() {
        objHomePage.goToLoginPage();
        String actualError = objLoginPage.invalidPassword();
        String expectedError = "Please provide your password.";
        Assert.assertTrue(actualError.contains(expectedError));
        System.out.println("testInvalidPassword test passed");
    }
    //T3HOM_LP_TC06 Verify My Account Terms & Conditions
    @Test(enabled=false)
    public void testMyAccount() throws InterruptedException {
        objHomePage.goToLoginPage();
        String actual = objLoginPage.verifyMyAccount();
        String expected = "https://www.homedepot.com/c/PH_MyAccount";     //"My Account Terms & Conditions";
        System.out.println(actual);
         // Assert.assertTrue(actual.contains(expected));
          //System.out.println("testMyAccount test passed");
    }
}
