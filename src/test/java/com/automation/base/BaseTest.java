package com.automation.base;

import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;

public class BaseTest {

    protected WebDriver driver;
   

    @BeforeSuite(alwaysRun = true)
    public void cleanScreenshots() {

        File folder = new File("screenshots");

        if (folder.exists()) {

            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        driver = BrowserFactory.createDriver(browser);
        System.out.println("========== SETUP ==========");
        System.out.println("Browser: " + browser);
        System.out.println("driver: " + driver);
        System.out.println("Thread: " + Thread.currentThread().getId());


        DriverFactory.setDriver(driver);
        System.out.println("Factory driver: " + DriverFactory.getDriver());
     
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {

            DriverFactory.getDriver().quit();

            DriverFactory.unload();
        }
    }
}
