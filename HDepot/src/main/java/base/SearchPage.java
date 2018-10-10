package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonAPI {


    @FindBy(xpath = "//div[@class='col__3-12']/nav[1]/span")
    public static WebElement sortByButton;
    @FindBy(xpath = "//*[@id=\'products\']/div/div[1]/div/div[10]/div/a/span")
    public static WebElement addToCart;
    @FindBy(xpath = "//*[@id='products']/div/div[1]/div/div[3]/a")
    public static WebElement product;
    @FindBy(xpath = "//div[@id='layout']/div[3]//li[1]/span/label")
    public static WebElement bestMatchLink;
    @FindBy(xpath = "//div[@id='layout']/div[3]//li[2]/span/label")
    public static WebElement topSellerLink;
    @FindBy(xpath = "//div[@id='layout']/div[3]//li[3]/span/label")
    public static WebElement lowToHighLink;
    @FindBy(xpath = "//div[@id='layout']/div[3]//li[4]/span/label")
    public static WebElement highToLowLink;
    @FindBy(xpath = "//div[@id='layout']/div[3]//li[5]/span/label")
    public static WebElement topRatedLink;
    @FindBy(xpath = "//*[@id='compare205216805']")
    public static WebElement compareButton1;
    @FindBy(xpath = "//*[@id='compare204834499']")
    public static WebElement compareButton2;
    @FindBy(xpath = "//a[@id='comp']")
    public static WebElement compareNow;
    @FindBy(xpath = "//*[@id='products']/div/div[1]//div[5]/a")
    public static WebElement searchItem1;
    @FindBy(xpath = "//*[@id='products']/div/div[2]//div[3]/a")
    public static WebElement searchItem2;
    @FindBy(xpath = "//div[@id='PCPProductsContainer']/div[1]/div[2]//div[2]/a")
    public static WebElement compareItem1;
    @FindBy(xpath = "//div[@id='PCPProductsContainer']/div[1]/div[3]//div[2]/a")
    public static WebElement compareItem2;
    @FindBy(xpath = "//*[@id='buybox__quantity']/div/div/div[2]")
    public static WebElement incrementButton;
    @FindBy(xpath = "//div[@id='calculator-container']//div[2]/div/div[1]/div[1]")
    public static WebElement quantityDisplayed;
    @FindBy(xpath = "//*[@id='buybox__quantity']/div/div/div[1]")
    public static WebElement decrementButton;
    @FindBy(xpath = "//*[@id='text_$0 - $10']")
    public static WebElement priceFilterUnder10;
    @FindBy(xpath = "//*[@id='products']//div[24]//div[6]/span)")
    public static WebElement pageLastItemPrice;
    @FindBy(xpath = "//div[@id='appliedFilters']/div/span[2]/a/span")
    public static WebElement priceSelectionCheck;
    @FindBy(id = "toTopBtn")
    public static WebElement toTopButton;
    @FindBy(xpath = "//footer/div[3]//li[7]/a")
    public static WebElement bottomLink;
    @FindBy(xpath = "//div[text()='My Account']")
    public static WebElement myAccountLink;

    //T3HOM_SR_TC01 verify Best Match link in Sort by dropbox
    public static boolean checkBestMatchSortBy() {
        sortByButton.click();                   //Tried using Select Class but throwing error -Sort by UnexpectedTagNameException
        implicitWait(driver, 40);
        boolean bl = bestMatchLink.isEnabled();
        return bl;
    }

    //T3HOM_S_TC02 verify TopSeller Link under sort By dropbox
    public static boolean checkTopSellerSortBy() {
        sortByButton.click();
        implicitWait(driver, 40);
        boolean bl = topSellerLink.isEnabled();
        return bl;
    }

    //T3HOM_SP_TC03 verify LowToHigh link under sort by dropbox
    public static boolean checkLowToHighSortBy() {
        sortByButton.click();
        implicitWait(driver, 40);
        boolean bl = lowToHighLink.isDisplayed();
        return bl;
    }

    //T3HOM_SP_TC04 verify HighToLow link under sort by dropbox
    public static boolean checkHighToLowSortBy() {
        sortByButton.click();
        implicitWait(driver, 40);
        boolean bl = highToLowLink.isEnabled();
        return bl;
    }

    //T3HOM_SP_TC05 verify TopRated link under sort by dropbox
    public static boolean checkTopRatedSortBy() {
        sortByButton.click();
        implicitWait(driver, 40);
        boolean bl = topRatedLink.isDisplayed();
        return bl;
    }

    //T3HOM_SP_TC06 Get items from Sortby drop box
    public static void getItemsFromSortBy() {
        sortByButton.click();
        List<String> sortByOptions = new ArrayList<>();
        List<WebElement> option = driver.findElements(By.className("sortby__items"));
        for (WebElement we : option) {
            sortByOptions.add(we.getText());
        }
        for (String st : sortByOptions) {
            System.out.println(st);
        }
        System.out.println("Total number of items in SortBy drop box with size(): " + sortByOptions.size());
    }

    //T3HOM_SP_TC07 verify increment Quantity of the product by clicking increment button
    public static String verifyIncrementButton() {
        searchItem1.click();
        implicitWait(driver, 35);
        incrementButton.click();
        String str = quantityDisplayed.getText();
        return str;
    }

    //T3HOM_SP_TC08 verify decrement Quantity of the product by clicking decrement button
    public static String verifyDecrementButton() {
        searchItem1.click();
        implicitWait(driver, 35);
        incrementButton.click();
        decrementButton.click();
        String str = quantityDisplayed.getText();
        return str;
    }

    //T3HOM_SP_TC09 check Price filter under $10 check box
    public static boolean verifyPriceFilter() {
        priceFilterUnder10.click();
        implicitWait(driver, 35);
        boolean bl = priceFilterUnder10.isSelected();
        return bl;
    }

    //T3HOM_SP_T10 verify Price filter under $10 selection feature
    public static String goToPriceFilter() {
        priceFilterUnder10.click();
        implicitWait(driver, 35);
        String str = priceSelectionCheck.getText();
        return str;
    }

    //Click add to cart and continue with the next page
    public static void goToCart() {
        addToCart.click();
    }

    //T3HOM_SP_T11 verify scrollDown
    public static String checkScrollDown() {
        searchItem1.click();
        implicitWait(driver, 35);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        implicitWait(driver, 30);
        String str = bottomLink.getAttribute("title");
        return str;
    }
}


