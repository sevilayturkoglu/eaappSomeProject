package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUpScenarios() {
        System.out.println("Istersem kullanmak icin yaptim");
    }

    @After
    public void tearDownScenarios(Scenario scenario) {
        System.out.println("After Metotu");

        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

           //  Driver.closeDriver();
        }
    }
}