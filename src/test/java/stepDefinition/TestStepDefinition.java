package stepDefinition;

import cucumber.api.java.en.*;

public class TestStepDefinition {

    @Given("performSomeSteps")
    public void performSomeSteps() {
        System.out.println("performSomeSteps");
    }

    @Then("performSomeOtherSteps")
    public void performSomeOtherSteps() {
        System.out.println("performSomeOtherSteps");

    }
}
