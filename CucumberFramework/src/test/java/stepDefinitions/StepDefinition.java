package stepDefinitions;

import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumberBase.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
public class StepDefinition extends BaseTest {
	
      //WebDriver driver = new ChromeDriver();
    @Given("User is on Allegiant Landing page")
    public void user_is_on_allegiant_landing_page() throws Throwable {
        //driver.get("https://www.allegiantair.com/");
    	System.out.println("Landed on home page");
    }

    @When("^User search flights with_locations, date and ticket count$")
    public void user_search_flights_withlocations_date_and_ticket_count() throws Throwable {
        
    }

    @Then("^Select fllight page should be displayed$")
    public void select_fllight_page_should_be_displayed() throws Throwable {
       
    }

    @And("^flights are displayed$")
    public void flights_are_displayed() throws Throwable {
        
    }

}