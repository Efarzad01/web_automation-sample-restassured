package base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reporting.TestLogger;


import java.util.concurrent.TimeUnit;


public class Home extends CommonAPI {


    @FindBy(css = "#headerMyAccount .SimpleFlyout__link--bold")
    WebElement tabmyaccount;

    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    WebElement tabonsignin;

    @FindBy(xpath = "//div[@class='MyStore__store']")
    public static WebElement location;

    @FindBy(xpath = "//div[#'headerMyAccountTitle']/div[@innertext='My Account']")
    public static WebElement myAccButton;


    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    public static WebElement signin;

    @FindBy(how = How.CSS, using = "#headerMyAccount .SimpleFlyout__link--bold")
    public static WebElement myAccount;

    @FindBy(how = How.CSS, using = "#.MyCart__label")
    public static WebElement cart;

    @FindBy(how = How.CSS, using = "#[href='\\/b\\/Holiday-Decorations-Halloween-Decorations\\/N-5yc1vZc2ve'] img")
    public static WebElement imgRegardingHallowin;

    @FindBy(how = How.CSS, using = "[href='https\\:\\/\\/www\\.redcross\\.org\\/donate\\/cm\\/homedepot-pub\\.html\\/'] img")
    public static WebElement donateNowTab;

    //#container [class='  col__6-12 col__6-12--xs col__6-12--sm col__6-12--md col__6-12--lg col__6-12--xl']:nth-of-type(3) img
    @FindBy(how = How.CSS, using = "#container [class='  col__6-12 col__6-12--xs col__6-12--sm col__6-12--md col__6-12--lg col__6-12--xl']:nth-of-type(3) img")
    public static WebElement supportingLocal;


    @FindBy(id = "headerSearch")
    public static WebElement searchBox;


    public void cart() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector(".MyCart__label")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void ShopByRoom() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector(".ShoppingLinks [data-id='room']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void homeServices() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.xpath("/html//div[@id='container']//div[@class='Header3']//ul[@class='ShoppingLinks']//a[@href='//www.homedepot.com/services/']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
    }


    public void specialsAndOffers() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.xpath("/html//div[@id='container']//div[@class='Header3']//ul[@class='ShoppingLinks']//a[@href='//www.homedepot.com/c/Savings_Center']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void storeFinder() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector(".TaskLinks .TaskLinks__item:nth-of-type(1) .TaskLinks__link")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html//input[@id='storeSearchBox']")).sendKeys("Astoria", Keys.ENTER);
        Thread.sleep(2000);

//        driver.findElement(By.xpath("//div[@id='SFControl']/section/section[@class='addressDYM']//a[@href='/l/search/lat:40.7720489501953;lng:-73.9260635375977/full/']")).click();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    public void myAccount(String email, String password) throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector("#headerMyAccount .SimpleFlyout__link--bold")).click();
        //tabmyaccount.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
        //tabonsignin.click();
        Thread.sleep(7000);
    }


    public void myAccount() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        driver.findElement(By.cssSelector("#headerMyAccount .SimpleFlyout__link--bold")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
        //tabmyaccount.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='login-popup__model']//input[@id='email_id']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='password']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void goToLoginPage() {

        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        driver.findElement(By.cssSelector("#headerMyAccount .SimpleFlyout__link--bold")).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(signin));
        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
    }


    public void login() {

        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector("#headerMyAccount .SimpleFlyout__link--bold")).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(signin));
        driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class='login-popup__model']//input[@id='email_id']")).sendKeys("kjhkja@test.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcdjdj");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[@class='bttn__content'][contains(text(),'Sign In')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /* Select select = new Select(driver.findElement(By.xpath("//span[contains(text(),'Register')]")));
        select.selectByVisibleText("Register");*/


    public static void goToSearchProductPage() {


        searchBox.sendKeys("floor tiles", Keys.ENTER);
    }

    public void search() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector("#headerSearch")).sendKeys("Washing Machine", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
}









