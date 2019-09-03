package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private String sBrowser = "";
    public static WebDriver driver;

    @Before
    public boolean initBrowser() {

        sBrowser = System.getProperty("browser");
        try {
            if (!sBrowser.equals("")) {
                System.out.println("inSide initBrowser " + sBrowser);
                if (sBrowser.toLowerCase().contains("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\VishalWorkSpace\\mvncommandlineproject\\CucumberFrameworkPractise\\src\\test\\resources\\browserBinaries\\chromedriver.exe");
                    driver = new ChromeDriver();
                    System.out.println("Running tests in Chrome Browser");
                } else if (sBrowser.toLowerCase().contains("chromehead")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\VishalWorkSpace\\mvncommandlineproject\\CucumberFrameworkPractise\\src\\test\\resources\\browserBinaries\\chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver();
                    System.out.println("Running tests in HeadLess Chrome Browser");
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