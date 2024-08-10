package com.base.certification.stepdefinitions;

import com.base.certification.questions.TheToast;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonStepDefinitions {
    @Entonces("^deberia visualizar el toast con el mensaje (.*)")
    public void deberiaVisualizarElToastConElMensaje(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(TheToast.text(), equalTo(message)));
    }
}
