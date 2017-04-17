package com.jalasoft.pivotal.ui;

import com.jalasoft.pivotal.common.Environment;
import com.jalasoft.pivotal.ui.common.CommonNavigator;
import com.jalasoft.pivotal.ui.pages.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

import static org.testng.Assert.assertEquals;


/**
 * AccountTest.
 */
public class AccountTest {
    private final String accountName = "TestAccount-" + UUID.randomUUID();

    private DashboardPage dashboard;

    /**
     * BeforeClass.
     */
    @BeforeClass
    public void setUp() {
        // Given
        final Environment environment = Environment.getInstance();

        this.dashboard = HomePage.signInAs(environment.getUser(), environment.getPassword());
    }

    /**
     * createNewAccountTest.
     */
    @Test
    public void createNewAccountTest() {
        // When
        CommonNavigator.goToAccountsPage();
        AccountsPage accountsPage = new AccountsPage();


        AccountHomePage accountHome = accountsPage.CreateNewAccount(this.accountName);

        // Then
        assertEquals(accountHome.getAccountName(), this.accountName);

        CommonNavigator.goToAccountsPage();
        List<String> accountsNames = accountsPage.GetAccountsNames();
        assertEquals(accountsNames.contains(this.accountName.toUpperCase()), true);
    }

    /**
     * tearDown.
     */
    @AfterClass
    public void tearDown() {
        CommonNavigator.goToAccountsPage();
        AccountsPage accountsPage = new AccountsPage();
        AccountHomePage accountHomePage = accountsPage.goToAccountHomePage(this.accountName);
        AccountSettings accountSettings = accountHomePage.clickOnSettings();
        accountSettings.deleteAccount();
    }
}
