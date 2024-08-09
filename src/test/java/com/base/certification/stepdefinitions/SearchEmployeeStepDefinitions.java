package com.base.certification.stepdefinitions;

import com.base.certification.abilities.JsonReader;
import com.base.certification.model.Employee;
import com.base.certification.questions.ThereAreSearchResults;
import com.base.certification.tasks.SearchEmployeeByName;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.base.certification.abilities.JsonReader.getJsonData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SearchEmployeeStepDefinitions {
    @Cuando("busca un empleado por ID {int}")
    public void buscaUnEmpleadoPorId(int rowNumber) {
        OnStage.theActorInTheSpotlight().can(JsonReader.from("src/test/resources/data/employees.json"));

        OnStage.theActorInTheSpotlight().attemptsTo(SearchEmployeeByName.now(Employee.builder()
                .firstName(getJsonData((rowNumber - 1), "firstName"))
                .middleName(getJsonData((rowNumber - 1), "middleName"))
                .lastName(getJsonData((rowNumber - 1), "lastName"))
                .build()
        ));
    }

    @Entonces("deberia obtener resultados")
    public void deberiaObtenerResultados() {
        OnStage.theActorInTheSpotlight().should(seeThat(ThereAreSearchResults.isVisible()));
    }
}