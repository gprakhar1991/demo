package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ProductsPage extends TestBase {

    @FindBy(xpath = "//a[contains(@rel, 'id_product=1') and @class = 'quick-view']")
    WebElement product1;

    @FindBy(xpath = "//i[@class = 'icon-plus']")
    WebElement addQuantity;

    @FindBy(name = "Submit")
    WebElement addToCart;

    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    public void openProductDetails() {
        click(product1);
    }

    public void increaseQuantity() {
        click(addQuantity);
    }

    public void addProductToCart() {
        click(addToCart);
    }

}
