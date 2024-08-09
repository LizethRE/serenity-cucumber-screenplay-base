package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.base.certification.userinterfaces.PimPage.SEARCH_RESULTS_LABEL;

public class ThereAreSearchResults implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(Scroll.to(SEARCH_RESULTS_LABEL).andAlignToTop());
        return SEARCH_RESULTS_LABEL.resolveFor(actor).isVisible();
    }

    public static ThereAreSearchResults isVisible() {
        return new ThereAreSearchResults();
    }
}