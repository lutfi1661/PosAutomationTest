package Product;

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

public class NavNextSteps {
	WebDriver driver = null;
	
	@Given("user open browser")
	public void user_open_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/fiora/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("user is on table product page {string}")
	public void user_is_on_table_product_page_page(String page) {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	    driver.findElement(By.xpath("//a[text()='"+ page +"']")).click();
	}
	
	@When("clicks next button on table product")
	public void clicks_next_button_on_table_product() {
		driver.findElement(By.id("table_next")).click();
	}

	@Then("user is navigated to table product page {string}")
	public void user_is_navigated_to_table_product_page_nextPage(String nextPage) {
		String page = driver.findElement(By.xpath("//a[text()='"+ nextPage +"']")).getText();
		assertEquals(nextPage, page);
	}
	
	@Then("user still on table product page 3")
	public void user_still_in_table_product_page_3() {
		String page = driver.findElement(By.xpath("//a[text()='3']")).getText();
		assertEquals("3", page);
	}
}
