package stepDefinition;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                if (sBrowser.toLowerCase().contains("chrome")) {
                    System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("browserBinaries/chromedriver.exe").getPath());
                    driver = new ChromeDriver();
                    System.out.println("Initializing Chrome Browser.");
                } else if (sBrowser.toLowerCase().contains("headless")) {
                    System.out.println("Iniside Headless browser");
                    System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("browserBinaries/chromedriver.exe").getPath());
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1366x768");
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("Running tests in Chrome Headless Browser");
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