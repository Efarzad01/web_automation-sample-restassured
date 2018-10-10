package homePageTest;

import dataReader.GoogleSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;
import java.io.IOException;

public class LoginTestGoogleSheet extends GoogleSheet {

    GoogleSheet GoogleSheetPage;
    @BeforeMethod
    public void initialization(){
        GoogleSheetPage = PageFactory.initElements(driver,GoogleSheet.class);
    }
    @Test
    public void testLogInByInvalidIdPassUsingGoolgleSheet() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        sendSpreadSheetIdAndRange("1WLJxQ97DTKoz4QR5KlXinQaXx8pGGC8gB-CnfNyYM20","Sheet1!A2:E");
    }
}
