package io.cucumber.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page {

  protected ChromeDriver driver;
  protected WebDriverWait wait;

  public Page(ChromeDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);

    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  // Helper method to wait for an element's visibility before interacting with it.
  public WebElement waitUntilVisible(WebElement element) {
    return wait.until(ExpectedConditions.visibilityOf(element));
  }
}