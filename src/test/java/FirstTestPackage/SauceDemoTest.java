package FirstTestPackage;

import acodemy.lv.page_object.LoginPage;
import acodemy.lv.page_object.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoTest {

    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage;
    ProductsPage productsPage;


    @BeforeTest
    public void beforeSimpleTest() {

        logger.info("Init Chrome driver");


        logger.info("Opening HTTP");
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        productsPage=new ProductsPage(driver);



    }

    @Test
    public void mySimpleTest() {

        loginPage.authorize("standard_user","secret_sauce");
        Assert.assertEquals(productsPage.getProductPageTitle().getText(), "Products");

    }


    @AfterTest
    public void afterTest() {
        logger.info("Closing Chrome browser");
        driver.close();
        driver.quit();

    }

}
