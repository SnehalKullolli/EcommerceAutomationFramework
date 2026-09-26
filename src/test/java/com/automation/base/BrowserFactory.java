package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            
            ChromeOptions options = new ChromeOptions(); // Disable Chrome password manager prompts 
            options.setExperimentalOption("prefs", java.util.Map.of(
            	    "credentials_enable_service", false,
            	    "profile.password_manager_enabled", false,
            	    "profile.password_manager_leak_detection", false
            	));
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {

            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
