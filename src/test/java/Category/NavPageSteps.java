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

public class NavPageSteps {
	WebDriver driver = null;
	
	@Given("user is opened browser")
	public void user_is_opened_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/fiora/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("user on table category page {string}")
	public void user_on_table_product_page_page(String page) {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Category Logo']")).click();
	    if (page.equals("1")) {
	    	driver.findElement(By.xpath("//a[text()='2']")).click();
	    }
	}
	
	@When("user clicks on table category page {string} button")
	public void user_clicks_on_table_category_page_page_button(String page) {
		driver.findElement(By.xpath("//a[text()='"+ page +"']")).click();;
	}

	@Then("user navigated to table category page {string}")
	public void user_navigated_to_table_category_page_page(String pageNow) {
		String page = driver.findElement(By.xpath("//a[text()='"+ pageNow +"']")).getText();
		assertEquals(pageNow, page);
	}
}
