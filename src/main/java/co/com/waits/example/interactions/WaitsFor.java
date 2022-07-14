package co.com.waits.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsFor implements Interaction {

    private int seconds = 10;
    private String textExpected = "";
    private Target target;

    public static WaitsFor theCondition (Target target, String textExpected) {
        return Tasks.instrumented(WaitsFor.class, target, textExpected);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        waitAs(actor).until(ExpectedConditions.textToBePresentInElement(target.resolveFor(actor), textExpected));

        //waitAs(actor).until(ExpectedConditions.elementToBeClickable(target.resolveFor(actor)));
        //waitAs(actor).until(ExpectedConditions.invisibilityOf(target.resolveFor(actor)));
        //waitAs(actor).until(ExpectedConditions.visibilityOf(target.resolveFor(actor)));
    }

    public WaitsFor withMaxSeconds (int timeInSeconds) {
        this.seconds = timeInSeconds;
        return this;
    }

    private WebDriverWait waitAs(Actor actor) {
        return new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), seconds);
    }
}
