package FirstTestPackage;

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

public class SimpleTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);
    WebDriver driver = new ChromeDriver();



    @BeforeTest
    public void beforeSimpleTest() {

        logger.info("Init Chrome driver");


        logger.info("Opening HTTP");
        driver.get("https://www.google.com");

        logger.info("Find button and accept Cookies");
        driver.findElement(By.id("L2AGLb")).click();

        logger.info("Find and fill search field");
        driver.findElement(By.name("q")).sendKeys("acodemy.lv\n");



    }

    @Test
    public void mySimpleTest() {


        logger.info("Walidate...");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0, 1000);");


        delayForSomething(3000);

        List<WebElement> results = driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));

        Assert.assertEquals(results.size(), 16);

    }


    @AfterTest
    public void afterTest() {
        logger.info("Closing Chrome browser");
        driver.close();
        driver.quit();

    }

    private void delayForSomething(int delay){

        var startLoadingTime = System.currentTimeMillis();
        var waitingTime=startLoadingTime;
        do{
            waitingTime=System.currentTimeMillis();
        }while (waitingTime-startLoadingTime<=delay);

    }
}
