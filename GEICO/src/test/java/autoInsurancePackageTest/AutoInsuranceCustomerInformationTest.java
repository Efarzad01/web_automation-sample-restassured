package autoInsurancePackageTest;

import autoInsurancePackage.AutoInsuranceCustomerInformation;
import autoInsurancePackage.GetQuote;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoInsuranceCustomerInformationTest extends AutoInsuranceCustomerInformation {
    @BeforeMethod
    public void init(){
        AutoInsuranceCustomerInformationTest obj1 = PageFactory.initElements(driver,AutoInsuranceCustomerInformationTest.class);
        GetQuote obj2 = PageFactory.initElements(driver,GetQuote.class);
    }
    @Test
    public void testFirstNameErrorMessage(){
        clickNextWithoutFillingFirstName();
    }
    @Test
    public void testLastNameErrorMessage(){
        clickNextWithoutFillingLastName();
    }

}