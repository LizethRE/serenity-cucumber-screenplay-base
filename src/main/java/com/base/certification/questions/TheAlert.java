package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.LogInPage.ALERT_LABEL;

public class TheAlert implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return ALERT_LABEL.resolveFor(actor).getText();
    }

    public static TheAlert text() {
        return new TheAlert();
    }
}