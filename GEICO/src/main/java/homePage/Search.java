package homePage;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import reporting.TestLogger;

public class Search extends CommonAPI {
    @FindBy(xpath = "//*[@id=\"primary-navigationBar\"]/div[6]/form/input")
    public static WebElement searchTextBox;
    @FindBy(xpath = "//*[@id=\"primary-navigationBar\"]/div[6]/form/button")
    public static WebElement searchSubmitButton;
    @FindBy(css = "#header-right-links > ul > li:nth-child(3) > a > span")
    public static WebElement searchIcon;

    public static  void waitToBeVisible(){
        TestLogger.log(Search.class.getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        searchIcon.click();
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));
    }
    public void searchWithENTER(String searchKeys){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        waitToBeVisible();
        searchTextBox.sendKeys(searchKeys, Keys.ENTER);
    }
    public void searchUsingButton(String searchKeys){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        waitToBeVisible();
        searchTextBox.sendKeys(searchKeys);
        searchSubmitButton.click();
    }
}
