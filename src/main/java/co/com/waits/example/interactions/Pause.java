package co.com.waits.example.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Pause implements Interaction {

    private int timeInMilliseconds;

    public Pause(int timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public static Pause forTime(int milliseconds) {
        return instrumented(Pause.class, milliseconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(timeInMilliseconds);
    }
}
