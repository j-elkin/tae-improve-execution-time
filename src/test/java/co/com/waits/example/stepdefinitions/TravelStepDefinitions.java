package co.com.waits.example.stepdefinitions;


import co.com.waits.example.tasks.LoadSite;
import co.com.waits.example.tasks.Search;
import co.com.waits.example.tasks.Select;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.conditions.Check;

import java.util.List;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TravelStepDefinitions {

    private static final String ES_FUERA_OFICINA_NO = "No";


    @Dado("^que (.*) busca vuelos con las siguientes condiciones$")
    public void elTuristaBuscaBuelos(String name, DataTable data) {
        List<String> tripData = data.asList();
        //Actor setup with the ability to login into the app
        theActorCalled(name).wasAbleTo(LoadSite.ofTrips());

        theActorInTheSpotlight().attemptsTo(Search.flights(tripData));

    }

    @Cuando("^John selecciona los vuelos$")
    public void seleccionaLosVuelos() {
        theActorInTheSpotlight().attemptsTo(Select.flights());

    }

}
