package com.base.certification.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LogInPage extends PageObject {
    public static final Target LOG_IN_PAGE_CONTAINER = Target.the("Log In Page container").locatedBy(".orangehrm-login-form");
    public static final Target USERNAME_INPUT = Target.the("Username field").located(By.name("username"));
    public static final Target PASSWORD_INPUT = Target.the("Password field").located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button").locatedBy(".orangehrm-login-button");
    public static final Target ALERT_LABEL = Target.the("alert").locatedBy(".oxd-alert-content-text");
    public static final Target REQUIRED_FIELD_ALERT_LABEL = Target.the("Required field alert").locatedBy("//span[text()='Required']");
}