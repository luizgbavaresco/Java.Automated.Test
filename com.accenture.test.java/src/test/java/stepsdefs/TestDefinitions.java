package stepsdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import support.OpenSite;

import java.util.concurrent.TimeUnit;


public class TestDefinitions {

    //Values EnterVehicleData
    String URL = "http://sampleapp.tricentis.com/101/app.php";
    String maker = "Audi";
    String engine = "1234";
    String manufactureDate = "01/01/2021";
    String seatsValue = "4";
    String fuelValue = "Petrol";
    String listPriceValue = "50000";
    String annualMileageValue = "5000";

    //Values EnterInsurantData
    String firstName = "luiz";
    String lastName = "bavaresco";
    String birthDate = "12/12/1995";
    String countryValue = "Brazil";
    String zipCodeValue = "12223001";
    String occupationValue = "Employee";

    //Values EnterProductData
    String startDate = "03/01/2021";
    String insuranceValue = "3000000";
    String meritValue = "Bonus 9";
    String damageValue = "Full Coverage";
    String courtesyCarValue = "Yes";

    //Values SendQuote
    String emailValue = "test@test.com";
    String phoneValue = "99578451";
    String usernameValue = "test";
    String passwordValue = "Test1234";
    String confirmPassValue = "Test1234";


    //Driver
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = OpenSite.openChrome();
    }

    @Test
    @Given("I navigate to the Vehicle Insurance Application page")
    public void i_navigate_to_the_vehicle_insurance_application_page() {
        OpenSite site = new OpenSite(driver);
        site.openURL(URL);
    }

    @Test
    @When("I fill all fields whithin all pages")
    public void i_fill_all_fields_whithin_all_pages() {
        //driver.get("http://sampleapp.tricentis.com/101/app.php");


        EnterVehicleData vehicle = new EnterVehicleData(driver);
        vehicle.fillEnterVehicleDataAndGoToInsurantData(maker, engine, manufactureDate, seatsValue, fuelValue, listPriceValue, annualMileageValue);

        EnterInsurantData insurant = new EnterInsurantData(driver);
        insurant.fillEnterInsurantDataAndGoToEnterProductData(firstName, lastName, birthDate, countryValue, zipCodeValue, occupationValue);

        EnterProductData product = new EnterProductData(driver);
        product.fillEnterProductDataAndGoToSelectPriceOption(startDate, insuranceValue, meritValue, damageValue, courtesyCarValue);

        SelectPriceOption price = new SelectPriceOption(driver);
        price.fillPriceOptionAndGoToSendQuote();

        /*SendQuote quote = new SendQuote(driver);
        quote.insertEmailAndSendQuote(emailValue, phoneValue, usernameValue, passwordValue, confirmPassValue);
        quote.validateMessage();*/

    }

    @When("I fill all forms and send quote")
    public void i_fill_all_forms_and_send_quote() {
        SendQuote quote = new SendQuote(driver);
        quote.insertEmailAndSendQuote(emailValue, phoneValue, usernameValue, passwordValue, confirmPassValue);

    }

    @Then("I will be able to see a Success message in the screen")
    public void i_will_be_able_to_see_a_success_message_in_the_screen() {
        SendQuote quote = new SendQuote(driver);
        quote.validateMessage();
    }

    @After
    public void tearDown() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();
    }
}


