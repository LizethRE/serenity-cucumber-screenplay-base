package com.base.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
    public static Target MODULE_TITLE_LABEL(String value) {
        return Target.the(value + " module's title")
                .locatedBy("//span[@class='oxd-topbar-header-breadcrumb']/h6[text()='" + value + "']");
    }

    public static final Target ADD_BUTTON = Target.the("+ Add button").locatedBy("//button[contains(., 'Add')]");
    public static final Target SAVE_BUTTON = Target.the("Save button").locatedBy("//button[contains(., 'Save')]");
    public static final Target TOAST_MESSAGE_LABEL = Target.the("toast message label").locatedBy(".oxd-text--toast-message");
}