package com.jalasoft.pivotal.ui.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * CommonActions.
 */
public final class CommonActions {

    private static final DriverManager DRIVER_MANAGER = DriverManager.getInstance();

    /**
     * CommonActions.
     */
    private CommonActions() {
    }

    /**
     * @param webElement The web element.
     * @param text The text.
     */
    public static void sendKeys(final WebElement webElement, final String text) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * @param webElement The webElement.
     */
    public static void clickElement(final WebElement webElement) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * @param webElement The web element.
     * @return The text.
     */
    public static String getText(final WebElement webElement) {
        DRIVER_MANAGER.getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
