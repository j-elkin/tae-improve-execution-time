package co.com.waits.example.tasks;

import co.com.waits.example.exceptions.LoaderStillPresent;
import co.com.waits.example.interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.waits.example.userinterfaces.LoaderPage.LOADER;
import static co.com.waits.example.userinterfaces.SearchFlightPage.*;
import static co.com.waits.example.userinterfaces.SelectTicketPage.CLOSE_COOKIES;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class Search implements Task {

    private int waitTime = 30;
    private List<String> flightData;

    public Search(List<String> flightData) {
        this.flightData = flightData;
    }

    public static Search flights(List<String> flightData) {
        return Tasks.instrumented(Search.class, flightData);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.angularRequestsHaveFinished());

        actor.attemptsTo(
                Check.whether(CLOSE_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(CLOSE_COOKIES)));

        actor.attemptsTo(
                Click.on(ORIGIN),
                Enter.theValue(flightData.get(0)).into(ORIGIN));

        actor.attemptsTo(
                WaitUntil.the(SELECT_CITY.of(flightData.get(0)), isClickable()),
                Click.on(SELECT_CITY.of(flightData.get(0))));

        //actor.attemptsTo(Pause.forTime(300));
        actor.attemptsTo(WaitUntil.the(DESTINATION, isClickable()));
        actor.attemptsTo(Enter.keyValues(flightData.get(1)).into(DESTINATION));
        actor.attemptsTo(
                WaitUntil.the(SELECT_CITY.of(flightData.get(1)), isClickable()),
                Click.on(SELECT_CITY.of(flightData.get(1))));

        //actor.attemptsTo(Pause.forTime(300));
        actor.attemptsTo(
                WaitUntil.the(PASSENGERS, isVisible()),
                Click.on(PASSENGERS),
                Click.on(ADD_PASSENGER),
                Click.on(CLOSE_PASSENGERS));

        //actor.attemptsTo(Pause.forTime(300));

        actor.attemptsTo(
                WaitUntil.the(START_DATE, isCurrentlyVisible()),
                Click.on(START_DATE),
                SelectDates.inDatePicker(flightData.get(2), flightData.get(3)));

        //actor.attemptsTo(Pause.forTime(300));

        actor.attemptsTo(
                WaitUntil.the(SEARCH_FLIGHTS, isCurrentlyVisible()),
                Click.on(SEARCH_FLIGHTS));

        //actor.attemptsTo(WaitUntil.the(LOADER, isNotCurrentlyVisible()).forNoMoreThan(30).seconds());
        actor.should(eventually(seeThat(the(LOADER), isNotCurrentlyVisible()))
                .waitingForNoLongerThan(waitTime).seconds()
                .orComplainWith(LoaderStillPresent.class, String.format("The loader still is present after %s seconds", waitTime))
        );

        actor.attemptsTo(
                Check.whether(MISSING_DATA.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(ACCEPT_MISSING_DATA),
                                Click.on(SEARCH_FLIGHTS)));

    }
}
