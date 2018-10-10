package motorVehicleTest;

import homePage.InsuranceProducts;
import motorVehicle.MotorVehicleCustomerInformation;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MotorVehicleCustomerInformationTest extends MotorVehicleCustomerInformation {
    @BeforeMethod
    public void init() throws InterruptedException {
        MotorVehicleCustomerInformation obj1 = PageFactory.initElements(driver,MotorVehicleCustomerInformation.class);
        InsuranceProducts obj2 = PageFactory.initElements(driver,InsuranceProducts.class);
        navigateToMotorVehiclePage();
    }
    @Test
    public void testClickOnNoRD(){
        clickOnNoRD();
    }
    @Test
    public void isDivVisible(){
        Assert.assertTrue(isNoDivVisible());
    }
}
