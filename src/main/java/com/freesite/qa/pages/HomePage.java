package com.freesite.qa.pages;

import com.freesite.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(xpath = "//span[contains(text(),\"Rupal  Rajput\")]")
    @CacheLookup
    WebElement usernameLabel;

    @FindBy(xpath = "//span[text() = \"Contacts\"]")
    WebElement contactsLink;

    @FindBy(xpath = "//span[text() = \"Deals\"]")
    WebElement dealsLink;

    @FindBy(xpath = "//span[text() = \"Tasks\"]")
    WebElement tasksLink;

    public HomePage(){
        PageFactory.initElements(webDriver, this);
    }

    public String verifyHomePageTitle(){
        return webDriver.getTitle();
    }

    public boolean verifyCorrectUserName(){
       return usernameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }



}
