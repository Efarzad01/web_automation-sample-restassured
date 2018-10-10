package homeOwnersPackageTest;

import homeOwnersPackage.PromptToCall;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class PromptToCallTest extends PromptToCall {
    PromptToCall objePTC;
    @BeforeMethod
    public void init(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        objePTC = PageFactory.initElements(driver,PromptToCall.class);
        objePTC.navigateToPromptCall();
    }
    @Test
    public void testHeadLine(){
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        Assert.assertEquals(objePTC.actualHeadLine(),objePTC.getErrorHeadLine());
    }
    @Test
    public void testPara1(){
        Assert.assertEquals(objePTC.actualFirstPara(),objePTC.getFirstPara());
    }
    @Test
    public void testPara2(){
        Assert.assertEquals(objePTC.actualSecondPara() ,objePTC.getSecondPara());
    }
    @Test
    public void testPara3(){
        Assert.assertEquals(objePTC.actualThirdPara() ,objePTC.getThirdPara());
    }
    @Test
    public void testLinkToBackHome(){
        Assert.assertEquals("https://www.geico.com/",objePTC.clickRetToHome());
    }
}