package Common;

import org.openqa.selenium.WebDriver;
import stepDefinition.Hooks;

public abstract class EnvironmentSetup {

    protected WebDriver driver = Hooks.driver;
}
