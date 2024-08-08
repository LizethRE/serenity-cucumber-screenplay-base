package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EditEmployeePage {
    public static final Target EDIT_EMPLOYEE_PAGE_CONTAINER = Target.the("Edit Employee page container").locatedBy(".orangehrm-edit-employee");
    public static final Target FULL_NAME_LABEL = Target.the("Full Name label").locatedBy("//h6[@class='oxd-text oxd-text--h6 --strong']");
}