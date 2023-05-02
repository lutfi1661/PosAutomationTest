package Employee;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Author : Lamda Richo Vanjaya Sumaryadi
//Date	: 23/04/2023
//Description : Testing in Add Employee POS

public class AddEmployeeSteps {
	
WebDriver driver = null;
	
	@Given("browser employee is opened")
	public void browser_employee_is_opened() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/lamda/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
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
		List<WebElement> notification = driver.findElements(By.xpath("//div[contains(text(),'Employee has been created successfully')]"));
		if (!notification.isEmpty()) {
			System.out.println("Notification is success created employee is displayed!");
		} else {
			System.out.println("Notification is success created employee is not displayed!");
		}
		Assert.assertTrue(!notification.isEmpty());
	}
	
	@Then("user should be able to see {string} notification")
	public void user_should_be_able_to_see_unsuccessReason_notification(String unsuccessReason) {
		if (unsuccessReason.equals("the add employee unsuccess")){
			List<WebElement> notificationFailed = driver.findElements(By.xpath("//div[contains(text(),'Failed to create employee')]"));
			if (!notificationFailed.isEmpty()) {
				System.out.println("Notification is failed to create employee is displayed!");
			} else {
				System.out.println("Notification is failed to create employee is not displayed!");
			}
			Assert.assertTrue(!notificationFailed.isEmpty());
		} else if (unsuccessReason.equals("Email field is wrong")){
			List<WebElement> notificationEmailWrong = driver.findElements(By.xpath("//div[contains(text(),'Email Field is Wrong!')]"));
			if (!notificationEmailWrong.isEmpty()) {
				System.out.println("Notification 'Email Field is Wrong!' is displayed!");
			} else {
				System.out.println("Notification 'Email Field is Wrong!' employee is not displayed!");
			}
			Assert.assertTrue(!notificationEmailWrong.isEmpty());
		} else if (unsuccessReason.equals("password and confirm password must match")){
			List<WebElement> notificationPassword = driver.findElements(By.xpath("//div[contains(text(),'Password and Confirm Password must match')]"));
			if (!notificationPassword.isEmpty()) {
				System.out.println("Notification 'Password and Confirm Password must match' is displayed!");
			} else {
				System.out.println("Notification 'Password and Confirm Password must match' employee is not displayed!");
			}
			Assert.assertTrue(!notificationPassword.isEmpty());
		} else if (unsuccessReason.equals("please fill out this field")){
			List<WebElement> NotificationUnfilled = driver.findElements(By.xpath("//div[contains(text(),'Please fill out all field!')]"));
			if (!NotificationUnfilled.isEmpty()) {
				System.out.println("Notification unfilled is displayed!");
			} else {
				System.out.println("Notification unfilled is not displayed!");
			}
			Assert.assertTrue(!NotificationUnfilled.isEmpty());
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