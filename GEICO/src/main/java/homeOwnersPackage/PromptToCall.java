package homeOwnersPackage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class PromptToCall extends CommonAPI {
    @FindBy(className="errorheader")
    WebElement errorHeadline;
    @FindBy(xpath = "//*[@id=\"home-get-a-quote\"]/div[1]/div/div/p[1]")
    WebElement firstPara;
    @FindBy(xpath = "//*[@id=\"home-get-a-quote\"]/div[1]/div/div/p[2]")
    WebElement secondPara;
    @FindBy(xpath = "//*[@id=\"home-get-a-quote\"]/div[1]/div/div/p[3]")
    WebElement thirdPara;
    @FindBy(linkText = "Return to GEICO.com")
    public static WebElement linkBackToHome;

    public void navigateToPromptCall(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.navigate().to("https://propertysales.geico.com/Error/PromptToCall");
    }
    public String getFirstPara() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return firstPara.getText();
    }
    public String getSecondPara() {
        return secondPara.getText();
    }
    public String getThirdPara() {
        return thirdPara.getText();
    }
    public String clickRetToHome(){
        linkBackToHome.click();
        String url = getCurrentURL();
        return url;
    }
    public String getErrorHeadLine() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        return errorHeadline.getText();
    }
    public String actualFirstPara() {
        return "We appreciate you choosing GEICO for your property insurance needs. Based on the data you provided online, there is additional information needed to provide a quote for this residence. GEICO Insurance Agency provides UNDEFINED quotes through multiple carriers; however, not all of them are available online. Our professional property insurance agents may be able to provide you with a quote over the phone. Your information has been saved, so our agents can refer to it when you call.";
    }
    public String actualHeadLine(){
        return "Thank you for requesting a GEICO UNDEFINED quote.";
    }
    public String actualSecondPara(){
        return "Please contact us at (800) 566-1518 and refer to Quote Number 000000 to continue your quote.";
    }
    public String actualThirdPara(){
        return "Mon.-Fri. 7:00 AM - 1:00 AM EST\n" +
                "Sat. 8:00 AM - 10:30 PM EST\n" +
                "Sun. 8:00 AM - 10:30 PM EST";
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}