package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayAdvancedSearch_Steps {

    WebDriver driver;

    public EbayAdvancedSearch_Steps(Common_Steps common_steps){
        this.driver = common_steps.getDriver();
    }

    @Given("I am Ebay Advance Search Page")
    public void i_am_ebay_advance_search_page() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
        driver.manage().window().maximize();
    }

    @When("I click on Ebay Logo")
    public void i_click_on_ebay_logo() {
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/nav/ul/li[1]/a")).click();
    }

    @Then("I am navigated to Ebay Home Page")
    public void i_am_navigated_to_ebay_home_page() {
        String expectedUrl = "https://www.ebay.com/";
        String actualUrl = driver.getCurrentUrl();

        if(!expectedUrl.equals(actualUrl)){
            fail("Page does not navigate to home page");
        }
    }
}
