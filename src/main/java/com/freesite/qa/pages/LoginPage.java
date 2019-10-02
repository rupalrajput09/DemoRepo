package com.freesite.qa.pages;

import com.freesite.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    // Define page factory (or Object Repository)

    @FindBy(xpath = "//span[text() = \"Log In\"]")
    WebElement login;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//div[text() = \"Login\"]")
    WebElement login_existingUser;

    @FindBy(xpath = "//span[@class=\"brand-slogan\"]")
    WebElement brandSlogan;

    @FindBy(xpath = "//a[text() = \"About\"]")
    WebElement about;

    // Initializing the page objects
    public LoginPage(){
        PageFactory.initElements(webDriver, this);
    }

// Actions, Features

    public HomePage login(String un, String pwd){
        login.click();
        email.sendKeys(un);
        password.sendKeys(pwd);
        login_existingUser.click();
        return new HomePage();
    }

    public String validateLoginPageTitle(){
        return webDriver.getTitle();
    }

    public void checkAbout(){
        about.click();
    }
}
