package com.base.certification.tasks;

import com.base.certification.userinterfaces.LogInPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theOragenHRMHomePage() {
        return Task.where("{0} abre la pagina principal de OrangeHRM",
                Open.browserOn().the(LogInPage.class));
    }
}
