package stepDefinition;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {
    private String sBrowser = "";
    public static WebDriver driver = null;

    @Before
    public boolean initBrowser() {
        sBrowser = System.getProperty("browser");
        try {
//            System.out.println("InSide initBrowser : "+sBrowser);
            if (!sBrowser.equals("")) {
                if (sBrowser.toLowerCase().equals("chrome")) {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.out.println("Running tests in Chrome browser.");
                } else if (sBrowser.toLowerCase().contains("chromeheadless")) {
                    WebDriverManager.chromedriver().version("71.0.3578.30").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1366x768");
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("Running tests in Chrome Headless browser");
                } else if (sBrowser.toLowerCase().contains("firefox") || sBrowser.toLowerCase().contains("mozilla")) {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.out.println("Running tests in Mozilla Firefox browser");
                } else if (sBrowser.toLowerCase().contains("ie")) {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    System.out.println("Running tests in Internet Explorer browser.");
                } else {
                    Assert.fail("Does not support browser parameter : " + sBrowser + ". Please add it in Condition.");
                }
                driver.manage().window().maximize();
                return true;
            } else {
                System.out.println("FAILED : Browser parameter was empty.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught in initBrowser() method :" + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            return false;
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("inSide tearDown() : Closing browser.");
        if (driver != null) {
            if (scenario.isFailed()) {
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
            }
            driver.quit();
        }
    }
}
