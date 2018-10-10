package utility;

import base.CommonAPI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenShots extends CommonAPI {
    // Method to capture screenshot and provide current date
    public static String captureScreenshot(String name) {
        DateFormat dateFormat = new SimpleDateFormat("(HH.mm.yyyy-HH;mma)");
        Date date = new Date();

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = null;

        if (System.getProperty("os.name").contains("Mac")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "/screenshots/" + name + " " + dateFormat.format(date) + ".png");
        } else if (System.getProperty("os.name").contains("Win")) {
            screenshot = new File(System.getProperty("user.dir") +
                    "\\screenshots\\" + name + " " + dateFormat.format(date) + ".png");
        }
        try {
            FileUtils.copyFile(file, screenshot);
        } catch (IOException e) {

        }
        String location = System.getProperty("user.dir") +
                "\\screenshots\\" + name + " " + dateFormat.format(date) + ".png";
        return location;
    }
}
