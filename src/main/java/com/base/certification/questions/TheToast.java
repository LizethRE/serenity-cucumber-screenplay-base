package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.CommonPage.TOAST_MESSAGE_LABEL;

public class TheToast implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return TOAST_MESSAGE_LABEL.resolveFor(actor).getText();
    }

    public static TheToast text() {
        return new TheToast();
    }
}