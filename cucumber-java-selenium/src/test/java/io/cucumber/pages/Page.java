package io.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

  protected ChromeDriver driver;
  protected WebDriverWait wait;

  public Page(ChromeDriver driver) {
    this.driver = driver;

    PageFactory.initElements(driver, this);

    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
}