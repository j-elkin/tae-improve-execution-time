package co.com.waits.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoaderPage {

    public static final Target LOADER = Target.the("Loading modal")
            .locatedBy("//div[@class='loader1']");
}
