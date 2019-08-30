package Pages;

import Common.EnvironmentSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends EnvironmentSetup {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_pass")
    private WebElement password;

    @FindBy(id = "wp-submit")
    private WebElement loginButton;

    public boolean login(String sUsername, String sPassword) {
        try {
            if (username.isDisplayed() && password.isDisplayed()) {
                Thread.sleep(800);
                username.clear();
                Thread.sleep(800);
                username.sendKeys(sUsername);
                Thread.sleep(800);
                password.clear();
                Thread.sleep(800);
                password.sendKeys(sPassword);
                Thread.sleep(800);
                loginButton.click();
                return true;
            } else {
                System.out.println("FAILED to login.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught in login() method : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
