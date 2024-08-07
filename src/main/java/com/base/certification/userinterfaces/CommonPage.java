package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
    public static Target MODULE_TITLE_LABEL(String value) {
        return Target.the(value + " module's title")
                .locatedBy("//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='" + value + "']");
    }
}