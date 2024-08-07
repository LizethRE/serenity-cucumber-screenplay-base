package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.CommonPage.MODULE_TITLE_LABEL;

public class TheDashboardPageTitle implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return MODULE_TITLE_LABEL("Dashboard").resolveFor(actor).isVisible();
    }

    public static TheDashboardPageTitle isVisible() {
        return new TheDashboardPageTitle();
    }
}