package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ManageAccount extends TestBase {

    @FindBy(name = "email_create")
    WebElement createAccountEmail;

    @FindBy(id = "email")
    WebElement loginEmail;

    @FindBy(id = "passwd")
    WebElement loginPassword;

    @FindBy(name = "SubmitLogin")
    WebElement signIn;

    @FindBy(xpath = "//a[@title = 'Log me out']")
    WebElement signOut;

    @FindBy(xpath = "//a[@title = 'Women']")
    WebElement women;

    public ManageAccount() {
        PageFactory.initElements(driver, this);
    }

    public CreateNewAccount newAccount(String email) {
        setValue(createAccountEmail, email);
        click(signIn);

        return new CreateNewAccount();
    }

    public ProductsPage userLogin(String email, String passwd) {
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(passwd);
        click(signIn);

        return new ProductsPage();

    }

    public void selectCategory() {
        click(women);
    }

    public void logout() {
        click(signOut);
    }

}
