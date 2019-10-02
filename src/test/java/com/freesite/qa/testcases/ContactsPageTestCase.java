package com.freesite.qa.testcases;

import com.freesite.qa.base.TestBase;
import com.freesite.qa.pages.ContactsPage;
import com.freesite.qa.pages.HomePage;
import com.freesite.qa.pages.LoginPage;
import com.freesite.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.freesite.qa.pages.ContactsPage.sheetName;

public class ContactsPageTestCase extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    ContactsPageTestCase(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on page");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 3, dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String firstName, String lastName) {
        contactsPage.clickOnNewContactLink();
        //contactsPage.createNewContact("Dhara", "Gupta");
        contactsPage.createNewContact(firstName, lastName);
    }

    @AfterMethod
    public void tearDown(){
        webDriver.close();
    }
}
