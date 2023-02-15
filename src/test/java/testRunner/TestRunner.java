package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps"},
        plugin = {"pretty","html:Report.html"},
        dryRun = true,
        monochrome = false
//        tags = "@Run"
        //name = {"Logo"}
)

public class TestRunner {
}
