package acodemy.lv.page_object;

import acodemy.lv.utils.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTwo {
    @FindBy(id="finish")
    private WebElement finishButton;

    public CheckOutTwo(){
        PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
    }

    public WebElement getFinishButton() {
        return finishButton;
    }

    public void setFinishButton(WebElement finishButton) {
        this.finishButton = finishButton;
    }

    public void checkOutFinish(){
        getFinishButton().click();
    }
}
