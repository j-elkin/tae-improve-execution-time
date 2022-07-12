package co.com.waits.example.tasks;

import co.com.waits.example.interactions.Pause;
import co.com.waits.example.userinterfaces.FlightsPage;
import co.com.waits.example.userinterfaces.LoaderPage;
import co.com.waits.example.userinterfaces.SelectTicketPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
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
        actor.attemptsTo(Click.on(CHOOSE_FLIGHT));
        actor.attemptsTo(WaitUntil.the(LOADER, isNotCurrentlyVisible()).forNoMoreThan(15).seconds());
        actor.attemptsTo(Click.on(YELLOW_TICKET));

        actor.attemptsTo(Pause.forTime(5000));
    }
}
