package co.com.waits.example.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchFlightPage {

    public static final Target ORIGIN = Target.the("Enter city of origin")
            .locatedBy("//input[@placeholder='de']");

    public static final Target DESTINATION = Target.the("Enter destination city ")
            .locatedBy("//input[@placeholder='a']");

    public static final Target SELECT_CITY = Target.the("Select city")
            .locatedBy("//div[@class='d-block menu1 dropdown-menu show']//div[contains(text(), '{0}')]");

    public static final Target SEARCH_FLIGHTS = Target.the("Search for flights")
            .locatedBy("//button[@class='min-width-100-pcent btn btn-danger']");

    public static final Target START_DATE = Target.the("Select start date")
            .located(By.id("startD"));

    public static final Target END_DATE = Target.the("Select end date")
            .located(By.id("endD"));


}
