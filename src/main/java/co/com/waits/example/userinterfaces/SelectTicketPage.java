package co.com.waits.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SelectTicketPage {

    public static final Target YELLOW_TICKET = Target.the("Yellow ticket button")
            .locatedBy("(//button[@class='margin-lr-auto padding-lr20px font-weight-bold rad6 btn btn-primary btn-sm'])[1]");
}
