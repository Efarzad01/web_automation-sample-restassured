package navigationBar;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

import java.util.List;

public class InformationAndInsuranceHover extends CommonAPI {
    @FindBy(css = "ul.desktop-links > li:nth-child(2)>a")
    public static WebElement information;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul")
    public static WebElement informationDiv;
    @FindBy(xpath = "//div[@data-side-panel='information']/ul/li/a/span[2]")
    public static WebElement infoMenuElements;
    public static String informationDivPath = "//div[@data-side-panel='information']/ul";
    public static String infoMenuElementsPath = "//div[@data-side-panel='information']/ul/li/a/span[2]";

    public List<WebElement> getInformationMenuList(String parentXpath, String childXpath) {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        waitToBeVisible(parentXpath);
        // WebElement divUL = driver.findElement(By.xpath(parentXpath));
        List<WebElement> unorderedList = driver.findElements(By.xpath(childXpath));
        //List<WebElement> unorderedList = divUL.findElements(By.xpath(childXpath));
        return unorderedList;
    }

    public List<WebElement> getInformationMenuList() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        information.click();
        List<WebElement> li = getInformationMenuList(informationDivPath, infoMenuElementsPath);
        return li;
    }
}