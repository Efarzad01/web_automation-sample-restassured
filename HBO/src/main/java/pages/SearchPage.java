package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class SearchPage extends CommonAPI {

    public void click() throws InterruptedException {
        driver.findElement(By.cssSelector(".bands\\/MainNavigation--topBar .bands\\/MainNavigation--searchIcon")).click();
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
    }
    public void search() throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='text'']")).sendKeys("Game of Throne", Keys.ENTER);
    }

}
