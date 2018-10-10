package helpPageTest;

import base.Home;
import helppage.Help;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class HelpPage extends Help {
    Help help;

    @BeforeMethod
    public void init() {
        help = PageFactory.initElements(driver, Help.class);
    }


    @Test
    public void hithelp() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.hithelp();
    }

    @Test
    public void returnpolicy() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.returnpolicy();
    }

    @Test
    public void returnHazard() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.returnHazard();
    }

}

