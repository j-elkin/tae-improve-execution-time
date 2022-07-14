package co.com.waits.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.waits.example.userinterfaces.SelectTicketPage.SUMMARY_CHARGES;

public class Summary implements Question<Boolean> {

    public static Summary ofChargesIsVisible (){
        return new Summary();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SUMMARY_CHARGES.resolveFor(actor).isVisible();
    }
}
