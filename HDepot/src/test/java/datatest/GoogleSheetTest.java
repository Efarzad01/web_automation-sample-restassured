package datatest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reader.GoogleSheetClass;
import reporting.TestLogger;
import java.io.IOException;

public class GoogleSheetTest extends GoogleSheetClass {

    GoogleSheetClass googleSheetsPage;

    @BeforeMethod
    public void initialization() {
        googleSheetsPage = PageFactory.initElements(driver, GoogleSheetClass.class);
    }

    @Test
    public void testLogInByInvalidIdPassUsingGoolgleSheet() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        sendSpreadSheetIdAndRange("14EfsBG7kNeDYSfywfm4KU45BJdd-n0v3XCM19iYAzME", "Sheet1!A2:A4");
    }
}

