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

public class editProductSteps {
WebDriver driver = null;
	
	@Given("User edit product has opened the application")
	public void User_edit_product_has_opened_the_application() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/sylvia/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
	@And("User edit product has navigated on Product page")
	public void User_edit_product_has_navigated_on_Product_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	    driver.findElement(By.cssSelector("img[alt='Product Logo']")).click();
	}
	
	@When("User edit product clicks edit product button")
	public void User_edit_product_clicks_edit_product_button() {
		driver.findElement(By.xpath("//a[text()='3']")).click();;
		driver.findElement(By.xpath("//td[contains(text(), 'Cadbury')]/following-sibling::td/button")).click();
	}
	
	@And("User edit product show modal pop up edit product")
	public void User_edit_product_show_modal_pop_up_edit_product() {
		driver.findElement(By.cssSelector("div.modal-content")).isDisplayed();
	}
	  
	@And("User edit product enters {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void User_edit_product_enters_image_product_code_product_name_category_expire_date_stocks_capital_price_and_price(String image, String productCode, String productName, String category, String expireDate, String stocks, String capitalPrice, String price) {
	    try {
	        WebElement productImage = driver.findElement(By.id("productImage"));
	        if (productImage.isDisplayed() && productImage.isEnabled()) {
	            productImage.sendKeys(image);
	        } else {
	            Assert.fail("Product image is not interactable");
	        }

	        WebElement productCodeElem = driver.findElement(By.id("productCode"));
	        if (productCodeElem.isDisplayed() && productCodeElem.isEnabled()) {
	            productCodeElem.sendKeys(productCode);
	        } else {
	            Assert.fail("Product code is not interactable");
	        }

	        WebElement productNameElem = driver.findElement(By.id("productName"));
	        if (productNameElem.isDisplayed() && productNameElem.isEnabled()) {
	            productNameElem.sendKeys(productName);
	        } else {
	            Assert.fail("Product name is not interactable");
	        }

	        WebElement categoryElem = driver.findElement(By.id("category"));
	        if (categoryElem.isDisplayed() && categoryElem.isEnabled()) {
	            categoryElem.click();
	            driver.findElement(By.xpath("//option[contains(text(), '"+ category +"')]")).click();
	        } else {
	            Assert.fail("Category is not interactable");
	        }

	        WebElement productExpireDateElem = driver.findElement(By.id("productExpireDate"));
	        if (productExpireDateElem.isDisplayed() && productExpireDateElem.isEnabled()) {
	            productExpireDateElem.sendKeys(expireDate);
	        } else {
	            Assert.fail("Product expire date is not interactable");
	        }

	        WebElement productStocksAmountElem = driver.findElement(By.id("productStocksAmount"));
	        if (productStocksAmountElem.isDisplayed() && productStocksAmountElem.isEnabled()) {
	            productStocksAmountElem.sendKeys(stocks);
	        } else {
	            Assert.fail("Product stocks amount is not interactable");
	        }

	        WebElement productCapitalPriceElem = driver.findElement(By.id("productCapitalPrice"));
	        if (productCapitalPriceElem.isDisplayed() && productCapitalPriceElem.isEnabled()) {
	            productCapitalPriceElem.sendKeys(capitalPrice);
	        } else {
	            Assert.fail("Product capital price is not interactable");
	        }

	        WebElement productPriceElem = driver.findElement(By.id("productPrice"));
	        if (productPriceElem.isDisplayed() && productPriceElem.isEnabled()) {
	            productPriceElem.sendKeys(price);
	        } else {
	            Assert.fail("Product price is not interactable");
	        }

	        WebElement saveBtnElem = driver.findElement(By.id("saveBtn"));
	        if (saveBtnElem.isDisplayed() && saveBtnElem.isEnabled()) {
	            saveBtnElem.click();
	        } else {
	            Assert.fail("Save button is not interactable");
	        }
	    } catch (NoSuchElementException e) {
	        Assert.fail("An element is not found");
	    }
	}
	
	@Then("User edit product should be able to see edit product success notification")
	public void User_edit_product_should_be_able_to_see_edit_product_success_notification() {
		boolean isNotificationDisplayed = false;
		try {
			driver.findElement(By.xpath("//div[contains(@class,'Toastify__toast--success')]//*[contains(text(),'Product edited!')]"));
			isNotificationDisplayed = true;
		} catch (NoSuchElementException e) {
			isNotificationDisplayed = false;
		}
		Assert.assertTrue("Notification success is not displayed", isNotificationDisplayed);
	}

	@Then("User edit product should be able to see edit product fail notification")
	public void User_edit_product_should_be_able_to_see_edit_product_fail_notification() {
	    List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'Toastify__toast--error')]//*[contains(text(),'Failed to edit product')]"));
	    if (elements.size() == 0) {
	        Assert.fail("Notification error is not displayed");
	    }
	}
	
	@And("Modal pop up closed automatically and user edit product can see edited product")
	public void Modal_pop_up_closed_automatically_and_user_edit_product_can_see_edited_product() {
		boolean isModalClosed = driver.findElements(By.cssSelector(".modal-header")).size() == 0;
	    if (!isModalClosed) {
	        Assert.fail("Modal is not closed");
	    }

	    // Reload page and check if product is added to the table
	    driver.navigate().refresh();
	    WebElement productTable = driver.findElement(By.cssSelector(".product-table"));
	    boolean isProductEdited = productTable.findElements(By.xpath("//td[contains(text(),'Cadbury Diary Milk')]")).size() > 0;
	    Assert.assertTrue("Product is not edited", isProductEdited);
	}

	@And("User_edit_product_still_can_view_modal_pop_up")
	public void User_edit_product_still_can_view_modal_pop_up() {
	    boolean isModalOpen = driver.findElements(By.cssSelector(".modal-header")).size() > 0;
	    if (!isModalOpen) {
	        Assert.fail("Modal is closed");
	    }
	}
}
