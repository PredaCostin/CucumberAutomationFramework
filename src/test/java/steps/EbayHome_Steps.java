package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayHome_Steps {

    WebDriver driver = new ChromeDriver();

    @Given("I am on the Ebay Home Page")
    public void i_am_on_the_ebay_home_page() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    @When("I click on Advance Link")
    public void i_click_on_advance_link() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver");
        driver.findElement(By.linkText("Advanced")).click();
    }

    @Then("I navigate to Advance Search Page")
    public void i_navigate_to_advance_search_page() {
        String expectedUrl = "https://www.ebay.com/sch/ebayadvsearch";
        String actualUrl = driver.getCurrentUrl();

        if(!expectedUrl.equals(actualUrl)){
            System.out.println("Page does not navigate to expected page");
        }

        driver.quit();
    }
}
