package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class EaappHomePage {
    public EaappHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Login")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButton;


    public void login() {
        loginLink.click();
        username.sendKeys(ConfigReader.getProperty("userName"));
        password.sendKeys(ConfigReader.getProperty("password"));
        loginButton.click();

    }
}