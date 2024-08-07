package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.LogInPage.LOG_IN_PAGE_CONTAINER;

public class TheLogInPage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return LOG_IN_PAGE_CONTAINER.resolveFor(actor).isVisible();
    }

    public static TheLogInPage isVisible() {
        return new TheLogInPage();
    }
}