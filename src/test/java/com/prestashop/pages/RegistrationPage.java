package com.prestashop.pages;


import com.prestashop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //Page Factory - Object Repo
    @FindBy(id = "email_create")
    public WebElement createEmail;

    @FindBy(id = "id_gender2")
    public WebElement femaleRadioBtn;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    //email.clear and sendkeys fake email to ensure line 59 from functionalities class
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement inputPassword;

    //Enter your address information
    @FindBy(id = "address1")
    public WebElement addressLine1;

    @FindBy(id = "city")
    public WebElement addressCity;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement zipCode;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy(id = "submitAccount")
    public WebElement submitButton;

    @FindBy(linkText = "Sign out")
    public WebElement signOut;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    public WebElement errorMsg;



}

