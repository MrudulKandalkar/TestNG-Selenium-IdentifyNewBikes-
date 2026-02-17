package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ScreenshotUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UsedCarsPage extends BasePage {

    private final By buyUsedCars = By.xpath("//a[@title='Buy Used Cars']");
    private final By chennaiLocation = By.xpath("//li[contains(@class,'border-b py-3 lg:px-0 cursor-pointer')]//span[contains(@class,'text-black font-14')][normalize-space()='Chennai']");
    private final By modelLabels = By.cssSelector("ul.gap-y-2 li label");

    public UsedCarsPage openBuyUsedCars() {
        click(buyUsedCars);
        return this;
    }

    public UsedCarsPage selectChennai() {
        scrollIntoViewCenter(chennaiLocation);
        click(chennaiLocation);
        return this;
    }

    public List<String> getPopularModels() {
        List<WebElement> labels = driver.findElements(modelLabels);
        List<String> results = new ArrayList<>();
        for (WebElement label : labels) {
            String text = label.getText().trim();
            if (text.startsWith("Between")) break; // stop at price filter section (same as original)
            if (!text.isEmpty()) results.add(text);
        }
        return results;
    }
    public File captureUsedCarInCityScreenshot(File targetFile) {
        WebElement el = find(modelLabels);
        scrollIntoViewCenter(el);
        return ScreenshotUtil.saveElementScreenshot(el, targetFile);
    }
}