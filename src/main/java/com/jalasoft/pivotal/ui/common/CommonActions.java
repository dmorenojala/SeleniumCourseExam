package com.jalasoft.pivotal.ui.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class CommonActions {

    private final static DriverManager DRIVER_MANAGER = DriverManager.getInstance();

    private CommonActions() {
    }

    public static void sendKeys(final WebElement webElement, final String text) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static void clickElement(final WebElement webElement) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static String getText(final WebElement webElement) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
