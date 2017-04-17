package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This base page abstract class.
 */
public abstract class BasePage {

    protected final WebDriver driver;

    protected final WebDriverWait wait;

    /**
     * Base page
     */
    protected BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getDriverWait();
        PageFactory.initElements(driver, this);
    }

}
