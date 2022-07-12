package co.com.waits.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SelectTicketPage {

    public static final Target YELLOW_TICKET = Target.the("Yellow ticket button")
            .locatedBy("(//button[@class='margin-lr-auto padding-lr20px font-weight-bold rad6 btn btn-primary btn-sm'])[1]");

    public static final Target CLOSE_COOKIES = Target.the("Cookies Policy")
            .locatedBy("//button[@class='secondary']");

    public static final Target SUMMARY_CHARGES = Target.the("Summary of Charges")
            .located(By.id("v-flight"));
}
