package tests;

import listeners.ExtentTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BikesPage;
import pages.HomePage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Listeners(ExtentTestNGListener.class)
public class IdentifyNewBikesTest extends BaseTest {

    @Test(description = "Identify upcoming Honda bikes under 4 Lakh and capture screenshot")
    public void identifyNewBikes() {
        new HomePage().open().clickBikesMenu();

        BikesPage bikes = new BikesPage()
                .openUpcomingBikes()
                .filterUnder2Lakh()
                .filterCompanyHonda()
                .filterBudgetUnder4Lakh();

        List<String[]> rows = bikes.collectBikeCards();
        for (String[] r : rows) {
            System.out.println("Bike: " + r[0]);
            System.out.println("Price: " + r[1]);
            System.out.println("Launch: " + r[2]);
            System.out.println("----------------------");
        }
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File target = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "upcomingbikes"+timestamp+".png");
        bikes.captureUpcomingBikesScreenshot(target);
    }
}