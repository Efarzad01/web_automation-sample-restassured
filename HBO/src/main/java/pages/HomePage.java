package pages;


import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {

    public void click() {
        driver.findElement(By.cssSelector(".bands\\/MainNavigation--topBar .components\\/BasicButton--children")).click();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
    public void search() {
        driver.findElement(By.id("headerSearch")).sendKeys("Game", Keys.ENTER);
    }
    public void movie() {
        driver.findElement(By.xpath("//a[contains(@text(),'Movies')]")).click();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }

}