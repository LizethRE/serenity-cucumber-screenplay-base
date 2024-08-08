package com.base.certification.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.base.certification.userinterfaces.CommonPage.ADD_BUTTON;

public class GoTo {
    public static Performable AddEmployee() {
        return Task.where("{0} va a agregar nuevo empleado", actor -> {
            actor.attemptsTo(Click.on(ADD_BUTTON));
        });
    }
}
