package co.com.waits.example.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/travel.feature",
        glue = "co.com.waits.example.stepdefinitions",
        snippets= CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTrip {
}
