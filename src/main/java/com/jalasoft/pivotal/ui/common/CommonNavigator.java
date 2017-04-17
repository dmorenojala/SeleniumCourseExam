package com.jalasoft.pivotal.ui.common;

import com.jalasoft.pivotal.common.Environment;

/**
 * CommonNavigator.
 */
public final class CommonNavigator {

    private static final String ACCOUNTS_PAGE = "accounts";

    /**
     * constructor.
     */
    private CommonNavigator() {
    }

    /**
     * go to accounts page.
     */
    public static void goToAccountsPage() {
        final String url = String.format("%s/%s", Environment.getInstance().getBaseUrl(), ACCOUNTS_PAGE);
        DriverManager.getInstance().getDriver().navigate().to(url);
    }
}
