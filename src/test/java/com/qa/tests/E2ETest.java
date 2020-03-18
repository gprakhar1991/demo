package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CreateNewAccount;
import com.qa.pages.Homepage;
import com.qa.pages.ManageAccount;
import com.qa.pages.ProductsPage;

public class E2ETest extends TestBase {

    Homepage homepage;
    ManageAccount manageAccount;
    CreateNewAccount newAccount;
    ProductsPage productsPage;

    public E2ETest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initBrowser(property.getProperty("URL"));
        homepage = new Homepage();
        manageAccount = homepage.signIn();
    }

    @Test(priority = 1, enabled = false)
    public void createNewAccount() {
        String email = property.getProperty("EMAIL");

        String title = property.getProperty("TITLE");
        String fname = property.getProperty("CUST_FNAME");
        String lname = property.getProperty("CUST_LNAME");
        String pwd = property.getProperty("NEW_PASSWORD");

        String dobDate = property.getProperty("DOB_DATE");
        String dobMonth = property.getProperty("DOB_MONTH");
        String dobYear = property.getProperty("DOB_YEAR");

        String custCity = property.getProperty("CUST_CITY");
        String custState = property.getProperty("CUST_STATE");

        String custMobile = property.getProperty("CUST_MOBILE");

        newAccount = manageAccount.newAccount(email);
        newAccount.setDetailsAndRegister(title, fname, lname, pwd, dobDate, dobMonth, dobYear, custCity, custState, custMobile);

        manageAccount.logout();
    }

    @Test(priority = 2)
    public void loginAndAddProductToCart() {
        productsPage = manageAccount.userLogin(property.getProperty("USERNAME"), property.getProperty("PASSWORD"));

        manageAccount.selectCategory();

        productsPage.openProductDetails();

        productsPage.increaseQuantity();

        productsPage.addProductToCart();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
