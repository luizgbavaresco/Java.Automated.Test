package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectPriceOption extends BasePage {

    //Locators
    String checkXpath = "//th[contains(text(),'Silver')]";
    String checkValue = "Silver";
    String choosePriceXpath = "//input[@id='selectsilver']/ancestor::label";
    String nextPageButton = "nextsendquote";

    public SelectPriceOption(WebDriver driver) {
        super(driver);
    }

    public SelectPriceOption checkPricePage() {
        String checkPage = driver.findElement(By.xpath(checkXpath)).getText();
        Assert.assertEquals(checkPage, checkValue);
        return this;
    }

    public SelectPriceOption selectPrice() {
        driver.findElement(By.xpath(choosePriceXpath)).click();
        return this;

    }

    public SendQuote clickNextSQ(){
        driver.findElement(By.id(nextPageButton)).click();

        return new SendQuote(driver);
    }

    public SendQuote fillPriceOptionAndGoToSendQuote() {
        checkPricePage();
        selectPrice();
        clickNextSQ();

        return new SendQuote(driver);
    }

}
