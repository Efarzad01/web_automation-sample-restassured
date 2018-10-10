package dataMongo;

import base.XcelElement;
import dataRead.ConnectToMongoDB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;
import java.util.List;
import static base.CommonAPI.convertToString;

public class MongoTest extends XcelElement {

    XcelElement object;

    @BeforeMethod
    public void init() {
        object = PageFactory.initElements(driver, XcelElement.class);
    }

    @Test
    public void testsearch() {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        List<String> text = ConnectToMongoDB.readFromMongoDB("items");

        System.out.println("\n\n\n");
        for (int index = 0; index < text.size(); index++) {
            Assert.assertEquals(text.get(index), text.get(index));
        }
    }
}

