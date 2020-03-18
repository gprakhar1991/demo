package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class Homepage extends TestBase {

    @FindBy(xpath = "//a[@title = 'Log in to your customer account']")
    WebElement signIn;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public ManageAccount signIn() {
        click(signIn);

        return new ManageAccount();
    }

}
