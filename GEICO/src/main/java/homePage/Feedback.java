package homePage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class Feedback extends CommonAPI {

    @FindBy(className="//a[@class='oo_tab_right']")
    public WebElement feedbackTab;
    @FindBy(name = "OnlineOpinion1")
    public WebElement iframe;
    @FindBy(xpath = "//label[@for='overall_0']")
    public WebElement veryDissatisfied;
    @FindBy(xpath = "//div[@id='foot']/button")
    public static WebElement submitButton;
    public void switchToFrame(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        waitToBeVisible(feedbackTab);
        System.out.println(feedbackTab.getText());
        /*feedbackTab.click();
        waitToBeVisible(iframe);
        driver.switchTo().frame("OnlineOpinion1");*/
        // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
    public void clickVeryDissatisfied(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        veryDissatisfied.click();
    }
    public void clickSubmit(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        submitButton.click();
    }
    public void giveFeedback(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        switchToFrame();
        /*clickVeryDissatisfied();
        clickSubmit();
        driver.switchTo().defaultContent();*/
    }
}