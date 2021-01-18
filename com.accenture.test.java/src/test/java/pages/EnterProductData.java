package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EnterProductData extends BasePage {

    //Locators
    String checkXpath = "//label[contains(text(),'Start Date')]";
    String checkValue = "Start Date";
    String startDateId = "startdate";
    String insuranceSumId = "insurancesum";
    String meritId = "meritrating";
    String damageId = "damageinsurance";
    String optionalsXpath = "//input[@id='EuroProtection']/ancestor::label";
    String courtesyCarId = "courtesycar";
    String selectPriceOptionButton = "nextselectpriceoption";


    public EnterProductData(WebDriver driver) {
        super(driver);
    }

    public EnterProductData checkProductPage() {
        String checkPage = driver.findElement(By.xpath(checkXpath)).getText();
        Assert.assertEquals(checkPage, checkValue);
        return this;
    }

    public EnterProductData fillStartDate(String startDate){
        driver.findElement(By.id(startDateId)).sendKeys(startDate);
        return this;
    }

    public EnterProductData selectInsuranteSum(String insuranceValue){
        WebElement selectInsurance = driver.findElement((By.id(insuranceSumId)));
        new Select(selectInsurance).selectByValue(insuranceValue);

        return this;
    }

    public EnterProductData selectMeritId(String meritValue){
        WebElement selectMerit = driver.findElement((By.id(meritId)));
        new Select(selectMerit).selectByValue(meritValue);

        return this;
    }

    public EnterProductData selectDamageId(String damageValue){
        WebElement selectDamage = driver.findElement((By.id(damageId)));
        new Select(selectDamage).selectByValue(damageValue);

        return this;
    }

    public EnterProductData selectOptionals(){
        driver.findElement(By.xpath(optionalsXpath)).click();
        return this;
    }

    public EnterProductData selectCourtesyCarId(String courtesyCarValue){
        WebElement selectCourtesy = driver.findElement((By.id(courtesyCarId)));
        new Select(selectCourtesy).selectByValue(courtesyCarValue);

        return this;
    }

    public SelectPriceOption clickNextSPO(){
        driver.findElement(By.id(selectPriceOptionButton)).click();

        return new SelectPriceOption(driver);
    }

    public SelectPriceOption fillEnterProductDataAndGoToSelectPriceOption(String startDate, String insuranceValue, String meritValue,
                                                                          String damageValue, String courtesyCarValue){
        checkProductPage();
        fillStartDate(startDate);
        selectInsuranteSum(insuranceValue);
        selectMeritId(meritValue);
        selectDamageId(damageValue);
        selectOptionals();
        selectCourtesyCarId(courtesyCarValue);
        clickNextSPO();

        return new SelectPriceOption(driver);
    }

}


