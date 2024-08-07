package com.base.certification.stepdefinitions;

import com.base.certification.model.User;
import com.base.certification.questions.TheAlert;
import com.base.certification.questions.TheDashboardPageTitle;
import com.base.certification.questions.TheLogInPage;
import com.base.certification.questions.TheRequiredField;
import com.base.certification.tasks.LogIn;
import com.base.certification.tasks.NavigateTo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LogInStepDefinitions {
    @Dado("que {actor} esta en la pagina de inicio de sesion de OrangeHRM")
    public void queActorEstaEnLaPaginaDeInicioDeSesionDeOrangeHRM(Actor actor) {
        actor.wasAbleTo(NavigateTo.theOragenHRMHomePage());
    }

    @Cuando("se autentica en el sistema {word} {word}")
    public void seAutenticaEnElSistema(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LogIn.withCredentials(
                        User.builder()
                                .username(username)
                                .password(password)
                                .build()
                )
        );
    }

    @Entonces("deberia visualizar la pagina de Dashboard")
    public void deberiaVisualizarLaPaginaDeDashboard() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheDashboardPageTitle.isVisible()));
    }

    @Entonces("^deberia visualizar la alerta con el mensaje (.*)")
    public void deberiaVisualizarLaAlertaConElMensaje(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheAlert.text(), equalTo(message)));
    }

    @Entonces("permanecer en la pagina de Inicio de Sesion")
    public void permanecerEnLaPaginaDeInicioDeSesion() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheLogInPage.isVisible()));
    }

    @Entonces("deberia visualizar la alerta de campo requerido")
    public void deberiaVisualizarLaAlertaDeCampoRequerido() {
        OnStage.theActorInTheSpotlight().should(seeThat(TheRequiredField.isVisible()));
    }
}