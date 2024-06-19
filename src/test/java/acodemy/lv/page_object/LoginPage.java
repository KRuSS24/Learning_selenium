package acodemy.lv.page_object;

import acodemy.lv.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //WebDriver  driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void authorize(String userName, String passwd){
        getUsernameField().sendKeys(userName);
        getPasswordField().sendKeys(passwd);
        getLoginButton().click();
    }

}
