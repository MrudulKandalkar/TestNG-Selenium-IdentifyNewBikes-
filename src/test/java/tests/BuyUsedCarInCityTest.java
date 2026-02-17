package tests;

import listeners.ExtentTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UsedCarsPage;
import utils.ExcelUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Listeners(ExtentTestNGListener.class)
public class BuyUsedCarInCityTest extends BaseTest {

    @Test(description = "Extract popular used car models in Chennai and write to Excel")
    public void buyUsedCarChennai() {
        new HomePage().open().clickUsedCarsMenu();
        UsedCarsPage used = new UsedCarsPage().openBuyUsedCars().selectChennai();

        List<String> models = used.getPopularModels();
        System.out.println("Car Models Found:\n----------------");
        models.forEach(System.out::println);

        File excel = new File(System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "usedCarData.xlsx");
        ExcelUtil.writeUsedCars("Chennai", models, excel);

        // Back to home (to stay consistent with your original flow)
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File target = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "usedCarInCity"+timestamp+".png");
        used.captureUsedCarInCityScreenshot(target);
        new HomePage().open();
    }
}
