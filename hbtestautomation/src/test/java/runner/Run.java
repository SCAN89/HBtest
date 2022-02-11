package runner;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.testng.TestNGCourgette;
import org.testng.annotations.Test;

@Test
@CourgetteOptions(
        threads = 1,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 2,
        showTestOutput = true,
        reportTargetDir = "build",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features/",
                glue = {"hooks", "stepsDef"},
                // tags = {"@smoke"},
                publish = true,
                plugin = {"pretty", "json:build/cucumber-report/cucumber.json", "html:build/cucumber-report/cucumber.html"}))
public class Run extends TestNGCourgette {
}