package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import com.jalasoft.pivotal.ui.common.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * AccountSettings.
 */
public class AccountSettings extends BasePage {

    @FindBy(css = "a[data-method*='delete']")
    @CacheLookup
    private WebElement deleteAccountLink;

    /**
     * deletes the current account.
     */
    public void deleteAccount() {
        CommonActions.clickElement(this.deleteAccountLink);
        Alert alert = DriverManager.getInstance().getDriver().switchTo().alert();
        alert.accept();
    }
}
