package com.base.certification.tasks;

import com.base.certification.model.Employee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.base.certification.userinterfaces.CommonPage.SAVE_BUTTON;
import static com.base.certification.userinterfaces.CreateEmployeePage.*;


public class FillOutNewEmployee implements Task {
    private final Employee employee;

    public FillOutNewEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(employee.getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(employee.getMiddleName()).into(MIDDLE_NAME_INPUT),
                Enter.theValue(employee.getLastName()).into(LAST_NAME_INPUT),
                Click.on(SAVE_BUTTON)
        );
    }

    public static FillOutNewEmployee with(Employee employee) {
        return Tasks.instrumented(FillOutNewEmployee.class, employee);
    }
}