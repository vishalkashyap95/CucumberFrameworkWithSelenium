package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
                } else if (sBrowser.toLowerCase().contains("phantom") || sBrowser.toLowerCase().contains("headless")) {
                    System.out.println("Iniside Headless browser");
//                    System.setProperty("phantomjs.binary.path", getClass().getClassLoader().getResource("browserBinaries/phantomjs.exe").getPath());
                    DesiredCapabilities desiredCaps = new DesiredCapabilities();
                    desiredCaps.setJavascriptEnabled(true);
                    desiredCaps.setCapability("takesScreenshot", true);
                    desiredCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,getClass().getClassLoader().getResource("browserBinaries/phantomjs.exe").getPath());
                    driver = new PhantomJSDriver(desiredCaps);
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("headless");
//                    chromeOptions.addArguments("window-size=1200x600");
//                    chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
//                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("Running tests in PhantomJS Browser");
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
    public void tearDown() {
        System.out.println("inSide tearDown() : Closing browser.");
        if (driver != null) {
            driver.quit();
        }
    }
}