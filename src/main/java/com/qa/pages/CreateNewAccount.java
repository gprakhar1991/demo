package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CreateNewAccount extends TestBase {

    @FindBy(name = "id_gender1")
    WebElement titleMr;

    @FindBy(id = "id_gender2")
    WebElement titleMrs;

    @FindBy(id = "customer_firstname")
    WebElement custFName;

    @FindBy(id = "customer_lastname")
    WebElement custLName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "firstname")
    WebElement addressFName;

    @FindBy(id = "lastname")
    WebElement addressLName;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "id_country")
    WebElement country;

    @FindBy(id = "phone_mobile")
    WebElement mobileContact;

    @FindBy(id = "alias")
    WebElement aliasAddress;

    @FindBy(name = "submitAccount")
    WebElement register;

    public CreateNewAccount() {
        PageFactory.initElements(driver, this);
    }

    public void setDetailsAndRegister(String title, String fname, String lname, String pwd, String dobDate, String dobMonth, String dobYear,
            String custCity, String custState, String custMobile) {
        setTitle(title);
        setPersonalInfo(fname, lname, pwd);
        setDOB(dobDate, dobMonth, dobYear);
        setAddressInfo(custCity, custState);
        setAdditionalInfo(custMobile);
    }

    private void setTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMr);
        } else {
            click(titleMrs);
        }
    }

    private void setPersonalInfo(String fname, String lname, String pwd) {
        setValue(custFName, fname);
        setValue(custLName, lname);
        setValue(password, pwd);
    }

    private void setDOB(String dobDate, String dobMonth, String dobYear) {
        selectValueFromDropdown(day, dobDate);
        selectValueFromDropdown(month, dobMonth);
        selectValueFromDropdown(year, dobYear);
    }

    private void setAddressInfo(String custCity, String custState) {
        setValue(city, custCity);
        setValue(state, custState);
    }

    private void setAdditionalInfo(String custMobile) {
        setValue(mobileContact, custMobile);
    }

}
