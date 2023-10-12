package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",//raporlarin daha ikunakli olmasi icin
                "html:target/default-cucumber-reports.html",
        },
        monochrome = true,//raporlarin consoleda okunakli sekilde cikmasi icin
        features = "src/test/resources",
        glue = {"stepdefinitions","hooks"},
        tags = "@endToend",
        dryRun =false
)
public class Runner {

}