package co.com.waits.example.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.util.concurrent.TimeUnit;

public class ManageTime {


    public static void seeImplicitWaitValue(Actor actor){
        System.out.println(String.format("Implicit wait configured: %s seconds", BrowseTheWeb.as(actor).getImplicitWaitTimeout().toSeconds()));
    }

    public static void seeWaitForTimeout(Actor actor) {
        System.out.println(String.format("Wait for timeout: %s seconds", BrowseTheWeb.as(actor).getWaitForTimeout().toSeconds()));
    }

    public static void setWaitForTimeout(Actor actor, long milliseconds){
        BrowseTheWeb.as(actor).setWaitForTimeout(milliseconds);
        BrowseTheWeb.as(actor).setWaitForElementTimeout(milliseconds);
    }


    public static void waiFor(long timeInMilliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
