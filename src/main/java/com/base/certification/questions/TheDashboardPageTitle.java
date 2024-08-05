package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.CommonPage.DASHBOARD_TITLE_LABEL;

public class TheDashboardPageTitle implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return DASHBOARD_TITLE_LABEL.resolveFor(actor).isVisible();
    }

    public static TheDashboardPageTitle isVisible() {
        return new TheDashboardPageTitle();
    }
}