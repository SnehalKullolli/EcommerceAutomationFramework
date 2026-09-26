package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    private WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(20));
    }

    public void waitForVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}