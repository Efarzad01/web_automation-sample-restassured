package datatest;

import base.XcelElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reporting.TestLogger;
import utilities.XlsDataReaderUtil;

import java.util.ArrayList;
import java.util.Iterator;

public class XcelReaderTest extends XcelElement {

    XcelReaderTest objExcelFile;
    XcelElement xcelElement;

    @BeforeMethod
    public void initializePageObject() {

        objExcelFile = PageFactory.initElements(driver, XcelReaderTest.class);
        xcelElement = PageFactory.initElements(driver, XcelElement.class);
    }

    @DataProvider
    public Iterator<Object[]> supplyDataExcel() {
        ArrayList<Object[]> testDataExcel = XlsDataReaderUtil.getDataFromExcel();
        return testDataExcel.iterator();
    }

    @Test(priority = 5, dataProvider = "supplyDataExcel")
    public void searchTest(String items) throws InterruptedException {

        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        //  objExcelFile.xcelElement.signInByDataProvider(items);
        String actual = XcelElement.getXcelElement.getText();
        TestLogger.log("Search successful");
        //Assert.assertEquals(message,errmessage);
    }
}
