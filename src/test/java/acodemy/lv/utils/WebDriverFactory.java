package acodemy.lv.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = ThreadLocal.withInitial(ChromeDriver::new);


    public static WebDriver getWebDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitWebDriver(){
        webDriverThreadLocal.get().close();
        webDriverThreadLocal.get().quit();

    }



}
