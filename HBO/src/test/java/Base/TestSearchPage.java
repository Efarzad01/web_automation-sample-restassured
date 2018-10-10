package Base;
import org.testng.annotations.Test;
import pages.SearchPage;

public class TestSearchPage extends SearchPage {
    @Test
    public void click() throws InterruptedException {
        super.click();
    Thread.sleep(4000);
    }
    @Test
    public void search() throws InterruptedException {
        super.search();
    Thread.sleep(4000);
    }

}
