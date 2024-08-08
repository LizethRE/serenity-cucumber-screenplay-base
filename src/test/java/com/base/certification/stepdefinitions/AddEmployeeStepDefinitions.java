package com.base.certification.stepdefinitions;

import com.base.certification.abilities.ReadCsv;
import com.base.certification.model.Employee;
import com.base.certification.questions.TheEditEmployeePage;
import com.base.certification.questions.TheEmployeeFullName;
import com.base.certification.questions.TheToast;
import com.base.certification.tasks.FillOutNewEmployee;
import com.base.certification.tasks.GoTo;
import com.base.certification.tasks.NavigateTo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.base.certification.abilities.ReadCsv.getCell;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AddEmployeeStepDefinitions {
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
        OnStage.theActorInTheSpotlight().can(ReadCsv.from("src/test/resources/data/employees.csv"));

        OnStage.theActorInTheSpotlight().attemptsTo(FillOutNewEmployee.with(Employee.builder()
                .firstName(getCell(rowNumber, 0).trim())
                .middleName(getCell(rowNumber, 1).trim())
                .lastName(getCell(rowNumber, 2).trim())
                .createLogin(getCell(rowNumber, 3).trim())
                .build()
        ));
    }

    @Entonces("^deberia visualizar el toast con el mensaje (.*)")
    public void deberiaVisualizarElToastConElMensaje(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheToast.text(), equalTo(message)));
    }

    @Entonces("ser redirigido a la pagina de editar informacion del nuevo empleado {int}")
    public void serRedirigidoAlaPaginaDeEditarInformacionDelNuevoEmpleado(int rowNumber) {
        OnStage.theActorInTheSpotlight().can(ReadCsv.from("src/test/resources/data/employees.csv"));

        OnStage.theActorInTheSpotlight().should(seeThat(TheEditEmployeePage.isVisible()));
        OnStage.theActorInTheSpotlight().should(seeThat(TheEmployeeFullName.text(), equalTo(
                getCell(rowNumber, 0).trim() + " " + getCell(rowNumber, 2).trim()
        )));
    }
}