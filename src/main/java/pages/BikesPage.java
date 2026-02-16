package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ScreenshotUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BikesPage extends BasePage {

    private final By upcomingBikesLink = By.xpath("//a[@title='Upcoming Bikes in India']");
    private final By bikesUnder2Lakh = By.linkText("Bikes Under 2 Lakh");
    private final By companyHonda = By.xpath("//label[contains(.,'Honda')]");
    private final By budgetUnder4Lakh = By.xpath("//label[contains(., 'Under 4 Lakh')]");

    private final By bikeCards = By.xpath("//li[contains(@class, 'relative w-full')]");
    private final By upcomingBikesContainer = By.xpath("//div[@class='p-2 gap-2 lg:p-0']");

    public BikesPage openUpcomingBikes() {
        click(upcomingBikesLink);
        return this;
    }

    public BikesPage filterUnder2Lakh() {
        scrollIntoViewCenter(bikesUnder2Lakh);
        click(bikesUnder2Lakh);
        return this;
    }

    public BikesPage filterCompanyHonda() {
        click(companyHonda);
        return this;
    }

    public BikesPage filterBudgetUnder4Lakh() {
        scrollIntoViewCenter(budgetUnder4Lakh);
        click(budgetUnder4Lakh);
        return this;
    }

    public List<String[]> collectBikeCards() {
        List<WebElement> cards = driver.findElements(bikeCards);
        List<String[]> rows = new ArrayList<>();
        for (WebElement card : cards) {
            String name = card.findElement(By.xpath(".//a")).getText().trim();
            String price = card.findElement(By.xpath(".//span[contains(text(),'Expected price')]/following-sibling::div")).getText().trim();
            String launch = card.findElement(By.xpath(".//span[contains(text(),'Expected Launch')]/following-sibling::div")).getText().trim();
            rows.add(new String[]{name, price, launch});
        }
        return rows;
    }

    public File captureUpcomingBikesScreenshot(File targetFile) {
        WebElement container = find(upcomingBikesContainer);
        scrollIntoViewCenter(container);
        return ScreenshotUtil.saveElementScreenshot(container, targetFile);
    }
}
