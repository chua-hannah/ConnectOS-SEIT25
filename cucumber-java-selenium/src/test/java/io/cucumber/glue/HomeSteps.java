package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.pages.Home;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeSteps extends Context {

  private Home homePage;

  public HomeSteps(Manager manager) {
    super(manager);
  }

  @Given("an example Home Page step")
  public void exampleHomePageStep() {
    System.out.println("printing shared stash :" + getTestStash());
  }

  @Then("the displayed list of links should contain only the following examples:")
  public void verifyHomepageLinks(DataTable expectedTable) {

    // Initialize Page Object
    homePage = new Home(getDriver());

    List<String> expectedLinks = expectedTable.asList(String.class);
    List<String> actualLinks = homePage.getExampleLinksText();

    assertEquals(
            expectedLinks,
            actualLinks,
            "FAIL: Homepage links do not exactly match expected blueprint."
    );
  }
}