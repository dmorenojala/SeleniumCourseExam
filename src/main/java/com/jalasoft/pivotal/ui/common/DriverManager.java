package com.jalasoft.pivotal.ui.common;

import com.jalasoft.pivotal.common.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * DriverManager class.
 */
public final class DriverManager {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static DriverManager instance;

    private final WebDriver driver;

    private final WebDriverWait driverWait;

    /**
     * DriverManager.
     */
    private DriverManager() {
        final int timeout = ENVIRONMENT.getWaitTimeout();

        System.setProperty(ENVIRONMENT.getWebDriverName(),  ENVIRONMENT.getWebDriverPath());
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, timeout);

        driver.get(ENVIRONMENT.getBaseUrl());
        driver.manage().window().maximize();
    }

    /**
     * @return a DriverManager Object
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * @return The web driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * @return the web driver wait
     */
    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
