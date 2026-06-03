package io.cucumber.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicAuth extends Page {

    public BasicAuth(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locates the paragraph containing the "Congratulations!" text string
    @FindBy(xpath = "//h3[text()='Basic Auth']/following-sibling::p")
    private WebElement successMessage;

    // Extracts the trimmed success message
    public String getSuccessMessageText() {
        return successMessage.getText().trim();
    }
}