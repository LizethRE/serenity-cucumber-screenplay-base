package com.base.certification.tasks;

import com.base.certification.model.Employee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.base.certification.userinterfaces.CommonPage.SEARCH_BUTTON;
import static com.base.certification.userinterfaces.PimPage.EMPLOYEE_NAME_INPUT;


public class SearchEmployeeByName implements Task {
    private final Employee employee;

    public SearchEmployeeByName(Employee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName()).into(EMPLOYEE_NAME_INPUT),
                Click.on(SEARCH_BUTTON)
        );
    }

    public static SearchEmployeeByName now(Employee employee) {
        return Tasks.instrumented(SearchEmployeeByName.class, employee);
    }
}