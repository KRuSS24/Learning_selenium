package acodemy.lv.page_object;

import acodemy.lv.utils.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOne {

    @FindBy(id="first-name")
    private WebElement firstName;

    @FindBy(id="last-name")
    private WebElement lastName;

    @FindBy(id="postal-code")
    private WebElement postalCode;

    @FindBy(id="continue")
    private WebElement continueButton;




    public CheckOutOne(){
        PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void anketaAndContinue(String firstName, String secondName, String zipCode){
        getFirstName().sendKeys(firstName);
        getLastName().sendKeys(secondName);
        getPostalCode().sendKeys(zipCode);
        getContinueButton().click();
    }
}
