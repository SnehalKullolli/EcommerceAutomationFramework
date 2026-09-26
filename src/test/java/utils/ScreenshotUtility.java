package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtility {

    public static String capture(WebDriver driver,
                                 String fileName) {

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now() .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File screenshotFolder = new File("screenshots"); 
        if (!screenshotFolder.exists()) { screenshotFolder.mkdirs(); }
        File destination = new File( screenshotFolder, fileName + "_" + timestamp + ".png" );

        try { FileUtils.copyFile(source, destination);
        System.out.println( "Screenshot saved: " + destination.getAbsolutePath() ); 
        return destination.getAbsolutePath(); 
        } catch (IOException e) {

        	throw new RuntimeException( "Failed to save screenshot", e );
        }

        
        
    }

}