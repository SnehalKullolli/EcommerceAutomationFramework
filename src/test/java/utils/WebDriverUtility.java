package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {

    public static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    public static void back(WebDriver driver) {
        driver.navigate().back();
    }

    public static void forward(WebDriver driver) {
        driver.navigate().forward();
    }
}