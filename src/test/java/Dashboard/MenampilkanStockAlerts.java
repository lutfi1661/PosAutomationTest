package Dashboard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenampilkanStockAlerts {
	
	WebDriver driver = null;
	
//	Given browser dashboard is opened
	@Given("browser dashboard is opened")
	public void browser_dashboard_is_opened() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/aqil/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}
	
//	And user dashboard clicks on product button
	@And("user dashboard clicks on product button")
	public void user_dashboard_clicks_on_product_button() {
		driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	}
	
//	And user dashboard has navigated on the product page
	@And("user dashboard has navigated on the product page")
	public void user_dashboard_has_navigated_on_the_product_page() {
		driver.navigate().to("https://app.bleven.web.id/product");	
	}
	
//	And user dashboard has click button add product
	@And("user dashboard has click button add product")
	public void user_dashboard_has_click_button_add_product() {
		driver.findElement(By.cssSelector("iconify-icon[icon='oi:plus']")).click();
	}
	
//	When user is on dashboard page
	@When("user is on dashboard page")
	public void user_is_on_dashboard_page() {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	}
	
//	When user dashboard enters "<image>", "<productCode>", "<productName>", "<category>", "<expireDate>", "<stocks>", "<capitalPrice>", and "<price>"
	@When("user dashboard enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_dashboard_enters_image_productCode_productName_category_expireDate_stocks_capitalPrice_and_price(String image, String productCode, String productName, String category, String expireDate, String stocks, String capitalPrice, String price) {  
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
	
//	When user cashier is on transaction page
	@When("user cashier is on transaction page")
	public void user_cashier_is_on_transaction_page() {
	    driver.navigate().to("https://app.bleven. web.id/login");
	    driver.findElement(By.id("email")).sendKeys("putri@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("putri");
	    driver.findElement(By.tagName("form")).submit();
	}
	
//	And user dashboard clicks on add products button
	@And("user dashboard clicks on add products button")
	public void user_dashboard_clicks_on_add_products_button() {
//		driver.navigate().to("https://app.bleven.web.id/product");	
		driver.findElement(By.id("saveBtn")).click();
	}
	
//	And user dashboard go back to dashboard page
	@And("user dashboard go back to dashboard page")
	public void user_dashboard_go_back_to_dashboard_page() {
		driver.navigate().to("https://app.bleven.web.id/product");	
	}
	
//	Then user should be able to see data stock alert in product page
	@Then("user should be able to see data stock alert in product page")
	public void user_should_be_able_to_see_data_stock_alert_in_product_page() {

		boolean isStockAlertDisplayed = false;
		try {
			driver.findElement(By.xpath("//h3[text()='Stock Alerts']"));
		} catch (NoSuchElementException e) {
			isStockAlertDisplayed = false;
		}
		
		if (isStockAlertDisplayed) {
			Assert.assertTrue("Stock Alert is displayed", isStockAlertDisplayed);
		} else {
			Assert.assertFalse("Stock Alert is not displayed", isStockAlertDisplayed);
		}
	}

//	Then user should conclusion able to see new product in data stock alert, same with productName
	@Then("user should {string} able to see new product in data stock alert, same with {string}")
	public void user_should_conclusion_able_to_see_new_product_in_data_stock_alert_same_with_productName(String conclusion, String productName) {
		List<WebElement> product = driver.findElements(By.xpath("//div[@class='card-body p-0 ml-1' and descendant::div[@class='progress'] and descendant::div[@class='stock'] and descendant::div[@class='details mt-3'] and descendant::span[@class='stock-amount']]"));
		if (conclusion.equals("be") && product.isEmpty()) {
			System.out.println("New product with stock <= 100 in stock alert is not displayed");
			assertFalse(product.isEmpty());
		} else if (conclusion.equals("be") && !product.isEmpty())  {
			System.out.println("New product with stock <= 100 in stock alert is displayed");
			assertTrue(product.isEmpty());
		} else if (conclusion.equals("not be") && product.isEmpty()) {
			System.out.println("New product with stock > 100 in stock alert is not displayed");
			assertTrue(product.isEmpty());
		} else if (conclusion.equals("not be") && !product.isEmpty()) {
			System.out.println("New product with stock > 100 in stock alert is displayed");
			assertFalse(product.isEmpty());
		}
	}
	
//	Then user cashier should not be able to see the component data stock alert
	@Then("user cashier should not be able to see the component data stock alert")
	public void user_cashier_should_not_be_able_to_see_the_component_data_stock_alert() {
		List<WebElement> stockAlerts = driver.findElements(By.xpath("//div[contains(text(),'Stock Alerts')]"));
		if (stockAlerts.isEmpty()) {
			System.out.println("Stock Alert is not displayed in Cashier!");
		} else {
			System.out.println("Stock Alert is displayed in Cashier!");
		}
		Assert.assertTrue(stockAlerts.isEmpty());
	}
	
	

}
