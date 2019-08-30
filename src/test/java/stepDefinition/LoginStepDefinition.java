package stepDefinition;

import Common.EnvironmentSetup;
import Common.Utils;
import Pages.LoginPage;
import Pages.PostsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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


    @Given("^click on post menu$")
    public void clickOnPostMenu() {
        utils.clickWebElement(postsPage.postsMenuLink);
    }

    @Then("verify title of Post page")
    public void verifyTitleOfPostPage() {
        System.out.println("Expected Posts page Title 'Posts ‹ opensourcecms — WordPress'");
        System.out.println("Actual Posts page Title : " + driver.getTitle());
        Assert.assertTrue("FAILED to verify Title of Posts page.", driver.getTitle().equals("Posts ‹ opensourcecms — WordPress"));
    }

    @Then("verify all links under post menu")
    public void verifyAllLinksUnderPostMenu() {
//        for (WebElement link : postsPage.listOfLinksUnderPostMenu) {
//        Syste
//        }
        System.out.println(postsPage.listOfLinksUnderPostMenu.iterator().next());
        System.out.println(postsPage.listOfLinksUnderPostMenu.iterator().next().getText().contains("Add New"));
    }

}
