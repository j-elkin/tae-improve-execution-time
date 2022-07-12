package co.com.waits.example.tasks;

import co.com.waits.example.interactions.Pause;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static co.com.waits.example.userinterfaces.SearchFlightPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class Search implements Task {

    private List<String> flightData;

    public Search(List<String> flightData) {
        this.flightData = flightData;
    }

    public static Search flights (List<String> flightData) {
        return Tasks.instrumented(Search.class, flightData);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(ORIGIN, isCurrentlyVisible()).forNoMoreThan(10).seconds());

        actor.attemptsTo(
                Click.on(ORIGIN),
                Enter.theValue(flightData.get(0)).into(ORIGIN));
        actor.attemptsTo(
                WaitUntil.the(SELECT_CITY.of(flightData.get(0)), isCurrentlyVisible())
                        .then(Click.on(SELECT_CITY.of(flightData.get(0)))) );

        actor.attemptsTo(WaitUntil.the(DESTINATION, isClickable()));
        actor.attemptsTo(Enter.theValue(flightData.get(1)).into(DESTINATION));
        actor.attemptsTo(
                WaitUntil.the(SELECT_CITY.of(flightData.get(1)), isCurrentlyVisible()),
                Click.on(SELECT_CITY.of(flightData.get(1))));


        actor.attemptsTo(
                Click.on(START_DATE),
                SelectDates.inDatePicker(flightData.get(2), flightData.get(3)));

        actor.attemptsTo(Pause.forTime(500));

        actor.attemptsTo(Click.on(SEARCH_FLIGHTS));

    }
}
