package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        snippets = CAMELCASE
)
public class Runner extends AbstractTestNGCucumberTests {
}
