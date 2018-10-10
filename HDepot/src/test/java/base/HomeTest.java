package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.text.MessageFormat;

public class HomeTest extends Home {
    Home home;

    @BeforeMethod
    public void init() {
        home = PageFactory.initElements(driver, Home.class);
    }

    @Test
    public void storeFinder() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.storeFinder();
    }

    @Test
    public void myAccount() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.myAccount();
    }

    @Test
    public void specialsAndOffers() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.specialsAndOffers();
    }


    @Test
    public void login(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.login();
    }
}
