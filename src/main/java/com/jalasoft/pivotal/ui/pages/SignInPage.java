package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "credentials_username")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(id = "credentials_password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(name = "action")
    private WebElement nextButton;

    public void setUsernameField(final String email) {
        CommonActions.sendKeys(this.usernameField, email);
    }

    public void setPasswordField(final String password) {
        CommonActions.sendKeys(this.passwordField, password);
    }

    public void clickNextButton() {
        CommonActions.clickElement(this.nextButton);
    }

    public DashboardPage clickSignInLink() {
        this.clickNextButton();
        return new DashboardPage();
    }
}
