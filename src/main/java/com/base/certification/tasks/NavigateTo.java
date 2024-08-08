package com.base.certification.tasks;

import com.base.certification.userinterfaces.LogInPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static com.base.certification.userinterfaces.MenuPage.PIM_MENU_BUTTON;

public class NavigateTo {
    public static Performable theOragenHRMHomePage() {
        return Task.where("{0} abre la pagina principal de OrangeHRM",
                Open.browserOn().the(LogInPage.class));
    }

    public static Performable thePimModule() {
        return Task.where("{0} navega al módulo de PIM", actor -> {
            actor.attemptsTo(Click.on(PIM_MENU_BUTTON));
        });
    }
}
