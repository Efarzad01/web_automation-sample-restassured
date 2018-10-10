package homePageTest;

import dataReader.ConnectToMySQL;
import homePage.Feedback;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends Feedback {
    ConnectToMySQL connect = new ConnectToMySQL();
    Feedback objFeedback;
    @BeforeMethod
    public void init(){
        objFeedback = PageFactory.initElements(driver,Feedback.class);
    }
    @Test
    public void testFeedback(){
        giveFeedback();
    }
    /*@Test
    public void test1() throws Exception {
        connect.createTable("table1","col1");
    }*/
}