package com.jalasoft.pivotal.ui;

import com.jalasoft.pivotal.common.Environment;
import com.jalasoft.pivotal.ui.common.CommonNavigator;
import com.jalasoft.pivotal.ui.pages.AccountHomePage;
import com.jalasoft.pivotal.ui.pages.AccountsPage;
import com.jalasoft.pivotal.ui.pages.AccountSettings;
import com.jalasoft.pivotal.ui.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


/**
 * AccountTest.
 */
public class AccountTest {
    private final String accountName = "TestAccount-" + UUID.randomUUID();

    /**
     * BeforeClass.
     */
    @BeforeClass
    public void setUp() {
        // Given
        final Environment environment = Environment.getInstance();

        HomePage.signInAs(environment.getUser(), environment.getPassword());
    }

    /**
     * createNewAccountTest.
     */
    @Test
    public void createNewAccountTest() {
        // When
        CommonNavigator.goToAccountsPage();
        AccountsPage accountsPage = new AccountsPage();


        AccountHomePage accountHome = accountsPage.createNewAccount(this.accountName);

        // Then
        assertEquals(accountHome.getAccountName(), this.accountName);

        CommonNavigator.goToAccountsPage();
        List<String> accountsNames = accountsPage.getAccountsNames();
        assertTrue(accountsNames.contains(this.accountName.toUpperCase()));
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
