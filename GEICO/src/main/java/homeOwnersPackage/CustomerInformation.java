package homeOwnersPackage;

import base.CommonAPI;
import dataReader.ConnectToMySQL;
import homePage.InsuranceProducts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class CustomerInformation extends CommonAPI {
    InsuranceProducts object = PageFactory.initElements(driver,InsuranceProducts.class);
    ConnectToMySQL connect = new ConnectToMySQL();
    //test of texts shown in all the help tool tips.
    @FindBy(xpath = "//a[@data-tooltip-view='HelpText-NIP013PIPropertyStreetAddress']")
    public static WebElement streetTip;
    @FindBy(xpath = "//div[@id='HelpText-NIP013PIPropertyStreetAddress']//div[@id='HelpTextDiv']/p")
    public static WebElement streetTipText;
    @FindBy(xpath = "//a[@data-tooltip-view='HelpText-CD010HomesitePolicyEffectiveDate']")
    public static WebElement coverageDateTip;
    @FindBy(xpath = "//div[@id='HelpText-CD010HomesitePolicyEffectiveDate']//div[@id='HelpTextDiv']/p")
    public static WebElement coverageDateTipText;
    @FindBy(xpath = "//a[@data-tooltip-view='HelpText-CD003DateOfBirth']")
    public static WebElement dateOfBirthTip;
    @FindBy(xpath = "//div[@id='HelpText-CD003DateOfBirth']//div[@id='HelpTextDiv']/p")
    public static WebElement dateOfBirthTipText;

    @FindBy(xpath = "//label[@for='CustomerInformationViewData_CD004aMovedRecently_True']")
    public static WebElement radioButton2Yes;
    @FindBy(id = "CD005PriorAddressStreet")
    public static WebElement div1;
    @FindBy(id = "CD006PriorAddressZip")
    public static WebElement div2;
    @FindBy(id = "CD007PriorAddressCity")
    public static WebElement div3;
    @FindBy(id = "CD008PriorAddressState")
    public static WebElement div4;

    public void clickRadioButton(){
        radioButton2Yes.click();
    }
    //test of the warning texts that occur when clicked continue without filling any field
    @FindBy(name = "submitButton")
    public static WebElement continueButton;
    @FindBy(xpath = "//ul[@class='list list--unordered']/li")
    public static List<WebElement> warningList;

    public void clickContinue() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        continueButton.click();
        Thread.sleep(2000);
    }
    public void clickOnHomeOwnersInsurance() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        object.homeOwnersInsuranceIcon.click();
        object.sendZipCodeKeys("11423");
    }
    public String clickToolTip(WebElement toolKit, WebElement toolKitText ) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnHomeOwnersInsurance();
        Thread.sleep(1000);
        toolKit.click();
        waitToBeVisible(toolKitText);
        return toolKitText.getText();
    }
    public List<String> clickContinue1() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnHomeOwnersInsurance();
        clickContinue();
        waitToBeVisible("//ul[@class='list list--unordered']");
        List<String> warningText = new ArrayList<>();
        for(WebElement it: warningList){
            warningText.add(it.getText());
        }
        return warningText;
    }
    public boolean isDivVisible(WebElement element) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickOnHomeOwnersInsurance();
        Thread.sleep(2000);
        clickRadioButton();
        Thread.sleep(1000);
        waitToBeVisible(element);
        return element.isDisplayed();
    }
    public void compareWarningMessage() throws InterruptedException {
        List<String> warningText = clickContinue1();
        List<String> actualText = connect.readData("customerInfo1","warning");
        for (int i=0; i<actualText.size();i++)
            Assert.assertEquals(actualText.get(i),warningText.get(i));
    }
}