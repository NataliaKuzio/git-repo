package com.mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    @FindBy (xpath = "//button[@name='Submit']")
    private WebElement addButton;

    @FindBy (xpath = "//a[@title='Proceed to checkout']")
    private WebElement addTitle;

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(){ addButton.click();}

    public void buyProduct () { addTitle.click();}
}
