package rentersInsuranceTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rentersInsurance.PropertySales;
import reporting.TestLogger;


public class PropertySalesTest extends PropertySales {
    @BeforeMethod
    public void init(){
        PropertySales obj1 = PageFactory.initElements(driver, PropertySales.class);
        navigateToPropertyType();
    }
    @Test
    public void testClickOnHomeOwnersRD(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(homeOwnersRD));
    }
    @Test
    public void testClickOnRentersRD(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/Diva/Conversation",clickOnElementRD(rentersRD));
    }
    @Test
    public void testClickOnCondoRD(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(condoRD));
    }
    @Test
    public void testClickOnMobileHomeRD(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/MobileHome/PleaseCall",clickOnElementRD(mobileHomeRD));
    }
    @Test
    public void testClickOnLandLordRD(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnElementRD(landLordRD));
    }
}