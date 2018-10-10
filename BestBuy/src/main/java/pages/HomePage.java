package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonAPI {

    public void title(){
        System.out.println(driver.getTitle());
    }
    public void Account() {
        driver.findElement(By.cssSelector("#hf_accountMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String AccountPage = driver.findElement(By.xpath("//*[@id=\"account-menu-app\"]/div/div[2]/div/div/a/button")).getText();
        if (AccountPage.equalsIgnoreCase("Sign In")){
            System.out.println("Sign In is displayed");
        }
        else System.out.println("Sign In is not displayed");
    }
    public void ShoppingHistory() {
        driver.findElement(By.cssSelector("#hf_historyMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String ShoppingHistory = driver.findElement(By.cssSelector(".nav-carousel-header-content span")).getText();
        if (ShoppingHistory.equalsIgnoreCase("Shopping History")){
            System.out.println("Shopping History is displayed");
        }
        else System.out.println("Shopping History is not displayed");
    }
    public void OrderStatus() {
        driver.findElement(By.cssSelector("#hf_orderStatusMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String OrderStatus = driver.findElement(By.cssSelector("[href] .btn-secondary")).getText();
        if (OrderStatus.equalsIgnoreCase("Continue")){
            System.out.println("Continue Button is displayed");
        }
        else System.out.println("Continue Button is not displayed");
    }
    public void SavedItems() {
        driver.findElement(By.cssSelector("#hf_listsMenuLink")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void search() {
        driver.findElement(By.cssSelector("[placeholder='Search Best Buy']")).sendKeys("smart tv", Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}