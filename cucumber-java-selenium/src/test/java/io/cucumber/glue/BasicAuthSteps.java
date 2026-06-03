package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.pages.BasicAuth;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthSteps extends Context {

    private BasicAuth basicAuthPage;

    public BasicAuthSteps(Manager manager) {
        super(manager);
    }

    @When("the user requests authenticated access using username {string} and password {string}")
    public void authenticateViaInjection(String username, String password) {
        // Construct the secure URI string by prepending the credentials to the domain
        String authenticatedUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";

        getDriver().get(authenticatedUrl);

        this.basicAuthPage = new BasicAuth(getDriver());
    }

    @Then("a success message containing {string} should be displayed")
    public void verifySuccessMessage(String expectedText) {
        String actualMessage = basicAuthPage.getSuccessMessageText();

        assertTrue(
                actualMessage.contains(expectedText),
                "Expected success message to contain '" + expectedText + "', but got: '" + actualMessage + "'"
        );
    }
}