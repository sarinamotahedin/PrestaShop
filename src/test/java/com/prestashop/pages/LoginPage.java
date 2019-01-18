package com.prestashop.pages;

import com.prestashop.utilities.Driver;
import com.prestashop.utilities.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "email")
    public WebElement enterUserName;

    @FindBy(id = "passwd")
    public WebElement enterPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    public WebElement loginErrorMsg;

    //Action
    public void login(String username, String password) {
        this.enterUserName.sendKeys(username);
        this.enterPassword.sendKeys(password);
        this.signInBtn.click();
    }





}
