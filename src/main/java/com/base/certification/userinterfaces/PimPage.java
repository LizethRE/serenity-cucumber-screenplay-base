package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PimPage {
    public static final Target EMPLOYEE_NAME_INPUT = Target.the("Employee Name field").locatedBy("//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]//input[1]");
    public static final Target SEARCH_RESULTS_LABEL = Target.the("Record Found").locatedBy("//span[contains(.,') Records Found')]");
    public static final Target TABLE_ROWS = Target.the("table rows").located(By.className("oxd-table-card"));
}