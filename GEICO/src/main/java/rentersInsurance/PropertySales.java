package rentersInsurance;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class PropertySales extends CommonAPI {
    @FindBy(xpath = "//label[@for='ho3']")
    public static WebElement homeOwnersRD;
    @FindBy(xpath = "//label[@for='ho4']")
    public static WebElement rentersRD;
    @FindBy(xpath = "//label[@for='ho6']")
    public static WebElement condoRD;
    @FindBy(xpath = "//label[@for='mobile']")
    public static WebElement mobileHomeRD;
    @FindBy(xpath = "//label[@for='dp3']")
    public static WebElement landLordRD;

    public void navigateToPropertyType(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.navigate().to("https://propertysales.geico.com/PropertyTypeLanding");
    }
    public String clickOnElementRD(WebElement element){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        element.click();
        sendKeysToZipCodeBox();
        clickContinue();
        return driver.getCurrentUrl();
    }
    public void clickContinue(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        WebElement continueButton = driver.findElement(By.id("submitButton"));
        continueButton.click();
    }
    public void sendKeysToZipCodeBox(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        WebElement zipCodeBox = driver.findElement(By.id("LandingViewData_NIP001PropertyZip"));
        zipCodeBox.sendKeys("11423");
    }
}
