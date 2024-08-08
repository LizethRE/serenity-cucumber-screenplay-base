package com.base.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.base.certification.userinterfaces.EditEmployeePage.EDIT_EMPLOYEE_PAGE_CONTAINER;

public class TheEditEmployeePage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return EDIT_EMPLOYEE_PAGE_CONTAINER.resolveFor(actor).isVisible();
    }

    public static TheEditEmployeePage isVisible() {
        return new TheEditEmployeePage();
    }
}