package com.freesite.qa.testcases;

import com.freesite.qa.base.TestBase;
import com.freesite.qa.pages.ContactsPage;
import com.freesite.qa.pages.HomePage;
import com.freesite.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTestCase extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public HomePageTestCase(){
    super();
}

   @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(properties.getProperty("userName"), properties.getProperty("password"));
   }

   @Test(priority = 1)
   public void verifyHomePageTitleTest(){
        String homePageTitle = homePage.verifyHomePageTitle();
       Assert.assertEquals(homePageTitle, "Cogmento CRM", "homePageTitleNotMatched");
   }

   @Test(priority = 2)
        public void verifyHomePageUserName(){
        Assert.assertTrue(homePage.verifyCorrectUserName());
   }

   @Test(priority = 3)
   public void verifyContactsLinkTest(){
        contactsPage =  homePage.clickOnContactsLink();
   }

   @AfterMethod
    public void tearDown(){
        webDriver.close();
   }


}
