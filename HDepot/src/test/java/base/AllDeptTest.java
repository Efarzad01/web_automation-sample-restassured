package base;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import reporting.TestLogger;

public class AllDeptTest extends AllDepartment {
    AllDepartment allDepartment;

    @BeforeMethod
    public void init() {
        allDepartment = PageFactory.initElements(driver, AllDepartment.class);
    }

    @Test
    public void mouseHover() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        super.mouseHover();
    }

    @Test
    public void truckRental() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        truckRental();
    }
}
