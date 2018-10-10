package testKeywordDriven;

import keyworddriven.Features;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestKeyDriven extends Features {

    Features features;

    @BeforeMethod
    public void init() {
        features = PageFactory.initElements(driver, Features.class);
    }

    @Test
    public void testFeatures() throws IOException, InterruptedException {
        features = PageFactory.initElements(driver, Features.class);
        features.bathroomItems();
    }
}


