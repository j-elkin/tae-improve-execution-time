package co.com.waits.example.interactions;

import co.com.waits.example.exceptions.LoaderStillPresent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.concurrent.TimeUnit;

import static co.com.waits.example.userinterfaces.LoaderPage.LOADER;

public class WaitLoading implements Task {

    private int count = 0;
    private int maxAttempts = 60;
    private long milliseconds = 1000;

    public static WaitLoading modal(){
        return Tasks.instrumented(WaitLoading.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        ManageTime.waiFor(1000);
        while (LOADER.resolveFor(actor).isVisible()) {
            try {
                TimeUnit.MILLISECONDS.sleep(milliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            count += 1;
            if (count == maxAttempts) {
                throw new LoaderStillPresent("The loader still is present after " + count + " seconds");
            }
        }
    }
}
