package homePageTest;

import homePage.InsuranceProducts;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class InsuranceProductsTest extends InsuranceProducts {
    InsuranceProducts insuranceProducts;
    @BeforeMethod
    public void init(){ insuranceProducts = PageFactory.initElements(driver, InsuranceProducts.class);
    }
    @Test
    public void testHomeOwnerInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnIconwithZipCode(homeOwnersInsuranceIcon));
    }
    @Test
    public void testRentersInsurance()throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/Diva/Conversation",clickOnIconwithZipCode(rentersInsuranceIcon));
    }
    @Test
    public void testMotorCycleInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://buy.geico.com/ui/nb#/sale/customerinformation/gskmsi",clickOnIconwithZipCode(motorCycleInsuranceIcon));
    }
    @Test
    public void testCondoInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/CustomerInformation",clickOnIconwithZipCode(condoInsuranceIcon));
    }
    @Test
    public void testBoatInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://boat-prod.geico.com/CustomerInformation",clickOnIconwithZipCode(boatInsuranceIcon));
    }
    @Test
    public void testUmbrellaInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/umbrella-insurance/",clickOnIconWithoutZipCode(umbrellaInsuranceIcon));
    }
    @Test
    public void testRVInsuranceIconClick()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String url = clickOnIconWithoutZipCode(rvInsuranceIcon);
        url = breakString(url);
        String actualUrl = "https://rv.geico.com/sales/(S(fkmghmtlvdw3pz0rykldkdv1))/default.aspx";
        Assert.assertTrue(actualUrl.contains(url));
    }
    @Test
    public void testCollectorAutoInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/collector-auto-insurance/",clickOnIconWithoutZipCode2(collectorAutoIcon) );
    }
    @Test
    public void testMobileHomeInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/mobile-home-insurance/",clickOnIconWithoutZipCode2(mobileHomeIcon));
    }
    /*@Test popup
    public void testFloodInsurance()throws InterruptedException{
        clickOnFloodIcon();
    }*/
    @Test
    public void testCommercialAutoInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/mobile-home-insurance/",clickOnIconWithoutZipCode2(mobileHomeIcon));
    }
    /*@Test popup
    public void testGeneralLiabilityInsurance()throws InterruptedException{
        clickOnGeneralLiabilityIcon();
    }*/
    /*@Test popup
    public void testProfessionalLiabilityInsurance()throws InterruptedException{
        clickOnProfessionalLiabilityIcon();
    }*/
    /*@Test popup
    public void testBusinessOwnersInsurance()throws InterruptedException{
        clickOnBusinessOwnersIcon();
    }*/
    /*@Test popup
    public void testWorkersCompensation(){
    }*/
   /* @Test popup
    public void testLifeInsurance(){}*/
    @Test
    public void testrideSharingInsurance()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/ridesharing-insurance/",clickOnIconWithoutZipCode3(rideSharingIcon) );
    }
    @Test
    public void testTravelInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/travel-insurance/",clickOnIconWithoutZipCode3(travelIsuranceIcon));
    }
    @Test
    public void testOverseasInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/overseas-insurance/",clickOnIconWithoutZipCode3(overseasIsuranceIcon));
    }
    @Test
    public void testIdentityProtection() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://propertysales.geico.com/Generali/CustomerInformation",clickOnIconWithoutZipCode3(identityProtectionIcon));
    }
    /*@Test popUp
    public void testPestInsurance() throws InterruptedException { }*/
    /*@Test popUp
    public void testJewelryInsurance() throws InterruptedException { }*/
    @Test
    public void testLandlordInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("https://www.geico.com/landlord-insurance/",clickOnIconWithoutZipCode3(landlordInsuranceIcon));
    }
    /*@Test popUp
  public void testMexicoAutoInsurance() throws InterruptedException { }*/
    @Test
    public void testErrorMessage1(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode(homeOwnersInsuranceIcon));
    }
    @Test
    public void testErrorMessage2(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode(rentersInsuranceIcon));
    }
    @Test
    public void testErrorMessage3(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode(condoInsuranceIcon));
    }
    @Test
    public void testErrorMessage4(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode(motorCycleInsuranceIcon));
    }
    @Test
    public void testErrorMessage5(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode(boatInsuranceIcon));
    }
    @Test
    public void testErrorMessage6()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode2(commercialAutoIcon));
    }
    @Test
    public void testErrorMessage7()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode3(lifeInsuranceIcon));
    }
    @Test
    public void testErrorMessage8()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals("Please enter a valid ZIP Code.",clickWithoutGivingZipCode3(petInsuranceIcon));
    }
}