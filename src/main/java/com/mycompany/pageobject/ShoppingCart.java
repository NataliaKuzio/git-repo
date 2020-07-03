package com.mycompany.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

public class ShoppingCart {
    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement Summary;

    @FindBy (xpath = "//button[@name='processAddress']")
    private WebElement Address;

    @FindBy (xpath = "//div[@class='checker']")
    private WebElement TermsOfService;

    @FindBy (xpath = "//button[@name='processCarrier']")
    private WebElement Shipping;

    private final WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void summaryProduct(){ Summary.click();}
    public void deliveryAddress () {Address.click();}
    public void shippingOption () {
        TermsOfService.click();
        Shipping.click();}

}
