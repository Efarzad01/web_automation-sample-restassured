package helppage;

import base.CommonAPI;
import org.openqa.selenium.By;
import reporting.TestLogger;

public class Help extends CommonAPI {


    public void hithelp() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Help')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'View Return Policy')]")).click();
        Thread.sleep(2000);

    }

    public void returnpolicy() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Help')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'View Return Policy')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//section[contains(@class,'accordion__wrapper')]//div[1]//label[1]")).click();
        Thread.sleep(2000);

    }

    //returning hazard
    public void returnHazard() throws InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.xpath("//a[@class='TaskLinks__link'][contains(text(),'Help')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'View Return Policy')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//section[contains(@class,'accordion__wrapper')]//div[1]//label[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[9]/div[2]/div[1]/section[1]/div[3]/label[1]")).click();
        Thread.sleep(2000);
    }
}