
package prohometest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pro.ProPage;
import reporting.TestLogger;
//import reporting.TestLogger;

public class Protest extends ProPage{
    ProPage proPage;

    @BeforeMethod
    public void inint(){
      proPage = PageFactory.initElements(driver, ProPage.class);
    }
    @Test
    public void forthepro(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        super.forthepro();
    }

    @Test
    public void proXtra(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        super.proXtra();
    }

    @Test
    public void govtBuyer() {
       TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        super.govtBuyer();
    }
}