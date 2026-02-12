package tests;

import listeners.ExtentTestNGListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

@Listeners(ExtentTestNGListener.class)
public class LoginErrorTest extends BaseTest {

    @Test(description = "Validate invalid mobile error and capture warning screenshot")
    public void validateLoginError() {
        new HomePage().open().openLoginPopup();
        LoginPage login = new LoginPage().enterMobile("888888888888");

        String expected = "Please Enter Valid Mobile Number";
        String actual = login.getInvalidMobileError();
        Assert.assertEquals(actual, expected, "Error message should match");

        File target = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "warningMessage.png");
        login.captureWarningScreenshot(target);
    }
}