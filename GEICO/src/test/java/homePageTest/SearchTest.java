package homePageTest;

import homePage.Search;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class SearchTest extends Search {
    public String keys = "vehicle";
    Search search;
    @BeforeMethod
    public void init(){
        search = PageFactory.initElements(driver,Search.class);
    }
    @Test
    public void testSearchWithoutButton(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        searchWithENTER(keys);
    }
    @Test
    public void testSearchWithButton(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        searchUsingButton(keys);
    }
}
