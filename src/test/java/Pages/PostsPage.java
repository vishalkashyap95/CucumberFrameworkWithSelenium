package Pages;

import Common.EnvironmentSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostsPage extends EnvironmentSetup {

    public PostsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='menu-posts'] [class='wp-menu-name']")
    public WebElement postsMenuLink;

    @FindBy(css = "[id='menu-posts'] [class='wp-submenu wp-submenu-wrap'] a")
    public List<WebElement> listOfLinksUnderPostMenu;

    @FindBy(id = "wp-admin-bar-my-account")
    public WebElement profileBarSection;

    @FindBy(css = "[id='wp-admin-bar-logout'] a")
    public WebElement logoutLink;
}
