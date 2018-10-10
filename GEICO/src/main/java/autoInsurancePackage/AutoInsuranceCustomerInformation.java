package autoInsurancePackage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoInsuranceCustomerInformation extends CommonAPI {
    GetQuote obj = new GetQuote();
    @FindBy(id = "firstName-error")
    WebElement firstNameErrorMessage;
    @FindBy(id = "lastName-error")
    WebElement lastNameErrorMessage;
    @FindBy(css = ".btn.btn--primary.btn--full-mobile.btn-spotlight")
    public static WebElement nextButton;
    public WebElement getFirstNameErrorMessage() {
        return firstNameErrorMessage;
    }
    public WebElement getLastNameErrorMessage() {
        return lastNameErrorMessage;
    }
    public void clickNextButton(){
        nextButton.click();
    }
    public String clickNextWithoutFillingFirstName(){
        obj.clickSkip();
        clickNextButton();
        return getFirstNameErrorMessage().getText();
    }
    public String clickNextWithoutFillingLastName(){
        obj.clickSkip();
        clickNextButton();
        return getLastNameErrorMessage().getText();
    }
}