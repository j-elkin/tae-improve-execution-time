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


    public static final Target PASSENGERS = Target.the("Click to see passengers")
            .located(By.id("dropdownPeople"));

    public static final Target ADD_PASSENGER = Target.the("Add a new passenger")
            .located(By.xpath("(//*[@data-icon='plus-circle'])[1]"));

    public static final Target  CLOSE_PASSENGERS = Target.the("Close modal passengers")
            .located(By.xpath("//button[@class='width-100 btn btn-primary']"));

    public static final Target  MISSING_DATA = Target.the("Fill required data")
            .located(By.xpath("//div[@class='text-muted lead']"));

    public static final Target  ACCEPT_MISSING_DATA = Target.the("Accept Message fill required data")
            .located(By.xpath("//button[@class='btn btn-lg btn-primary ']"));

}
