package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Home page.
 */
public class HomePage extends BasePage {
    @FindBy(css = "div.header__lg > a[href='/signin']")
    @CacheLookup
    private WebElement signInLink;

    /**
     * @return SignInPage
     */
    public SignInPage clickSignInLink() {
        CommonActions.clickElement(signInLink);
        return new SignInPage();
    }

    /**
     * @param username the username or email
     * @param password the password
     * @return The dashboard page
     */
    public static DashboardPage signInAs(final String username, final String password) {
        HomePage welcomePage = new HomePage();
        SignInPage signInForm = welcomePage.clickSignInLink();

        signInForm.setUsernameField(username);
        signInForm.clickNextButton();
        signInForm.setPasswordField(password);

        return signInForm.clickSignInLink();
    }
}
