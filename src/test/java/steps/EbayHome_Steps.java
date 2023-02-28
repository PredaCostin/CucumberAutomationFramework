package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.fail;

public class EbayHome_Steps {

    WebDriver driver;

    public EbayHome_Steps(Common_Steps common_steps) {
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

        if (!expectedUrl.equals(actualUrl)) {
            fail("Page does not navigate to home page");
        }
    }

    @When("I search for {string}")
    public void i_search_for(String product) {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(product);
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
    }

    @Then("I validate at least {int} search items present")
    public void i_validate_at_least_search_items_present(int count) {
        String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText().trim();
        String itemCount2 = itemCount.replace(",", "");
        int intItemCount = Integer.parseInt(itemCount2);

        if(!(intItemCount > count)){
            fail("Less than 1000 results shown");
        }
    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String string, String string2) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(string);

        List<WebElement> cat = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for(WebElement option : cat ){
            if(option.getText().trim().equals(string2)){
                option.click();
                break;
            }
        }

        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
        Thread.sleep(1000);
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(2000);
    }

    @Then("I validate that page navigate to {string} and title contains {string}")
    public void i_validate_that_page_navigate_to_and_title_contains(String url, String title) {
        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        if(!actualUrl.equals(url)){
            fail("Page does navigate to expected url: " + url);
        }

        if(!actualTitle.contains(title)){
            fail("Title mismatch");
        }
    }
}
