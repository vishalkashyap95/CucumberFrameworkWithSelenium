package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils extends EnvironmentSetup {


    public boolean openUrl(String baseUrl) {
        try {
            System.out.println("inside openURL : " + baseUrl);
            if (!baseUrl.equals("")) {
                driver.get(baseUrl);
                return true;
            } else {
                System.out.println("FAILED : Base URL parameter was empty.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught in openUrl() method" + e.getMessage());
            return false;
        }
    }

    public boolean clickWebElement(WebElement element) {
        try {
            Thread.sleep(200);
            if (element.isDisplayed()) {
                element.click();
                System.out.println("Clicked on " + element.getText());
                return true;
            } else {
                System.out.println("FAILED : Unable to click as Element is not displayed");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught in clickWebElement() method : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public boolean mouseOverToElement(WebElement element) {
        try {
            if (element.isDisplayed()) {
                new Actions(driver).moveToElement(element).perform();
                Thread.sleep(800);
                return true;
            } else {
                System.out.println("FAILED : Element is not displayed to mouseHover.");
                return false;
            }

        } catch (Exception e) {
            System.out.println("Exception caught in mouseHoverToElement() method : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
