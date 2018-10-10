package homeOwnersPackageTest;

import homeOwnersPackage.CustomerInformation;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class CustomerInformationTest extends CustomerInformation{
    CustomerInformation object;
    @BeforeMethod
    public void init() {
        object = PageFactory.initElements(driver,this.getClass());
    }
    @Test
    public void testStreetTipText() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("This is the actual address of the home, apartment or condo where you reside, and that you desire to insure.",clickToolTip(streetTip,streetTipText));
    }
    @Test
    public void testCoverageDateTipText()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("The effective date of your policy can range from 1-59 days in the future. This is the date your coverage will begin.",clickToolTip(coverageDateTip,coverageDateTipText));
    }
    @Test
    public void testDOB() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        System.out.println(clickToolTip(dateOfBirthTip,dateOfBirthTipText));
    }
    @Test
    public void testWarning1() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        compareWarningMessage();
    }
    @Test
    public void isDivOneVisible() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,isDivVisible(div1));
    }
    @Test
    public void isDivTwoVisible() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,isDivVisible(div2));
    }
    @Test
    public void isDivThreeVisible() throws InterruptedException {
        Assert.assertEquals(true,isDivVisible(div3));
    }
    @Test
    public void isDivFourVisible() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,isDivVisible(div4));
    }
}