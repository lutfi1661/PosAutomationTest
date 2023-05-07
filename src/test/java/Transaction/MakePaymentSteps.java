package Transaction;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MakePaymentSteps {
	WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
	    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	    driver = new ChromeDriver();
	}

	@And("User is already on transaction page as employee")
	public void user_is_already_on_transaction_page_as_employee() {
		Driver.getInstance().navigate().to("https://app.bleven.web.id/login");
	    Driver.getInstance().findElement(By.xpath("//input[@id='email']")).sendKeys("putri@gmail.com");
	    Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("putri");
	    Driver.getInstance().findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
	}

	@And("User enters {string} on search bar")
	public void user_enters_on_search_bar(String productCode) {
		driver.findElement(By.id("product-code-search-bar")).sendKeys(productCode);
	}

	@And("User clicks add button")
	public void user_clicks_add_button() {
		driver.findElement(By.id("add-product")).click();
	}

	@Then("User should be able to see Success message")
	public void user_should_be_able_to_see_Success_message() {
		boolean isNotificationDisplayed = false;
		
		try {
			driver.findElement(By.xpath("//div[contains(@class,'Toastify__toast--success')]//*[contains(text(),'Product added to order list')]"));
			isNotificationDisplayed = true;
		} catch (NoSuchElementException e) {
			isNotificationDisplayed = false;
		}
		Assert.assertTrue("Notification success is not displayed", isNotificationDisplayed);
	}
	
	@When("user clicks the \"Proceed\" button on the transaction page")
	public void user_clicks_the_Proceed_button_on_the_transaction_page() {
		driver.findElement(By.id("proceed-button")).click();
	}

	@Then("user should be able to see the date, total amount, and order list of the products")
	public void user_should_be_able_to_see_the_date_total_amount_and_order_list_of_the_products() {
		boolean isModalDisplayed = false;
		
		try {
			driver.findElement(By.xpath("//div[@class='invoice-modal']"));
			isModalDisplayed = true;
		} catch (NoSuchElementException e) {
			isModalDisplayed = false;
		}
		
		Assert.assertTrue("Invoice modal is not displayed", isModalDisplayed);
		Assert.assertTrue("Invoice modal does not display the date", driver.findElement(By.id("invoice-date")).isDisplayed());
		Assert.assertTrue("Invoice modal does not display the total amount", driver.findElement(By.id("invoice-total")).isDisplayed());
		Assert.assertTrue("Invoice modal does not display the order list", driver.findElement(By.id("invoice-list")).isDisplayed());
	}

	@Then("user clicks the \"Pay\" button on the invoice modal")
	public void user_clicks_the_Pay_button_on_the_invoice_modal() {
		driver.findElement(By.id("pay-button")).click();
	}

	@Then("user should receive a notification that the transaction and payment have been successful")
	public void user_should_receive_a_notification_that_the_transaction_and_payment_have_been_successful() {
		boolean isNotificationDisplayed = false;
		
		try {
			driver.findElement(By.xpath("//div[contains(@class,'Toastify__toast--success')]//*[contains(text(),'Transaction and payment have been successful')]"));
			isNotificationDisplayed = true;
		} catch (NoSuchElementException e) {
			isNotificationDisplayed = false;
		}
		
		Assert.assertTrue("Notification success is not displayed", isNotificationDisplayed);
	}
}
