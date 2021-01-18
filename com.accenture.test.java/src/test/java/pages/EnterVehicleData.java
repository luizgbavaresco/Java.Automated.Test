package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class EnterVehicleData extends BasePage{

    //Locators
    String checkXpath = "//label[contains(text(),'Number of Seats')]";
    String checkValue = "Number of Seats";
    String automobileId = "nav_automobile";
    String makerId = "//select[@id='make']";
    String engineId = "engineperformance";
    String manufactureId = "dateofmanufacture";
    String seatsid = "numberofseats";
    String fuelId = "fuel";
    String listPriceId = "listprice";
    String annualMileageId = "annualmileage";
    String nextPageButtonId = "nextenterinsurantdata";

    public EnterVehicleData(WebDriver driver) {
        super(driver);
    }

    public EnterVehicleData checkPage() {
        String checkNextPage = driver.findElement(By.xpath(checkXpath)).getText();
        Assert.assertEquals(checkNextPage, checkValue);

        return this;
    }

    public EnterVehicleData goToAutomobile(){
        driver.findElement(By.id(automobileId)).click();
        return this;
    }


    public EnterVehicleData selectMaker(String maker) {
        WebElement selectMaker = driver.findElement(By.xpath(makerId));
        new Select(selectMaker).selectByValue(maker);
        return this;
    }

    public EnterVehicleData insertPerfomance(String engine) {
        driver.findElement(By.id(engineId)).sendKeys(engine);
        return this;
    }

    public EnterVehicleData manufactureDate(String manufactureDate) {
        driver.findElement(By.id(manufactureId)).sendKeys(manufactureDate);
        return this;
    }

    public EnterVehicleData selectSeatsId(String seatsValue){
        WebElement selectSeats = driver.findElement((By.id(seatsid)));
        new Select(selectSeats).selectByValue(seatsValue);
        return this;
    }

    public EnterVehicleData selectFuelId(String fuelValue) {
        WebElement selectFuel = driver.findElement((By.id(fuelId)));
        new Select(selectFuel).selectByValue(fuelValue);
        return this;
    }

    public EnterVehicleData insertListPrice(String listPriceValue) {
        driver.findElement(By.id(listPriceId)).sendKeys(listPriceValue);
        return this;
    }
    public EnterVehicleData insertAnualMileage(String annualMileageValue){
        driver.findElement(By.id(annualMileageId)).sendKeys(annualMileageValue);
        return this;

    }
    public EnterInsurantData clickNextPage() {
        driver.findElement((By.id(nextPageButtonId))).click();

        return new EnterInsurantData(driver);
    }

    public EnterInsurantData fillEnterVehicleDataAndGoToInsurantData(String maker, String engine, String manufactureDate,
                                                                     String seatsValue, String fuelValue, String listPriceValue
                                                                     ,String annualMileageValue){
        checkPage();
        goToAutomobile();
        selectMaker(maker);
        insertPerfomance(engine);
        manufactureDate(manufactureDate);
        selectSeatsId(seatsValue);
        selectFuelId(fuelValue);
        insertListPrice(listPriceValue);
        insertAnualMileage(annualMileageValue);
        clickNextPage();

        return new EnterInsurantData(driver);

    }


}
