package pages;

import libs.ActionWithElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[@href='#']")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "//a[@href='register.html']")
    private WebElement registerLink;



    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public void loginUser(String login, String password){
        action.sendKeys(loginField, login);
//        loginField.sendKeys(login);
        action.sendKeys(passwordField, password);
//        passwordField.sendKeys(password);
        action.clickElement(submitButton);
    }




}
