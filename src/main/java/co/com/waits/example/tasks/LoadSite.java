package co.com.waits.example.tasks;

import co.com.waits.example.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class LoadSite implements Task {

    private HomePage flightsHomePage;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(flightsHomePage));
    }

    public static LoadSite ofTrips() {
        return Tasks.instrumented(LoadSite.class);
    }
}
