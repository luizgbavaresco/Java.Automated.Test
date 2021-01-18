package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendQuote extends BasePage{

    //Locators
    String checkXpath = "//label[contains(text(),'E-Mail')]";
    String checkValue = "E-Mail";
    String emailID = "email";
    String phoneId = "phone";
    String usernameId = "username";
    String passwordId = "password";
    String confirmPassId = "confirmpassword";
    String sendEmailButton = "sendemail";
    String successMessageXpath = "//h2[contains(text(),'Sending e-mail success!')]";
    String successMessageValue = "Sending e-mail success!";
    String okayButtonXpath = "//button[contains(text(),'OK')]";


    public SendQuote(WebDriver driver) {
        super(driver);
    }

    public SendQuote checkSendQuotePage() {
        String checkNextPage = driver.findElement(By.xpath(checkXpath)).getText();
        Assert.assertEquals(checkNextPage, checkValue);

        return this;
    }

    public SendQuote insertEmail(String emailValue){
        driver.findElement(By.id(emailID)).sendKeys(emailValue);
        return this;
    }

    public SendQuote insertPhone(String phoneValue){
        driver.findElement(By.id(phoneId)).sendKeys(phoneValue);
        return this;
    }

    public SendQuote insertUsername(String usernameValue){
        driver.findElement(By.id(usernameId)).sendKeys(usernameValue);
        return this;
    }

    public SendQuote insertPassword(String passwordValue){
        driver.findElement(By.id(passwordId)).sendKeys(passwordValue);
        return this;
    }

    public SendQuote confirmPassword(String confirmPassValue) {
        driver.findElement(By.id(confirmPassId)).sendKeys(confirmPassValue);
        return this;
    }

    public SendQuote clickSendEmail(){
        driver.findElement(By.id(sendEmailButton)).click();
        return this;
    }

    public SendQuote checkSuccessMessage(){
        WebDriverWait driverWait = new WebDriverWait(driver, 15);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okayButtonXpath)));
        String successMessage = driver.findElement(By.xpath(successMessageXpath)).getText();
        Assert.assertEquals(successMessage, successMessageValue);


        return this;
    }

    public SendQuote insertEmailAndSendQuote(String emailValue, String phoneValue, String usernameValue,
                                             String passwordValue, String confirmPassValue){
        checkSendQuotePage();
        insertEmail(emailValue);
        insertPhone(phoneValue);
        insertUsername(usernameValue);
        insertPassword(passwordValue);
        confirmPassword(confirmPassValue);
        clickSendEmail();

        return this;

    }

    public SendQuote validateMessage(){
        checkSuccessMessage();
        return this;
    }
}
