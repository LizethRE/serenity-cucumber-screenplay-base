package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.base.certification.userinterfaces.CommonPage.TOAST_MESSAGE_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheToast implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(TOAST_MESSAGE_LABEL, isVisible()).forNoMoreThan(10).seconds());
        return TOAST_MESSAGE_LABEL.resolveFor(actor).getText();
    }

    public static TheToast text() {
        return new TheToast();
    }
}