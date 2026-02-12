package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final String BASE_URL = "https://www.91wheels.com/";

    private final By bikesMenu = By.xpath("//span[contains(@title, 'Bikes') and contains(@class, 'leading-6 text-sm lg')]");
    private final By usedCarsMenu = By.xpath("//span[contains(@title, 'Used Cars') and contains(@class, 'leading-6 text-sm lg')]");
    private final By loginIcon = By.xpath("//*[name()='path' and contains(@d,'M21 21v-2c')]");

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage clickBikesMenu() {
        click(bikesMenu);
        return this;
    }

    public HomePage clickUsedCarsMenu() {
        click(usedCarsMenu);
        return this;
    }

    public HomePage openLoginPopup() {
        click(loginIcon);
        return this;
    }
}
