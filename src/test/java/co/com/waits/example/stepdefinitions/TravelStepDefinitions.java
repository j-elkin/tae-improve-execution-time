package co.com.waits.example.stepdefinitions;


import co.com.waits.example.exceptions.SummaryNotFound;
import co.com.waits.example.questions.Summary;
import co.com.waits.example.tasks.LoadSite;
import co.com.waits.example.tasks.Search;
import co.com.waits.example.tasks.Select;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static co.com.waits.example.exceptions.SummaryNotFound.SUMMARY_OF_CHARGES_NOT_FOUND;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class TravelStepDefinitions {


    @Given("^that (.*) searches for flights with the following conditions$")
    public void touristSearchFlights(String name, DataTable data) {
        List<String> tripData = data.asList();
        //Actor setup with the ability to login into the app
        theActorCalled(name).wasAbleTo(LoadSite.ofTrips());

        theActorInTheSpotlight().attemptsTo(Search.flights(tripData));

    }

    @When("^John selects the flights$")
    public void selectFlights() {
        theActorInTheSpotlight().attemptsTo(Select.flights());

    }

    @Then("John should see the summary of plane tickets")
    public void seeSummary() {
        theActorInTheSpotlight().should(eventually(seeThat(Summary.ofChargesIsVisible(), is(true)))
                .waitingForNoLongerThan(15).seconds()
                .orComplainWith(SummaryNotFound.class, SUMMARY_OF_CHARGES_NOT_FOUND));
    }

}
