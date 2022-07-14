package co.com.waits.example.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

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
    @Step("{0} wait for #timeInMilliseconds milliseconds")
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(timeInMilliseconds);
    }
}
