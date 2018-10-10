package screen_shot;

import base.CommonAPI;

import org.testng.annotations.Test;
import reporting.TestLogger;

public class TestScreenShot extends CommonAPI {
    String screenShot1 = "ScreenShot";
    @Test
    public void testCaptureScreenShot(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        captureScreenshot(driver, screenShot1);
    }
}
