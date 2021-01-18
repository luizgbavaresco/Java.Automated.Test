package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.EnterVehicleData;

import java.util.concurrent.TimeUnit;

public class OpenSite extends BasePage{
    public static final String webDriverPath = "C:\\Users\\Luiz Gustavo\\IdeaProjects\\com.accenture.test.java\\src\\test\\resources\\Drivers\\chromedriver.exe";

    public OpenSite(WebDriver driver) {
        super(driver);
    }


    public static WebDriver openChrome() {
        //Open Chrome
        System.setProperty("webdriver.chrome.driver", webDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public EnterVehicleData openURL(String URL){
        driver.get(URL);

        return new EnterVehicleData(driver);

    }
}
