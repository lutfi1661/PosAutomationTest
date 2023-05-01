package Product;

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

public class addProductSteps {
WebDriver driver = null;
	
	@Given("User has opened the application")
	public void User_has_opened_the_application() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/sylvia/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("User has navigated on Product page")
	public void User_has_navigated_on_Product_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	}
	
	@When("User clicks add product button")
	public void User_clicks_add_product_button() {
		driver.findElement(By.xpath("//button[contains(text(), 'Add Product')]")).click();
	}
	
	@And("User show modal pop up add product")
	public void User_show_modal_pop_up_add_product() {
		driver.findElement(By.cssSelector("div.modal-content")).isDisplayed();
	}
	
	@And("User enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void User_enters_image_product_code_product_name_category_expire_date_stocks_capital_price_and_price(String image, String productCode, String productName, String category, String expireDate, String stocks, String capitalPrice, String price) {
		driver.findElement(By.id("productImage")).sendKeys(image);
		driver.findElement(By.id("productCode")).sendKeys(productCode);
	    driver.findElement(By.id("productName")).sendKeys(productName);
	    driver.findElement(By.id("category"));
	    driver.findElement(By.xpath("//option[contains(text(), '"+ category +"')]")).click();
	    driver.findElement(By.id("productExpireDate")).sendKeys(expireDate);
	    driver.findElement(By.id("productStocksAmount")).sendKeys(stocks);
	    driver.findElement(By.id("productCapitalPrice")).sendKeys(capitalPrice);
	    driver.findElement(By.id("productPrice")).sendKeys(price);
	    driver.findElement(By.id("saveBtn")).click();
	}
	
	@Then("User should be able to see add product success notification")
	public void User_should_be_able_to_see_add_product_success_notification() {
		boolean isNotificationDisplayed = false;
		try {
			driver.findElement(By.xpath("//div[contains(@class,'Toastify__toast--success')]//*[contains(text(),'Product created!')]"));
			isNotificationDisplayed = true;
		} catch (NoSuchElementException e) {
			isNotificationDisplayed = false;
		}
		Assert.assertTrue("Notification success is not displayed", isNotificationDisplayed);
	}

	@Then("User should be able to see add product fail notification")
	public void User_should_be_able_to_see_add_product_fail_notification() {
	    List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'Toastify__toast--error')]//*[contains(text(),'Failed to add product')]"));
	    if (elements.size() == 0) {
	        Assert.fail("Notification error is not displayed");
	    }
	}
	
	@And("Modal pop up closed automatically and user can see added product")
	public void Modal_pop_up_closed_automatically_and_user_can_see_added_product() {
		boolean isModalClosed = driver.findElements(By.cssSelector(".modal-header")).size() == 0;
	    if (!isModalClosed) {
	        Assert.fail("Modal is not closed");
	    }

	    // Reload page and check if product is added to the table
	    driver.navigate().refresh();
	    WebElement productTable = driver.findElement(By.cssSelector(".product-table"));
	    boolean isProductAdded = productTable.findElements(By.xpath("//td[contains(text(),'Cadbury')]")).size() > 0;
	    Assert.assertTrue("Product is not added to the table", isProductAdded);
	}

	@And("User_still_can_view_modal_pop_up")
	public void User_still_can_view_modal_pop_up() {
	    boolean isModalOpen = driver.findElements(By.cssSelector(".modal-header")).size() > 0;
	    if (!isModalOpen) {
	        Assert.fail("Modal is closed");
	    }
	}
}
