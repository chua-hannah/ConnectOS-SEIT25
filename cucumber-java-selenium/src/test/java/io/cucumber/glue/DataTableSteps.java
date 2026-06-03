package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.pages.DataTables;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTableSteps extends Context {

    private DataTables dataTablesPage;
    private List<List<String>> actualTableData;

    public DataTableSteps(Manager manager) {
        super(manager);
    }

    @When("the user checks the Example 1 data table")
    public void checkTableOne() {
        this.dataTablesPage = new DataTables((ChromeDriver) getDriver());
        this.actualTableData = dataTablesPage.getTableOneData();
    }

    @Then("the table should display exactly the following results:")
    public void verifyTableData(DataTable expectedTable) {
        // Convert Cucumber block matrix to Java lists, cutting out header row index [0]
        List<List<String>> expectedRows = expectedTable.asLists(String.class).subList(1, 5);

        // Assert size, placement structure, and raw textual values matching 1:1
        assertEquals(
                expectedRows,
                actualTableData,
                "The layout values parsed from Table 1 do not match the expected specification grid."
        );

        System.out.println("Table 1 validation checks complete. Layout perfectly matches specifications.");
    }
}