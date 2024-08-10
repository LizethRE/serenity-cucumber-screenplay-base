package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.base.certification.userinterfaces.LogInPage.ALERT_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheAlert implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ALERT_LABEL, isVisible()).forNoMoreThan(10).seconds());
        return ALERT_LABEL.resolveFor(actor).getText();
    }

    public static TheAlert text() {
        return new TheAlert();
    }
}