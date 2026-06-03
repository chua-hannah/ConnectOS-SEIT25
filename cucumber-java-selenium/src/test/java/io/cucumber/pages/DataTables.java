package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DataTables extends Page {

    public DataTables(ChromeDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locate the Table 1
    @FindBy(id = "table1")
    private WebElement mainTableOne;

    // Get the table rows inside the Table 1
    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> tableOneRows;

    //  Extracts  the first 5 columns to map to the requirement and return nested grid layout of cell text strings.
    public List<List<String>> getTableOneData() {

        waitUntilVisible(mainTableOne);

        List<List<String>> outerTableData = new ArrayList<>();

        for (WebElement row : tableOneRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            List<String> rowData = new ArrayList<>();

            // Columns index: 0=Last name, 1=First name, 2=Email, 3=Due, 4=Website
            for (int i = 0; i < 5; i++) {
                rowData.add(cells.get(i).getText().trim());
            }
            outerTableData.add(rowData);
        }
        return outerTableData;
    }
}