package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EmployeeListPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class EmployeeListStepDef {

    EmployeeListPage employeeList=new EmployeeListPage();

    @Then("I should go to Employee List link")
    public void i_should_go_to_employee_list_link() {
        employeeList.employeList.click();

        ReusableMethods.wait(1);
    }

    @Then("I should create new employee information")
    public void i_should_create_new_employee_information() {
        employeeList.createNewButton.click();
        employeeList.createNewEmployee();
    }

    @When("I should see which my created  employee information")
    public void i_should_see_which_my_created_employee_information() {
        employeeList.verifyEmployeeList();
    }

    @And("I should delete which my created  employee information")
    public void iShouldDeleteWhichMyCreatedEmployeeInformation() {
        employeeList.verifyDeleteEmployeeInformation();
    }

    @And("close the browser")
    public void closeTheBrowser() {
        ReusableMethods.wait(2);
        Driver.quiteDriver();
    }
}
