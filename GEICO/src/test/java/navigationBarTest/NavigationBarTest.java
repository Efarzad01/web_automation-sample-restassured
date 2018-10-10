package navigationBarTest;

import navigationBar.NavigationBar;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class NavigationBarTest extends NavigationBar {
    NavigationBar n1;
    @BeforeMethod
    public void init(){
        n1 = PageFactory.initElements(driver, NavigationBar.class);
    }
    @Test
    public void testClickInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,clickOnInsurance());
    }
    @Test
    public void testClickInformation() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,clickOnInformation());
    }
    @Test
    public void testClickLocation()throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,clickOnLocationIcon());
    }
    @Test
    public void testClickLogin()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertTrue(clickLogin());
    }
    @Test
    public void testClickSearchIcon()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(true,clickOnSearchIcon());
    }
    @Test
    public void testClickOnGeicoLogo()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/",clickOnGeicoLogo());
    }
}
