package com.base.certification.tasks;

import com.base.certification.interactions.PauseFor;
import com.base.certification.model.Employee;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static com.base.certification.userinterfaces.CommonPage.*;
import static com.base.certification.userinterfaces.EditEmployeePage.*;
import static com.base.certification.userinterfaces.PimPage.TABLE_ROWS;


public class EditEmployee implements Task {
    private final Employee firstEmployee;
    private final Employee secondEmployee;

    public EditEmployee(Employee firstEmployee, Employee secondEmployee) {
        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PauseFor.seconds(1),
                Scroll.to(SEARCH_BUTTON).andAlignToTop()
        );

        List<WebElementFacade> rows = TABLE_ROWS.resolveAllFor(actor);

        for (WebElementFacade row : rows) {
            if (row.getText().contains(firstEmployee.getFirstName()) && row.getText().contains(firstEmployee.getMiddleName()) && row.getText().contains(firstEmployee.getLastName())) {
                row.findBy(EDIT_BUTTON).click();

                actor.attemptsTo(
                        Enter.theValue(secondEmployee.getFirstName()).into(FIRST_NAME_INPUT),
                        Enter.theValue(secondEmployee.getMiddleName()).into(MIDDLE_NAME_INPUT),
                        Enter.theValue(secondEmployee.getLastName()).into(LAST_NAME_INPUT),
                        Click.on(SAVE_BUTTON)
                );
                break;
            }
        }
    }

    public static EditEmployee now(Employee firstEmployee, Employee secondEmployee) {
        return Tasks.instrumented(EditEmployee.class, firstEmployee, secondEmployee);
    }
}