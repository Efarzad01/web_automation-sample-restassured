package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver = null;
    public static Actions builder = null;
    public static WebDriverWait wait = null ;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\MyFiles\\Develop\\AutomationFramework\\Framework\\Generic\\browser-driver\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        builder = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.geico.com/");
        driver.manage().window().maximize();
        //Thread.sleep(2000);
    }
    //ExtentReport
    public static ExtentReports extent;
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }
    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//            System.out.println();
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
        driver.close();
    }
    public static void captureScreenshot(WebDriver driver, String screenshotName){

        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        //File file = ((TakesScreenshot) CommonAPI.driver).getScreenshotAs(OutputType.FILE);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitToBeVisible(String xpathLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    //Browser Stack Setup
//    public WebDriver webDriver = null;
//    public String browserstack_username= "shaikhmuhammad1";
//    public String browserstack_accesskey = "Giyxw4f3Bz3qpspQ2iV3";
//    public String saucelabs_username = "";
//    public String saucelabs_accesskey = "";
//
//    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browserName","browserVersion","url"})
//    @BeforeMethod
//    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
//                      @Optional("OS X") String os, @Optional("10") String os_version, @Optional("chrome-options") String browserName, @Optional("34")
//                              String browserVersion, @Optional("http://www.geico.com") String url)throws IOException {
//        System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
//        if(useCloudEnv==true){
//            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
//                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browserName, browserVersion);
//            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
//                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browserName, browserVersion);
//            }
//        }else{
//            getLocalDriver(os, browserName);
//        }
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        webDriver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
//        webDriver.get(url);
//        webDriver.manage().window().maximize();
//    }
//    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver");
//            }else if(OS.equalsIgnoreCase("Windows")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/browser-driver/chromedriver.exe");
//            }
//            webDriver = new ChromeDriver();
//        } else if(browserName.equalsIgnoreCase("chrome-options")){
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-notifications");
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
//            }else if(OS.equalsIgnoreCase("Windows")){
//                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
//            }
//            webDriver = new ChromeDriver(options);
//        }
//
//        else if(browserName.equalsIgnoreCase("firefox")){
//            if(OS.equalsIgnoreCase("OS X")){
//                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver");
//            }else if(OS.equalsIgnoreCase("Windows")) {
//                System.setProperty("webdriver.gecko.driver", "../Generic/browser-driver/geckodriver.exe");
//            }
//            webDriver = new FirefoxDriver();
//
//        } else if(browserName.equalsIgnoreCase("ie")) {
//            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
//            webDriver = new InternetExplorerDriver();
//        }
//        return webDriver;
//
//    }
//
//
//    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
//                                    String browserVersion)throws IOException {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("browser",browserName);
//        cap.setCapability("browser_version",browserVersion);
//        cap.setCapability("os", os);
//        cap.setCapability("os_version", os_version);
//        if(envName.equalsIgnoreCase("Saucelabs")){
//            //resolution for Saucelabs
//            webDriver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
//                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
//        }else if(envName.equalsIgnoreCase("Browserstack")) {
//            cap.setCapability("resolution", "1024x768");
//            webDriver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
//                    "@hub-cloud.browserstack.com/wd/hub"), cap);
//        }
//        return webDriver;
//    }
    public static String convertToString(String st){
        String splitString ;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }

}