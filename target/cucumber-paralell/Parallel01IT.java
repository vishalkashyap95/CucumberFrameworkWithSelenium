import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkPractise/src/test/resources/features/Login.feature:7"},
        plugin = {"json:C:/Users/user/Desktop/VishalWorkSpace/mvncommandlineproject/CucumberFrameworkPractise/target/cucumber-paralell/1.json"},
        monochrome = false,
        glue = {"stepDefinition"})
public class Parallel01IT {
}