package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateEmployeePage {
    public static final Target FIRST_NAME_INPUT = Target.the("First Name field").located(By.name("firstName"));
    public static final Target MIDDLE_NAME_INPUT = Target.the("Middle Name field").located(By.name("middleName"));
    public static final Target LAST_NAME_INPUT = Target.the("Last Name field").located(By.name("lastName"));
}