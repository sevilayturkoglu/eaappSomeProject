package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.EaappHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class eaappsLoginStepDef {

    EaappHomePage eaapp = new EaappHomePage();

    @Given("I should go to eaapp {string}")
    public void i_should_go_to_eaapp(String eappurl) {
        Driver.getDriver().get(ConfigReader.getProperty(eappurl));
        //Assertion
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty(eappurl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Then("I should be login")
    public void i_should_be_login() {
        eaapp.login();

    }
}