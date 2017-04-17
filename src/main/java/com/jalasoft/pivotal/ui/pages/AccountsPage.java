package com.jalasoft.pivotal.ui.pages;

import com.jalasoft.pivotal.ui.common.CommonActions;
import com.jalasoft.pivotal.ui.common.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * AccountsPage
 */
public class AccountsPage extends BasePage {

    private final By accountsNameSelector = By.cssSelector("#accounts_module h3 div.name");

    @FindBy(id = "new_account_link")
    @CacheLookup
    private WebElement createAccountLink;

    @FindBy(id = "account_name")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(id = "add_account_button")
    @CacheLookup
    private WebElement addAccountButton;

    /**
     * @param accountName the account name
     * @return AccountHomePage
     */
    public AccountHomePage CreateNewAccount(String accountName){
        CommonActions.clickElement(this.createAccountLink);

        CommonActions.sendKeys(this.accountNameField, accountName);
        CommonActions.clickElement(this.addAccountButton);

        return new AccountHomePage();
    }

    /**
     * @return the accounts names
     */
    public List<String> GetAccountsNames(){
        List<WebElement> accountElements = DriverManager.getInstance().getDriverWait()
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.accountsNameSelector));

        return accountElements.stream().map(webElement -> CommonActions.getText(webElement)).collect(Collectors.toList());
    }

    /**
     * @param accountName The account name
     * @return AccountHomePage
     */
    public AccountHomePage goToAccountHomePage(String accountName){
        By accountSelector = By.xpath(
                String.format("//div[text()='%s']/parent::div/parent::h3/following-sibling::a[2]", accountName));

        WebElement manageAccountButton = DriverManager.getInstance().getDriverWait()
                .until(ExpectedConditions.visibilityOfElementLocated(accountSelector));
        CommonActions.clickElement(manageAccountButton);

        return new AccountHomePage();
    }
}
