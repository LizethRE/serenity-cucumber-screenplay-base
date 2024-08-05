package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.LogInPage.LOG_IN_PAGE_TITLE_LABEL;

public class TheLogInPageTitle implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return LOG_IN_PAGE_TITLE_LABEL.resolveFor(actor).isVisible();
    }

    public static TheLogInPageTitle isVisible() {
        return new TheLogInPageTitle();
    }
}