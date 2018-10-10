package Base;
import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HomePage;
import java.util.concurrent.TimeUnit;

public class TestHomePage extends HomePage{
    @Test
    public void click() {
        super.click();
    }
    @Test
    public void search() {
        super.search();
    }
    @Test
    public void movie() { super.movie();}
}
