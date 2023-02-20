package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayHome_Steps {

    WebDriver driver;

    public EbayHome_Steps(Common_Steps common_steps){
        this.driver = common_steps.getDriver();
    }

    @Given("I am on the Ebay Home Page")
    public void i_am_on_the_ebay_home_page() {
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    @When("I click on Advance Link")
    public void i_click_on_advance_link() {
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advance Search Page")
    public void i_navigate_to_advance_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = driver.getCurrentUrl();

        if(!expectedUrl.equals(actualUrl)){
            fail("Page does not navigate to home page");
        }
    }
}
