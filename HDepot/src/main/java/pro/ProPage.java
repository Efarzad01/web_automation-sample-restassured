package pro;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class ProPage extends CommonAPI {


    public void forthepro() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'For the Pro')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void proXtra() {
        driver.findElement(By.xpath("//div[@id='container']//div[@class='Header3']/div[@class='grid isBound']//ul[@class='TaskLinks']//a[@href='//www.homedepot.com/c/professional_contractor']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Pro Xtra')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='container']/div[2]/div[29]//a[@href='/c/pro_xtra']/span[@class='bttn__content']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    public void govtBuyer() {  ////div[@id='container']//div[@class='Header3']/div[@class='grid isBound']//ul[@class='TaskLinks']//a[@href='//www.homedepot.com/c/professional_contractor']
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'For the Pro')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='container']/div[2]/div[3]/div/div/div[3]/div[3]//p/a[@href='#Government']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='container']//footer[@class='footer']/div[2]/nav[1]/ul[@class='list list--type-plain']//a[@href='https://secure2.homedepot.com/account/view/order/tracking']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='signinEmail']")).sendKeys("homedepot@test.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcd1234");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='orderNumberTrack']")).sendKeys("nhh1232u4y4y3");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).sendKeys("nhh1232u4y4y3");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Pay Your Credit Card')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    ////a[@class='TaskLinks__link'][contains(text(),'Gift Cards')]
    public void giftCards() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Gift Cards')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//img[@title='Mail']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        ((JavascriptExecutor) driver).executeScript("scroll(0,700)");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='plastic-amount']")).sendKeys("10");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Select select = new Select(driver.findElement(By.xpath("//input[@id='plastic-name']")));
        select.selectByVisibleText("Register");

        driver.findElement(By.xpath("//input[@id='plastic-name']")).sendKeys("Sayad Happy");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='plastic-email']")).sendKeys("testing@test.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@id='div_plastic-from_name']//div[@class='no-label']")).sendKeys("Emdadullah farzad");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("#plastic-recipient_first_name']")).sendKeys("Sayad");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }


}


