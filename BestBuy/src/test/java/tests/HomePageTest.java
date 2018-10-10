package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends HomePage {

    @Test
    public void Account() {
        super.Account();
    }
    @Test
    public void ShoppingHistory() {
        super.ShoppingHistory();
    }
    @Test
    public void OrderStatus() {
        super.OrderStatus();
    }
    @Test
    public void SavedItems() {
        super.SavedItems();
    }
    @Test
    public void search() {
        super.search();
    }
    @Test
    public void title(){
        super.title();
    }
}
