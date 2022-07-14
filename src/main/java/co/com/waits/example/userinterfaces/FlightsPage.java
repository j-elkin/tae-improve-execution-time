package co.com.waits.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FlightsPage {

    public static final Target CHOOSE_FLIGHT = Target.the("Choose flights button")
            .locatedBy("(//button[@class='width-100 fill btn btn-danger'])[1]");
}
