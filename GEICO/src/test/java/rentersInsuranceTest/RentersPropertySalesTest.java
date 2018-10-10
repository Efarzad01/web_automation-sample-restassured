package rentersInsuranceTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rentersInsurance.PropertySales;
import rentersInsurance.RentersPropertySales;
import reporting.TestLogger;

public class RentersPropertySalesTest extends RentersPropertySales {
    @BeforeMethod
    public void init(){
        PropertySales obj1 = PageFactory.initElements(driver,PropertySales.class);
        RentersPropertySales obj = PageFactory.initElements(driver,RentersPropertySales.class);
        //navigateToConversation();
    }
    @Test
    public void testMovingClick(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnMoving();
    }
}