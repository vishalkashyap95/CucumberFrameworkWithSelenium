import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkWithSelenium/src/test/resources/features/Login.feature:15"},
        plugin = {"json:C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkWithSelenium/target/cucumber-parallel/2.json"},
        monochrome = false,
        glue = {"stepDefinition"})
public class Parallel02IT {
}
