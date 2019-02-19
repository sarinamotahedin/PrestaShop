package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentityPage {

   public IdentityPage(){
       PageFactory.initElements(Driver.getDriver(), this);
   }

    @FindBy(id = "firstname")
    public WebElement firstNameBox;

    @FindBy(id = "lastname")
    public WebElement LasNameBox;

    @FindBy(name = "submitIdentity")
    public WebElement saveBtn;

    @FindBy(xpath = "//ol//li")
    public WebElement passwordErrorMsg;

    @FindBy(linkText = "Back to your account")
    public WebElement backToAcctBtn;
}
