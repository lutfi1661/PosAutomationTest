package Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Author : Rusyda Jasmine Rachmat
//Date : 28/04/2023
//Description : Testing in Expire Soon in Product

public class expSoonSteps {
WebDriver driver = null;
	
	@Given("user has opened the browser")
	public void user_has_opened_the_browser() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/mirva/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	@And("user on the dashboard page")
	public void user_on_the_dashboard_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	}
	
	@And("user on the product page")
	public void user_on_the_product_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	}
	
	@And("user clicks add product button")
	public void user_clicks_add_product_button() {
		driver.findElement(By.xpath("//button[contains(text(), 'Add Product')]")).click();
	}
	
	@And("user has showed modal pop up add product")
	public void user_has_showed_modal_pop_up_add_product() {
	    driver.findElement(By.cssSelector("div.modal-content")).isDisplayed();
	}
	
	@When("user clicks product button")
	public void user_clicks_product_button() {
	    driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	}
	
	@When("user enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_enters_image_product_code_product_name_category_expire_date_stocks_capital_price_and_price(String image, String productCode, String productName, String category, String expireDate, String stocks, String capitalPrice, String price) {
		driver.findElement(By.id("productImage")).sendKeys(image);
		driver.findElement(By.id("productCode")).sendKeys(productCode);
	    driver.findElement(By.id("productName")).sendKeys(productName);
	    driver.findElement(By.id("category"));
	    driver.findElement(By.xpath("//option[contains(text(), '"+ category +"')]")).click();
	    driver.findElement(By.id("productExpireDate")).sendKeys(expireDate);
	    driver.findElement(By.id("productStocksAmount")).sendKeys(stocks);
	    driver.findElement(By.id("productCapitalPrice")).sendKeys(capitalPrice);
	    driver.findElement(By.id("productPrice")).sendKeys(price);
	}
	
	@And("user clicks on add products button")
	public void user_clicks_on_add_products_button() {
		driver.findElement(By.id("saveBtn")).click();
	}

	@Then("user is navigated to the product page")
	public void user_is_navigated_to_the_product_page() {
		String page = driver.findElement(By.xpath("//p[text()='Product']")).getText();
		assertEquals("Product", page);
	}
	
	@Then("user should be {string} to see product {string} in data expire soon")
	public void user_should_be_able_or_not_to_see_product_productName_in_data_expire_soon(String ability, String productName) {
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		List<WebElement> product = driver.findElements(By.xpath("//div[contains(@class, 'card-susu') and contains(@class, 'mb-2')]//div[contains(@class, 'card-text') and contains(@class, 'mt-1') and contains(@class, 'p-0') and contains(@class, 'ml-1') and contains(text(), '"+ productName +"')]"));
		if (ability.equals("able") && product.isEmpty()) {
			System.out.println("New product in expire section is not displayed");
			assertFalse(product.isEmpty());
		} else if (ability.equals("able")&& !product.isEmpty()) {
			System.out.println("New product in expire section is displayed");
			assertTrue(!product.isEmpty());
		} else if (ability.equals("not able") && product.isEmpty()) {
			System.out.println("New product in expire section is not displayed");
			assertTrue(product.isEmpty());
		} else if (ability.equals("not able") && !product.isEmpty()) {
			System.out.println("New product in expire section is displayed");
			assertFalse(product.isEmpty());
		}
	}
	
	@And("user should be able to see product data expire soon")
	public void user_should_be_able_to_see_product_data_expire_soon() {
		String page = driver.findElement(By.xpath("//h3[text()='Expire Soon']")).getText();
		assertEquals("Expire Soon", page);
	}
}
