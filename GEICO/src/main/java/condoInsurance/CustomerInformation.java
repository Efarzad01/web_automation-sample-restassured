package condoInsurance;

import base.CommonAPI;
import homePage.InsuranceProducts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import dataReader.ConnectToMySQL;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CustomerInformation extends CommonAPI {
    InsuranceProducts obj = new InsuranceProducts();
    ConnectToMySQL con = new ConnectToMySQL();
    @FindBy(id = "submitButton")
    public static WebElement continueButton;

    public void navigateToCustomerInfo() throws InterruptedException {
        ////*[@id="HelpText-CD003DateOfBirth"]/div/div/p
        WebElement condo = InsuranceProducts.condoInsuranceIcon;
        obj.clickOnIconwithZipCode(condo);
    }
    public void clickContinue(){
        continueButton.click();
    }
    public void getAllErrorMessage() throws Exception {
        clickContinue();
        waitToBeVisible(driver.findElement(By.id("validationSummary")));
        List<WebElement> warningList = driver.findElements(By.xpath("//ul[@class='list list--unordered']/li"));
        List<String> warningText = new ArrayList<>();
        for(WebElement ele: warningList) {
            warningText.add(ele.getText());
        }
        List<String> actualText= con.readData("condoWarning","warningList");
        for(int i=0;i<actualText.size();i++){
            Assert.assertEquals(actualText.get(i),warningText.get(i));
        }

    }
    public void firstName(){
        driver.findElement(By.xpath("//input[@id='CustomerInformationViewData_NIP002PIFirstName']")).sendKeys("farooq");
        clickContinue();
    }
    public void lastName(){
        driver.findElement(By.xpath("//input[@id='CustomerInformationViewData_NIP003PILastName']")).sendKeys("farooq");
        clickContinue();
    }
    public void address(){
        driver.findElement(By.xpath("//input[@id='CustomerInformationViewData_NIP013PIPropertyStreetAddress']")).sendKeys("farooq");
        clickContinue();
    }
    public void city(){
        Select cityDropDown = new Select(driver.findElement(By.xpath("//select[@id='CustomerInformationViewData_NIP015PIPropertyCityList']")));
        List<WebElement> cityOptions = cityDropDown.getOptions();
        for(WebElement wb:cityOptions){
            System.out.println(wb.getText());
        }
    }
    public void propertyCoverage20000(){
        driver.findElement(By.xpath("//label[@for='CustomerInformationViewData_NIP027aPersonalPropertyCoverageCAmount_20000']")).click();
    }
    public void propertyCoverage30000(){
        driver.findElement(By.xpath("//label[@for='CustomerInformationViewData_NIP027aPersonalPropertyCoverageCAmount_30000']")).click();
    }
    public void propertyCoverage40000(){
        driver.findElement(By.xpath("//label[@for='CustomerInformationViewData_NIP027aPersonalPropertyCoverageCAmount_40000']")).click();
    }
    public void propertyCoverage50000(){
        driver.findElement(By.xpath("//label[@for='CustomerInformationViewData_NIP027aPersonalPropertyCoverageCAmount_50000']")).click();
    }
    public void propertyCoverageOther(){
        driver.findElement(By.xpath("//label[@for='CustomerInformationViewData_NIP027aPersonalPropertyCoverageCAmount_Other_Amount']")).click();
    }
}