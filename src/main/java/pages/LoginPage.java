package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtil;

import java.io.File;

public class LoginPage extends BasePage {

    private final By mobileField = By.id("mobilefiled");
    private final By errorMessageSpan = By.xpath("//span[normalize-space()='Please Enter Valid Mobile Number']");
    private final By warningContainer = By.xpath("//div[contains(@class,'open !bg-white absolute z-[999] ')]");

    public LoginPage enterMobile(String mobile) {
        type(mobileField, mobile);
        return this;
    }

    public String getInvalidMobileError() {
        return getText(errorMessageSpan);
    }

    public File captureWarningScreenshot(File targetFile) {
        WebElement el = find(warningContainer);
        scrollIntoViewCenter(el);
        return ScreenshotUtil.saveElementScreenshot(el, targetFile);
    }
}