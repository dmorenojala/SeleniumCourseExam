package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * SignInPage.
 */
public class SignInPage extends BasePage {

    @FindBy(id = "credentials_username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "credentials_password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(name = "action")
    private WebElement nextButton;

    /**
     * @param email The email.
     */
    public void setUsernameField(final String email) {
        CommonActions.sendKeys(this.usernameField, email);
    }

    /**
     * @param password The password.
     */
    public void setPasswordField(final String password) {
        CommonActions.sendKeys(this.passwordField, password);
    }

    /**
     * clickNextButton.
     */
    public void clickNextButton() {
        CommonActions.clickElement(this.nextButton);
    }

    /**
     * @return The dashboard page.
     */
    public DashboardPage clickSignInLink() {
        this.clickNextButton();
        return new DashboardPage();
    }
}
