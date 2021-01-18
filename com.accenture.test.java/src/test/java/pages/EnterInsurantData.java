package pages;



import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class EnterInsurantData extends BasePage {

    //Locators
    String checkXpath = "//label[contains(text(),'First Name')]";
    String checkValue = "First Name";
    String firstNameId = "firstname";
    String lastNameId = "lastname";
    String birthId = "birthdate";
    String countryId = "country";
    String zipCodeId = "zipcode";
    String occupationID = "occupation";
    String hobbyXpath = "//input[@id='speeding']/ancestor::label";
    String productDataButton = "nextenterproductdata";

    public EnterInsurantData(WebDriver driver) {
        super(driver);
    }

    public EnterInsurantData checkInsurantPage() {
        String checkNextPage = driver.findElement(By.xpath(checkXpath)).getText();
        Assert.assertEquals(checkNextPage, checkValue);

        return this;
    }

    public EnterInsurantData fillFirstName(String firstName){
        driver.findElement(By.id(firstNameId)).sendKeys(firstName);
        return this;
    }

    public EnterInsurantData fillLastName(String lastName){
        driver.findElement(By.id(lastNameId)).sendKeys(lastName);
        return this;
    }

    public EnterInsurantData fillBirth(String birthDate){
        driver.findElement(By.id(birthId)).sendKeys(birthDate);
        return this;
    }

    public EnterInsurantData selectContryId(String countryValue){
        WebElement selectCountry = driver.findElement((By.id(countryId)));
        new Select(selectCountry).selectByValue(countryValue);

        return this;
    }

    public EnterInsurantData selectZipCode(String zipCodeValue){
        driver.findElement(By.id(zipCodeId)).sendKeys(zipCodeValue);

        return this;
    }

    public EnterInsurantData selectOccupation(String occupationValue){
        WebElement selectOccup = driver.findElement((By.id(occupationID)));
        new Select(selectOccup).selectByValue(occupationValue);

        return this;
    }

    public EnterInsurantData selectHobbies(){
        driver.findElement(By.xpath(hobbyXpath)).click();
        return this;
    }

    public EnterProductData clickNextPD(){
        driver.findElement(By.id(productDataButton)).click();

        return new EnterProductData(driver);
    }

    public EnterProductData fillEnterInsurantDataAndGoToEnterProductData(String firstName, String lastName, String birthDate,
                                                                         String countryValue, String zipCodeValue, String occupationValue){
        checkInsurantPage();
        fillFirstName(firstName);
        fillLastName(lastName);
        fillBirth(birthDate);
        selectContryId(countryValue);
        selectZipCode(zipCodeValue);
        selectOccupation(occupationValue);
        selectHobbies();
        clickNextPD();

        return new EnterProductData(driver);
    }


}
