package com.freesite.qa.testcases;

import com.freesite.qa.base.TestBase;
import com.freesite.qa.pages.HomePage;
import com.freesite.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTestCase extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    LoginPageTestCase() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 0)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        System.out.println("Title is ==>" + title);
        Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
    }

    @Test(priority = 1)
    public void checkClickAbout() {
        loginPage.checkAbout();
        System.out.println("Clicked on About");
    }

    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        webDriver.close();
    }
}
