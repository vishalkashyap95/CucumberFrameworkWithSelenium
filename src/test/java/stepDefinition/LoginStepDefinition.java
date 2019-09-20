package stepDefinition;

import Common.EnvironmentSetup;
import Common.Utils;
import Pages.LoginPage;
import Pages.PostsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LoginStepDefinition extends EnvironmentSetup {
    //    WebDriver driver;
    Properties configProb = new Properties();
    private LoginPage loginPage;
    private Utils utils;
    private PostsPage postsPage;

    public LoginStepDefinition() {
        try {
//            System.out.println(System.getProperty("browser"));
            configProb.load(getClass().getClassLoader().getResourceAsStream("Properties/configProperties.properties"));
            System.out.println(configProb.getProperty("message"));
            loginPage = new LoginPage();
            utils = new Utils();
            postsPage = new PostsPage();
        } catch (Exception e) {
            System.out.println("Exception caught in LoginStepDefinition constructor : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Given("Open Browser and navigate to Login page")
    public void openBrowserAndNavigateToLoginPage() {
        try {
            System.out.println("Opening URL : " + configProb.getProperty("baseUrl"));
            // Open URL
            utils.openUrl(configProb.getProperty("baseUrl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @When("^Enter valid uesrname and valid password$")
    public void Enter_valid_uesrname_and_valid_password(DataTable credentials) {
        try {
            Actions act =new Actions(driver);
//            act.dr
            Dimension dim = postsPage.postsMenuLink.getSize();

            List<Map<String, String>> listOfcredentials = credentials.asMaps(String.class, String.class);
            for (int i = 0; i < listOfcredentials.size(); i++) {
                System.out.println("Entering username : " + listOfcredentials.get(i).get("username") + " Entering password : " + listOfcredentials.get(i).get("password"));
                loginPage.login(listOfcredentials.get(i).get("username"), listOfcredentials.get(i).get("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^user should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() {
        try {
            Assert.assertTrue(driver.findElements(By.xpath("(//img[contains(@class,'avatar')])[1]")).size() > 0);
            System.out.println("Successfully logged in.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^Login with valid credentials$")
    public void loginWithValidCredentials() {
        loginPage.login(configProb.getProperty("username"), configProb.getProperty("password"));
    }

    @Then("^click on post menu$")
    public void clickOnPostMenu() throws Exception {
        utils.clickWebElement(postsPage.postsMenuLink);
        Thread.sleep(1000);
    }

    @Then("^verify title of Post page$")
    public void verifyTitleOfPostPage() throws Exception {
        System.out.println("Expected Posts page Title 'Posts ‹ opensourcecms — WordPress'");
        System.out.println("Actual Posts page Title contains 'Poasdsts'? : " + driver.getTitle());
        // Making it fail intentionally to generate a fail report and get the screenshot attached.
        Assert.assertFalse("FAILED to verify Title of Posts page.", driver.getTitle().contains("Posts"));
    }

    @Then("verify all links under post menu")
    public void verifyAllLinksUnderPostMenu() {
        String subMenuLinkText = "All Posts, Add New, Categories, Tags";
        for (int i = 0; i < postsPage.listOfLinksUnderPostMenu.size(); i++) {
            System.out.println(postsPage.listOfLinksUnderPostMenu.get(i).getText());
            Assert.assertTrue("FAILED to verify all sub menus of Post Menu.", subMenuLinkText.contains(postsPage.listOfLinksUnderPostMenu.get(i).getText()));
        }
    }

    @Then("click logout and verify user redirected to login page")
    public void clickLogoutAndVerifyUserRedirectedToLoginPage() {
        try {
            utils.mouseOverToElement(postsPage.profileBarSection);
            Thread.sleep(1000);
            Assert.assertTrue("Logout link was not displayed.", postsPage.logoutLink.isDisplayed());
            Thread.sleep(500);
            postsPage.logoutLink.click();
            System.out.println("Successfully clicked on Logout Link.");
            System.out.println("Expected Login page Title 'Log In ‹ opensourcecms — WordPress'");
            System.out.println("Actual Login page Title contains 'Log In'? : " + driver.getTitle().contains("Log In "));
            Assert.assertTrue("FAILED to verify title of Login page after logout.", driver.getTitle().contains("Log In "));
        } catch (Exception e) {
            System.out.println("Exception caught in clickLogoutAndVerifyUserRedirectedToLoginPage() method : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
