package motorVehicle;

import base.CommonAPI;
import homePage.InsuranceProducts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MotorVehicleCustomerInformation extends CommonAPI {
    InsuranceProducts obj = new InsuranceProducts();
    @FindBy(css = "#mainContent > div.padding-top > form > div:nth-child(2) > div:nth-child(3)")
    public static WebElement noDIv;
    public void navigateToMotorVehiclePage() throws InterruptedException {
        WebElement motorVehicle = InsuranceProducts.motorCycleInsuranceIcon;
        obj.clickOnIconwithZipCode(motorVehicle);
    }
    public void clickOnNoRD(){
        driver.findElement(By.xpath("//label[@for='hasGeico1']")).click();
    }
    public boolean isNoDivVisible(){
        clickOnNoRD();
        waitToBeVisible(noDIv);
        return noDIv.isDisplayed();
    }
}