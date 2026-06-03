package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);

    System.out.println("Homepage title is: " + getTitle().getText());
  }

  // ===== Elements =====

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(xpath = "//div[@id='content']/ul/li")
  private List<WebElement> exampleLinks;

  @FindBy(linkText = "Basic Auth")
  private WebElement basicAuthLink;

  // ===== Getters / Actions =====

  public WebElement getTitle() {
    return title;
  }

  public List<WebElement> getExampleLinkElements() {
    return exampleLinks;
  }

  public List<String> getExampleLinksText() {
    List<String> linksText = new ArrayList<>();

    for (WebElement link : exampleLinks) {
      linksText.add(link.getText().trim());
    }

    return linksText;
  }

  public void clickBasicAuthLink() {
    waitUntilVisible(basicAuthLink).click();
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}