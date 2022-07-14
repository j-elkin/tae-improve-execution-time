package co.com.waits.example.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Setup {

	//It's executed before start the tests
	@Before
	public void prepararEscenario() {
		//indicate to Serenity to use the driver set in serenity.properties. Open browser instance.
		OnStage.setTheStage(new OnlineCast());
	}
	
}
