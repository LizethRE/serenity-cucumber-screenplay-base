package com.base.certification.tasks;

import com.base.certification.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.base.certification.userinterfaces.LogInPage.*;


public class LogIn implements Task {
    private User user;

    public LogIn(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (user.getUsername().equalsIgnoreCase("N/a")) {
            user.setUsername("");
        }
        if (user.getPassword().equalsIgnoreCase("N/a")) {
            user.setPassword("");
        }
        actor.attemptsTo(
                Enter.theValue(user.getUsername()).into(USERNAME_INPUT),
                Enter.theValue(user.getPassword()).into(PASSWORD_INPUT),
                Click.on(LOGIN_BUTTON));
    }

    public static LogIn withCredentials(User user) {
        return Tasks.instrumented(LogIn.class, user);
    }
}