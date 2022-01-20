package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pages.*;
import org.junit.Assert;

public class EmployeeStepDefinitions {

    EmployeePage employeePage;

    @Given("employee home page")
    public void employeeHomePage(){
        employeePage.open();
    }

    @When("no employee is selected")
    public void noEmployeeIsSelected() {
        Assert.assertTrue(employeePage.employeeIsNotSelected());
    }

    @Then("selected data is empty")
    public void selectedDataIsEmpty() {
       Assert.assertTrue(employeePage.viewSelectedDataIsEmpty());
    }

    @When("select all employees")
    public void selectAllEmployees() {
        employeePage.selectAllEmployees();
    }

    @Then("view all cities of employees on selected data")
    public void viewAllCitiesOfEmployeesOnSelectedData(DataTable t) {
        Assert.assertTrue(employeePage.verifyCityOfEmployee(t));
    }

    @When("one or more employees are selected")
    public void oneOrMoreEmployeesAreSelected(DataTable t) {
        employeePage.selectEmployee(t);
    }

    @Then("view city of employee selected")
    public void viewCityOfEmployeeSelected(DataTable t) {
        Assert.assertTrue(employeePage.verifyCityOfEmployee(t));
    }


}
