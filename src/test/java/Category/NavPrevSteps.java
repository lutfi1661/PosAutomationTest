package Category;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavPrevSteps {
	
	WebDriver driver = null;
	
	@Given("user is open browser")
	public void user_is_open_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/fiora/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("user is on category page")
	public void user_is_on_category_page() {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Category Logo']")).click();
	}

	@When("clicks on table category page {string}")
	public void clicks_on_table_category_page_page(String page) {
		driver.findElement(By.xpath("//a[text()='"+ page +"']")).click();
	}
	
	@And("clicks previous button on table category")
	public void clicks_previous_button_on_table_category() {
		driver.findElement(By.id("table_previous")).click();
	}

	@Then("user is navigated to the table category page {string}")
	public void user_is_navigated_to_the_table_category_page_prevPage(String prevPage) {
		String page = driver.findElement(By.xpath("//a[text()='"+ prevPage +"']")).getText();
		assertEquals(prevPage, page);
	}
	
	@Then("user still in table category page 1")
	public void user_still_in_table_category_page_1() {
		String page = driver.findElement(By.xpath("//a[text()='1']")).getText();
		assertEquals("1", page);
	}
}
