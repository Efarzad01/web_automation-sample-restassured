package autoInsurancePackageTest;

import autoInsurancePackage.GetQuote;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class GetQuoteTest extends GetQuote {
    GetQuote object;
    @BeforeMethod
    public void init(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        object = PageFactory.initElements(driver,GetQuote.class);
    }
    @Test
    public void testGetQuoteButton(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        getQuote();
    }
    @Test
    public void testSkipButton(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        clickSkip();
    }
}