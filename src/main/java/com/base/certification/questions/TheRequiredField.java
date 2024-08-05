package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.LogInPage.REQUIRED_FIELD_ALERT_LABEL;

public class TheRequiredField implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return REQUIRED_FIELD_ALERT_LABEL.resolveFor(actor).isVisible();
    }

    public static TheRequiredField isVisible() {
        return new TheRequiredField();
    }
}