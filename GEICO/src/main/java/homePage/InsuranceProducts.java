package homePage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import reporting.TestLogger;

public class InsuranceProducts extends CommonAPI {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    @FindBy(css = "#header-left-links > ul> li > a")
    public static WebElement insurance;
    @FindBy(css = "#header-middle-links > a")
    public static WebElement geicoLogo;
    @FindBy(css = "#header-right-links>ul>li>a>span.icon-geolocation")
    public static WebElement locationIcon;
    @FindBy(css = "#header-right-links>ul>li:nth-child(2)>a")
    public static WebElement login;
    @FindBy(css = "#header-right-links > ul > li:nth-child(3) > a > span")
    public static WebElement searchIcon;

    @FindBy(how = How.CSS, using = "#submitButton")
    public static WebElement submitButton;
    @FindBy(how=How.ID, using = "zip")
    public static WebElement zipCodeTextBox;
    @FindBy(how = How.CLASS_NAME, using = "icon-chevron-right")
    public static WebElement rightArrow;
    @FindBy(css = ".chevron.icon-chevron-right.highlighted")
    public static WebElement rightArrow2;
    @FindBy(css=".chevron.icon-chevron-right.highlighted")
    public static WebElement rightArrow3;

    @FindBy(css = "#home > div > span")
    public static WebElement homeOwnersInsuranceIcon;
    @FindBy(css = ".icon-renters-ins")
    public static WebElement rentersInsuranceIcon;
    @FindBy(css = ".icon-condo-ins")
    public static WebElement condoInsuranceIcon;
    @FindBy(css = ".icon-motorcycle")
    public static WebElement motorCycleInsuranceIcon;
    @FindBy(css = ".icon-boat-ins")
    public static WebElement boatInsuranceIcon;
    @FindBy(css = ".icon-umbrella-ins")
    public static WebElement umbrellaInsuranceIcon;
    @FindBy(css = ".icon-rv-ins")
    public static WebElement rvInsuranceIcon;
    @FindBy(css = ".icon-auto-collector-ins")

    public static WebElement collectorAutoIcon;
    @FindBy(css = ".icon.icon-mobile-home-ins")
    public static WebElement mobileHomeIcon;
    @FindBy(css = ".icon-flood-ins")
    public static WebElement floodIcon;
    @FindBy(css = ".icon-commercial-ins")
    public static WebElement commercialAutoIcon;
    @FindBy(css = "#general > div > span")
    public static WebElement generalLiabilityIcon;
    @FindBy(css = ".icon-professional-liability")
    public static WebElement professionalLiability;
    @FindBy(css = "#businessowners > div > span")
    public static WebElement businessOwnersIcon;
    @FindBy(xpath = "//div[@id='workerscompensation']//span")
    public static WebElement workersCompensationIcon;

    @FindBy(className = "icon icon-life-ins")
    public static WebElement lifeInsuranceIcon;
    @FindBy(css = ".icon.icon-car-sharing")
    public static WebElement rideSharingIcon;
    @FindBy(css = ".icon.icon-travel")
    public static WebElement travelIsuranceIcon;
    @FindBy(css = ".icon.icon-overseas-ins")
    public static WebElement overseasIsuranceIcon;
    @FindBy(css = ".icon.icon-id-protection-ins")
    public static WebElement identityProtectionIcon;
    @FindBy(css = ".icon.icon-pet-ins")
    public static WebElement petInsuranceIcon;
    @FindBy(css = ".icon.icon-collectibles-ins")
    public static WebElement jewelryInsuranceIcon;
    @FindBy(css = "#landlord>.circle>.icon.icon-homeowner-ins")
    public static WebElement landlordInsuranceIcon;
    @FindBy(css = "#mexicoAuto>.circle>.icon.icon-vehicle")
    public static WebElement mexicoAutoIcon;

    public String clickWithoutGivingZipCode(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        element.click();
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("aria-homepage-zip-alert"));
        return errorMessage.getText();
    }
    public String clickWithoutGivingZipCode2(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goRight();
        element.click();
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("aria-homepage-zip-alert"));
        return errorMessage.getText();
    }
    public String clickWithoutGivingZipCode3(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goDoubleRight();
        element.click();
        submitButton.click();
        WebElement errorMessage = driver.findElement(By.id("aria-homepage-zip-alert"));
        return errorMessage.getText();
    }
    public String clickOnIconwithZipCode(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        element.click();
        return sendZipCodeKeys("11423");
    }
    public String clickOnIconWithoutZipCode(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        element.click();
        return clickStartQuote();
    }
    public String clickOnIconwithZipCode2(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goRight();
        element.click();
        return sendZipCodeKeys("11423");
    }
    public String clickOnIconWithoutZipCode2(WebElement element)throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goRight();
        element.click();
        return clickStartQuote();
    }
    public String clickOnIconwithZipCode3(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goDoubleRight();
        element.click();
        return sendZipCodeKeys("11423");
    }
    public String clickOnIconWithoutZipCode3(WebElement element)throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goDoubleRight();
        element.click();
        return clickStartQuote();
    }
    public String clickOnIconWithoutZipCode4(WebElement element)throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goTripleRight();
        element.click();
        return clickStartQuote();
    }

    public void goRight() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        rightArrow.click();
        Thread.sleep(1500);
    }
    public void goDoubleRight()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goRight();
        rightArrow2.click();
        Thread.sleep(1500);
    }
    public void goTripleRight()throws InterruptedException{
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        goDoubleRight();
        rightArrow3.click();
        Thread.sleep(1500);
    }
    public String clickStartQuote() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        submitButton.click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        return url;
    }
    public String sendZipCodeKeys(String zipCode) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        zipCodeTextBox.sendKeys(zipCode);
        submitButton.click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        return url;
    }
    public String breakString(String url){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        String[] arr = url.split("S");
        return arr[0];
    }
}