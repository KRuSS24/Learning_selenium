package acodemy.lv.page_object;

import acodemy.lv.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {


    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public List<WebElement> getCartItems() {
        return cartItems;
    }

    public CartPage() {

        PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
    }

    public void checkOutClick() {
        checkoutButton.click();
    }

}
