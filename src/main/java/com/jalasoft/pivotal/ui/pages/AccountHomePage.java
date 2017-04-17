package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import com.jalasoft.pivotal.ui.common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *  AccountHomePage
 */
public class AccountHomePage extends BasePage {
    private final String tabSelectorTemplate = "ul.buttons a[href*='%s']";

    @FindBy(css = "h2.account_name span")
    @CacheLookup
    private WebElement accountNameHeader;

    /**
     * @return account name
     */
    public String getAccountName(){
        return CommonActions.getText(this.accountNameHeader);
    }

    /**
     * @return AccountSettings
     */
    public AccountSettings clickOnSettings(){
        this.clickOnTab("settings");

        return new AccountSettings();
    }

    /**
     * @param tabName tabName
     */
    private void clickOnTab(String tabName){
        By tabSelector = By.cssSelector(String.format(tabSelectorTemplate, tabName));
        WebElement tabElement = DriverManager.getInstance().getDriverWait()
                .until(ExpectedConditions.visibilityOfElementLocated(tabSelector));

        CommonActions.clickElement(tabElement);
    }
}
