package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class ScreenshotUtil {

    public static File saveElementScreenshot(WebElement element, File target) {
        target.getParentFile().mkdirs();
        File src = element.getScreenshotAs(OutputType.FILE);
        src.renameTo(target);
        return target;
    }

    public static File savePageScreenshot(WebDriver driver, File target) {
        target.getParentFile().mkdirs();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        src.renameTo(target);
        return target;
    }
}