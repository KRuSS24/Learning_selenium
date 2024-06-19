package FirstTestPackage;

import acodemy.lv.page_object.*;
import acodemy.lv.utils.Config;

import acodemy.lv.utils.WebDriverFactory;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SauceDemoTest {


    WebDriver driver = WebDriverFactory.getWebDriver();
    LoginPage loginPage;
    ProductsPage productsPage;
    HeaderPage headerPage;
    CartPage cartPage;
    CheckOutOne checkOutOne;
    CheckOutTwo checkOutTwo;

    Config config = Config.readConfig();

    @BeforeTest
    public void beforeSimpleTest() {


        driver.get(config.getInitWeb().getWebAddress());

        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        headerPage = new HeaderPage();
        checkOutOne = new CheckOutOne();
        checkOutTwo = new CheckOutTwo();



    }

    @Test
    public void mySimpleTest() {


        loginPage.authorize(config.getCredentials().getLogin(), config.getCredentials().getPasswd());

        Assert.assertEquals(productsPage.getProductPageTitle().getText(), "Products");


    }

    @Test
    public void testAddItemToCart() {
        //log.info("Authorize using credentials");
        loginPage.authorize(config.getCredentials().getLogin(), config.getCredentials().getPasswd());

        // log.info("Asserting Products page title");
        Assert.assertEquals(productsPage.getProductPageTitle().getText(), "Products");

        //log.info("Add product to Cart");
        productsPage.addItemToCartByNameContains("Onesie");

        //log.info("Open the cart");
        headerPage.getOpenCartButton().click();


        //log.info("Assert that cart contains one product");
        Assertions.assertThat(cartPage.getCartItems()).hasSize(1);

        cartPage.checkOutClick();

        checkOutOne.anketaAndContinue(config.getUserData().getFirstName(),config.getUserData().getLastName(),
                config.getUserData().getZipCode());

        checkOutTwo.checkOutFinish();


        System.out.println("Test");

    }




    @AfterTest
    public void afterTest() {

        WebDriverFactory.quitWebDriver();

    }

}
