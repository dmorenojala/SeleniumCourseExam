package com.jalasoft.pivotal.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Environment parameters provider.
 */
public final class Environment {

    private static final String CONFIG = "gradle.properties";

    private static final String PRIMARY_AUTHENTICATION_USER = "user";

    private static final String PRIMARY_AUTHENTICATION_PASS = "password";

    private static final String PROFILE_NAME = "profile";

    private static final String BASE_URL = "baseUrl";

    private static final String WEB_DRIVER_NAME = "webDriverName";

    private static final String WEB_DRIVER_PATH = "webDriverPath";

    private static final String WAIT_TIMEOUT = "waitTimeout";

    private static Environment environment;

    private Properties properties;

    /**
     * Constructor.
     */
    private Environment() {
        try (FileInputStream fileStream = new FileInputStream(CONFIG)) {
            this.properties = new Properties();
            this.properties.load(fileStream);
        } catch (FileNotFoundException e) {
            // Do nothing
        } catch (IOException e) {
            // Do nothing
        }
    }

    /**
     * Get instance.
     *
     * @return the Environment instance.
     */
    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }

        return environment;
    }

    /**
     * @param propertyKey The property key/
     * @return The property value
     */
    public String getProperty(final String propertyKey) {
        String property = System.getProperty(propertyKey);
        if (property == null) {
            return this.properties.getProperty(propertyKey);
        }
        return property;
    }

    /**
     * @return The base url
     */
    public String getBaseUrl() {
        return this.getProperty(BASE_URL);
    }

    /**
     * @return The web driver path
     */
    public String getWebDriverPath() {
        return this.getProperty(WEB_DRIVER_PATH);
    }


    /**
     * @return The web driver name.
     */
    public String getWebDriverName() {
        return this.getProperty(WEB_DRIVER_NAME);
    }


    /**
     * @return The user
     */
    public String getUser() {
        return this.getProperty(PRIMARY_AUTHENTICATION_USER);
    }

    /**
     * @return The password
     */
    public String getPassword() {
        return this.getProperty(PRIMARY_AUTHENTICATION_PASS);
    }

    /**
     * return the profile name.
     * @return String whit the password
     */
    public String getProfileName() {
        return this.getProperty(PROFILE_NAME);
    }

    /**
     * @return The wait timeout.
     */
    public int getWaitTimeout() {
        return Integer.parseInt(this.getProperty(WAIT_TIMEOUT));
    }

}
