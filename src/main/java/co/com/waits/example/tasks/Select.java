package co.com.waits.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.waits.example.userinterfaces.FlightsPage.CHOOSE_FLIGHT;
import static co.com.waits.example.userinterfaces.LoaderPage.LOADER;
import static co.com.waits.example.userinterfaces.SelectTicketPage.YELLOW_TICKET;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;

public class Select implements Task {

    public static Select flights() {
        return Tasks.instrumented(Select.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LOADER, isNotCurrentlyVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(
                WaitUntil.the(CHOOSE_FLIGHT, isCurrentlyVisible()),
                Click.on(CHOOSE_FLIGHT));


        //actor.attemptsTo(Scroll.to(YELLOW_TICKET));

    }
}
