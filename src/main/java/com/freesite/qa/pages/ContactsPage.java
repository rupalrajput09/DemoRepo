package com.freesite.qa.pages;

import com.freesite.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath = "//div[text() = \"Contacts\"]")
    WebElement contactsLabel;

    @FindBy(xpath = "//button[text()=\"New\"]")
    WebElement newContactLink;

    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "source")
    WebElement sourceDropDown;

    @FindBy(xpath = "//button[text() = \"Save\"]")
    WebElement saveButton;

    public static String sheetName = "contacts";

    public ContactsPage(){
        PageFactory.initElements(webDriver, this);
    }

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public void clickOnNewContactLink(){
    newContactLink.click();
    }

    public void createNewContact( String firstName, String lastName){
        //Select select = new Select(sourceDropDown);
        //select.selectByVisibleText(source);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        saveButton.click();

    }
}


//String source,