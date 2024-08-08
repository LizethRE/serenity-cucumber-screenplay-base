package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {
    public static final Target PIM_MENU_BUTTON = Target.the("Admin menu option").located(By.linkText("PIM"));
}