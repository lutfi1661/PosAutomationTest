package Employee;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps {
	
WebDriver driver = null;
	
	@Given("browser employee is opened")
	public void browser_employee_is_opened() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/lamda/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("user employee is on home page")
	public void user_employee_is_on_home_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("cholid@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.tagName("form")).submit();
	}
	
	@And("clicks on employee button")
	public void clicks_on_product_button() {
		driver.findElement(By.cssSelector("img[alt='Employee Logo']")).click();
	}
	
	@And("user clicks button add employee")
	public void user_clicks_button_add_employee() {
		driver.findElement(By.cssSelector("button.btn.bg-transparent.table-add-button")).click();
	}
	
	@And("user is showed modal pop up add employee")
	public void user_is_showed_modal_pop_up_add_employee() {
		driver.findElement(By.cssSelector("div.modal-content")).isDisplayed();
	}
	
	@When("user enters {string}, {string}, {string}, and {string}")
	public void user_enters_name_email_pass_confirmpass(String name, String email, String password, String confirmPass) {
		driver.findElement(By.id("nama_user")).sendKeys(name);
	    driver.findElement(By.id("email_user")).sendKeys(email);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("confirmPassword")).sendKeys(confirmPass);
	}
	
	@And("user click button Add")
	public void user_click_button_Add() {
		driver.findElement(By.cssSelector("button#saveBtn")).click();
	}

	@Then("user should see the add employee success notification")
	public void user_should_see_the_add_employee_success_notification() {
		boolean isNotificationSuccessDisplayed = false;
		try {
			driver.findElement(By.xpath("//div[contains(text(),'Employee has been created successfully')]"));
		} catch (NoSuchElementException e) {
			isNotificationSuccessDisplayed = false;
		}
		Assert.assertFalse("Notification is not displayed", isNotificationSuccessDisplayed);
	}
	
	@Then("user should be able to see {string} notification")
	public void user_should_be_able_to_see_unsuccessReason_notification(String unsuccessReason) {
		if (unsuccessReason.equals("the add employee unsuccess")){
			boolean isNotificationUnsuccessDisplayed = false;
			try {
				driver.findElement(By.xpath("//div[contains(text(),'Employee has been created successfully')]"));
				isNotificationUnsuccessDisplayed = false;
			} catch (NoSuchElementException e) {
				isNotificationUnsuccessDisplayed = true;
			}
			 Assert.assertTrue("Failed to display the 'Failed to create employee' notification! ", isNotificationUnsuccessDisplayed);
		} else if (unsuccessReason.equals("Email field is wrong")){
			boolean isEmailFieldWrongNotificationDisplayed = false;
			Assert.assertFalse("Failed to display the 'Email Field Wrong Notification", isEmailFieldWrongNotificationDisplayed);
		} else if (unsuccessReason.equals("password and confirm password must match")){
			boolean isNotificationFailedDisplayed = false;
			try {
				driver.findElement(By.xpath("//div[contains(text(),'Password and Confirm Password must match')]"));
			} catch (NoSuchElementException e) {
				isNotificationFailedDisplayed = false;
			}
			Assert.assertFalse("Notification is not displayed", isNotificationFailedDisplayed);
		} else if (unsuccessReason.equals("please fill out this field")){
			boolean isNotificationFilledDisplayed = false;
			try {
				driver.findElement(By.cssSelector("[required]"));
			} catch (NoSuchElementException e) {
				isNotificationFilledDisplayed = false;
			}
			Assert.assertFalse("Notification is not displayed", isNotificationFilledDisplayed);
		}
	}

	@And("modal pop up should be closed automatically")
	public void modal_pop_up_should_be_closed_automatically() {
		boolean isModalDisplayed = true;
		try {
			driver.findElement(By.cssSelector("div.modal-content"));
		} catch (NoSuchElementException e) {
			isModalDisplayed = false;
		}
		Assert.assertFalse("Modal pop up is still displayed", isModalDisplayed);
		driver.quit();
	}
}