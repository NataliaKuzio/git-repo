package com.mycompany.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@name='SubmitLogin']")
    private WebElement submitButton;

    public void login(String email, String password){
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        submitButton.click();
    }


   /* //ВАРІАНТ З ВІДЕО
    private By emailField = By.id("email");   // 1. описали локатори для всіх потрібних елементів
    private By passwordField = By.xpath("//input[@id='password']");
    private By submit = By.xpath("//button[@name='SubmitLogin']");

    public LoginPage typeEmail (String email) {  //2.написали методи для роботи з елементами
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this; //після введення даних повертаємо ту ж саму сторінку
    }

    public ProductPage clickSubmit (){
     driver.findElement(submit).click();
     return new ProductPage (driver); // наступна сторінка яка відкриється після LoginPage
    }

    public ProductPage register (String email, String password ){
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSubmit();
        return new ProductPage(driver);
    }*/





}


