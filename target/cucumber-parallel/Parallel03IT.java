import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkWithSelenium/src/test/resources/features/Test.feature:4"},
        plugin = {"json:C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkWithSelenium/target/cucumber-parallel/3.json"},
        monochrome = false,
        glue = {"stepDefinition"})
public class Parallel03IT {
}
