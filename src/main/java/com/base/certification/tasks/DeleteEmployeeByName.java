package com.base.certification.tasks;

import com.base.certification.interactions.PauseFor;
import com.base.certification.model.Employee;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static com.base.certification.userinterfaces.CommonPage.*;
import static com.base.certification.userinterfaces.PimPage.TABLE_ROWS;


public class DeleteEmployeeByName implements Task {
    private final Employee employee;

    public DeleteEmployeeByName(Employee employee) {
        this.employee = employee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PauseFor.seconds(1),
                Scroll.to(SEARCH_BUTTON).andAlignToTop()
        );

        List<WebElementFacade> rows = TABLE_ROWS.resolveAllFor(actor);

        for (WebElementFacade row : rows) {
            if (row.getText().contains(employee.getFirstName()) && row.getText().contains(employee.getMiddleName()) && row.getText().contains(employee.getLastName())) {
                row.findBy(DELETE_BUTTON).click();
                actor.attemptsTo(Click.on(YES_DELETE_BUTTON));
                break;
            }
        }
    }

    public static DeleteEmployeeByName now(Employee employee) {
        return Tasks.instrumented(DeleteEmployeeByName.class, employee);
    }
}