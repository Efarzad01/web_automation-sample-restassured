package list;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ListOf extends CommonAPI {


    @FindBy(xpath = "//a[text()='Check Order Status']")
    public static WebElement orderStatusLink;
    @FindBy(xpath = "//a[text()='Pay Your Credit Card']")
    public static WebElement payCreditCardLink;
    @FindBy(xpath = "//a[text()='Order Cancellation']")
    public static WebElement orderCancellationLink;
    @FindBy(xpath = "//a[text()='Returns']")
    public static WebElement returnsLink;
    @FindBy(xpath = "//a[text()='Specials & Offers']")
    public static WebElement specialsOffersLink;
    @FindBy(xpath = "//a[text()='DIY Projects & Ideas']")
    public static WebElement DIYProjectsLink;
    @FindBy(xpath = "//a[text()='Truck & Tool Rental']")
    public static WebElement truckToolRentalLink;
    @FindBy(xpath = "//a[text()='Home Services']")
    public static WebElement homeServicesLink;
    @FindBy(xpath = "//a[text()='Careers']")
    public static WebElement careersLink;
    @FindBy(xpath = "//a[text()='Corporate Information']")
    public static WebElement corporateInformationLink;
    @FindBy(xpath = "//a[text()='Digital Newsroom']")
    public static WebElement digitalNewsroomLink;
    @FindBy(xpath = "//a[text()='Home Depot Foundation']")
    public static WebElement homeDepotFoundationLink;
    @FindBy(xpath = "//a[text()='The Home Depot Canada']")
    public static WebElement homeDepotCanadaLink;
    @FindBy(xpath = "//a[text()='The Home Depot Mexico']")
    public static WebElement homeDepotMexicoLink;
    @FindBy(xpath = "//a[text()='Blinds.com']")
    public static WebElement blindsLink;
    @FindBy(id = "footerEmail")
    public static WebElement footerEmailBox;
    @FindBy(xpath = "//button[@type='submit']")
    public static WebElement submitButton;
    @FindBy(xpath = "//a[@title='Home Depot on Facebook']")
    public static WebElement facebookLink;
    @FindBy(xpath = "//a[@title='Home Depot on YouTube']")
    public static WebElement youtubeLink;
    @FindBy(xpath = "//a[@title='Home Depot Mobile Apps']")
    public static WebElement mobileAppLink;
    @FindBy(xpath = "//a[@title='Home Depot on Pintrest']")
    public static WebElement pinterestLink;
    @FindBy(xpath = "//*[@id='react-global-header']//div[1]/div[2]/section[2]//span[2]")
    public static WebElement victoriaLocation;
    @FindBy(xpath = "//div[@class='footerEmailSignup__signUpMessage--text']")
    public static WebElement alertWindowText;


    //T3HOM_FP_TC01 Verify 'Check Order Status'
    public boolean verifyCheckOrderStatus() {

        Boolean dis = orderStatusLink.isDisplayed();

        return dis;
    }

    //T3HOM_FP_TC02 verify 'Pay Credit card' link
    public boolean verifyPayCreditCard() {
        Boolean dis = payCreditCardLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC03 verify 'Order Cancellation' link
    public boolean verifyOrderCancellation() {
        Boolean dis = orderCancellationLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC04 verify 'Returns' link
    public boolean verifyReturns() {
        Boolean dis = returnsLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC05 verify 'Special & Offers' link
    public boolean verifySpecialOffers() {
        Boolean dis = specialsOffersLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC06 verify 'DIY Project & Ideas' link
    public static boolean verifyDIYProjectIdeas() {
        Boolean dis = DIYProjectsLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC07 verify 'Truck & Tool Rental' link
    public static boolean verifyTruckToolRental() {
        Boolean dis = truckToolRentalLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC08 verify 'Home Services' link
    public static boolean verifyHomeServices() {
        Boolean dis = homeServicesLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC09 verify 'Careers' link
    public static boolean verifyCareers() {
        Boolean dis = careersLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC10 verify 'Corporate Information' link
    public static boolean verifyCorporateInformation() {
        Boolean dis = corporateInformationLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC11 verify 'Digital Newsroom' link
    public static boolean verifyDigitalNewsroom() {
        Boolean dis = digitalNewsroomLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC12 verify 'Home Depot Foundation' link
    public static boolean verifyHomeDepotFondation() {
        Boolean dis = homeDepotFoundationLink.isDisplayed();
        return dis;
    }

    //T3HOM_FP_TC13 click on 'Home Depot Canada' link and get title of the page
    public static String goToHomeDepotCanada() {
        String parentWindowHandle = driver.getWindowHandle(); //get parent window handle
        homeDepotCanadaLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        implicitWait(driver, 40);
        String str = victoriaLocation.getText();
        driver.switchTo().window(parentWindowHandle);
        return str;
    }

    //T3HOM_FP_TC14 verify FooterEmail function
    public static String enterFooterEmail() {
        footerEmailBox.sendKeys("aarti@gmail.com");
        submitButton.click();
        driver.switchTo().frame(1);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);          //switch to child window
        }
        String str = alertWindowText.getText();
        System.out.println("Text in Popup Window: " + str);
        implicitWait(driver, 35);
        return str;
    }

    //T3HOM_FP_TC15 verify Facebook link and return back to Home Depot page
    public static String verifyFacebookLink() {
        String parentWindowHandle = driver.getWindowHandle();  //get parent window handle
        facebookLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);          //switch to child window
        }
        String str = driver.getCurrentUrl();
        driver.switchTo().window(parentWindowHandle);  //switch back to parent window
        return str;
    }

    //T3HOM_FP_TC16 verify Youtube link and return back to Home Depot page
    public static String verifyYoutubeLink() {
        String parentWindowHandle = driver.getWindowHandle();  //get parent window handle
        youtubeLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);          //switch to child window
        }
        String str = driver.getTitle();
        driver.switchTo().window(parentWindowHandle);  //switch back to parent window
        return str;
    }

    //T3HOM_FP_TC17 verify Mobile App link and return back to Home Depot page
    public static String verifyMobileAppLink() {
        String parentWindowHandle = driver.getWindowHandle();  //get parent window handle
        mobileAppLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);          //switch to child window
        }
        implicitWait(driver, 20);
        String str = driver.getTitle();
        driver.switchTo().window(parentWindowHandle);  //switch back to parent window
        return str;
    }

    //T3HOM_FP_TC18 verify Pinterest link and return back to Home Depot page
    public static String verifyPinterestLink() {
        String parentWindowHandle = driver.getWindowHandle();  //get parent window handle
        pinterestLink.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);          //switch to child window
        }
        String str = driver.getTitle();
        driver.switchTo().window(parentWindowHandle);  //switch back to parent window
        return str;
    }
}




