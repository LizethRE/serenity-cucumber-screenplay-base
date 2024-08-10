package com.base.certification.questions;

import com.base.certification.interactions.PauseFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.base.certification.userinterfaces.EditEmployeePage.FULL_NAME_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheEmployeeFullName implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(FULL_NAME_LABEL, isVisible()).forNoMoreThan(10).seconds(),
                PauseFor.seconds(1)
        );
        return FULL_NAME_LABEL.resolveFor(actor).getText();
    }

    public static TheEmployeeFullName text() {
        return new TheEmployeeFullName();
    }
}