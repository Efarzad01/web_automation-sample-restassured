package pro;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import reporting.TestLogger;

import java.util.concurrent.TimeUnit;

public class CreditCardService extends CommonAPI {


    public void creditService() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Credit Services')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Exclusive Consumer Credit Offers')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void ExclusiveCredit() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Credit Services')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Project Loan Benefits')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void ProjectLoan() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Credit Services')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Commercial Revolving Benefits')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void CommercialAccBenifit() {
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Credit Services')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[contains(text(),'Commercial Account Benefits')]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
         /*driver.findElement(By.xpath("")).click();
         driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);*/


    public boolean isDivVisible(WebElement element) throws InterruptedException {
        // TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        creditService();
        Thread.sleep(2000);
        ExclusiveCredit();
        Thread.sleep(1000);
        // waitToBeVisible(element);
        return element.isDisplayed();
    }
}






