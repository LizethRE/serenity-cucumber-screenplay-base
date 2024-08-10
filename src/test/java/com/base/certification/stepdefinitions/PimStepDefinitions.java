package com.base.certification.stepdefinitions;

import com.base.certification.abilities.JsonReader;
import com.base.certification.model.Employee;
import com.base.certification.questions.TheEmployeeFullName;
import com.base.certification.questions.ThereAreSearchResults;
import com.base.certification.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.base.certification.abilities.JsonReader.getJsonData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PimStepDefinitions {
    @Dado("que {actor} esta en el modulo PIM")
    public void queActorEstaEnElModuloPim(Actor actor) {
        actor.wasAbleTo(NavigateTo.thePimModule());
    }

    @Cuando("va a agregar nuevo empleado")
    public void vaAAgregarNuevoEmpleado() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoTo.AddEmployee());
    }

    @Cuando("diligencia el formulario de creacion de empleado {int}")
    public void diligenciaElFormularioDeCreacionDeEmpleado(int rowNumber) {
        OnStage.theActorInTheSpotlight().can(JsonReader.from("src/test/resources/data/employees.json"));

        OnStage.theActorInTheSpotlight().attemptsTo(FillOutNewEmployee.with(Employee.builder()
                .firstName(getJsonData((rowNumber - 1), "firstName"))
                .middleName(getJsonData((rowNumber - 1), "middleName"))
                .lastName(getJsonData((rowNumber - 1), "lastName"))
                .build()
        ));
    }

    @Cuando("busca un empleado por nombre {int}")
    public void buscaUnEmpleadoPorNombre(int rowNumber) {
        OnStage.theActorInTheSpotlight().can(JsonReader.from("src/test/resources/data/employees.json"));

        OnStage.theActorInTheSpotlight().attemptsTo(SearchEmployeeByName.now(Employee.builder()
                .firstName(getJsonData((rowNumber - 1), "firstName"))
                .middleName(getJsonData((rowNumber - 1), "middleName"))
                .lastName(getJsonData((rowNumber - 1), "lastName"))
                .build()
        ));
    }

    @Cuando("elimina el empleado {int}")
    public void eliminaElEmpleado(int rowNumber) {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteEmployeeByName.now(Employee.builder()
                .firstName(getJsonData((rowNumber - 1), "firstName"))
                .middleName(getJsonData((rowNumber - 1), "middleName"))
                .lastName(getJsonData((rowNumber - 1), "lastName"))
                .build()
        ));
    }

    @Entonces("ser redirigido a la pagina de editar informacion del nuevo empleado {int}")
    public void serRedirigidoAlaPaginaDeEditarInformacionDelNuevoEmpleado(int rowNumber) {
        OnStage.theActorInTheSpotlight().can(JsonReader.from("src/test/resources/data/employees.json"));

        OnStage.theActorInTheSpotlight().should(seeThat(TheEmployeeFullName.text(), equalTo(
                getJsonData((rowNumber - 1), "firstName") + " " + getJsonData((rowNumber - 1), "lastName")
        )));
    }

    @Entonces("deberia obtener resultados")
    public void deberiaObtenerResultados() {
        OnStage.theActorInTheSpotlight().should(seeThat(ThereAreSearchResults.isVisible()));
    }
}