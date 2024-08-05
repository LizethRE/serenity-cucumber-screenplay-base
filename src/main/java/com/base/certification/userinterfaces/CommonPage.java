package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
    public static final Target DASHBOARD_TITLE_LABEL = Target.the("Dashboard title").locatedBy("//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='Dashboard']");
}