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

public class ResetOrderSteps {
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
	
	@And("User clicks reset button")
	public void user_clicks_reset_button() {
		driver.findElement(By.id("reset-button")).click();
	}
	
	@Then("User is unable to see item on order list")
	public void User_is_unable_to_see_item_on_order_list() {
		WebElement orderListTable = driver.findElement(By.xpath("//table[@class='table']"));
	    Assert.assertTrue("Tabel daftar produk masih memiliki isi", orderListTable.getText().isEmpty());
	}
}
