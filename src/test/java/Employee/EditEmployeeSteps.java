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
//Description : Testing in Edit Employee POS

public class EditEmployeeSteps {
	
WebDriver driver = null;
	
	@Given("browser edit employee is opened")
	public void browser_edit_employee_is_opened() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/lamda/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
//	And user edit employee is on home page
	@And("user edit employee is on home page")
	public void user_edit_employee_is_on_home_page() {
	    driver.navigate().to("https://app.bleven.web.id/home");
	    driver.findElement(By.id("email")).sendKeys("cholid@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.tagName("form")).submit();
	}
	
//	And clicks on edit employee button
	@And("clicks on edit employee button")
	public void clicks_on_edit_product_button() {
		driver.findElement(By.cssSelector("img[alt='Employee Logo']")).click();
	}
	
//	And user clicks button edit employee
	@And("user clicks button edit employee")
	public void user_clicks_button_edit_employee() {
		driver.findElement(By.cssSelector("iconify-icon[icon='oi:pencil']")).click();
	}
	
//	And user is showed modal pop up edit employee
	@And("user is showed modal pop up edit employee")
	public void user_is_showed_modal_pop_up_edit_employee() {
		driver.findElement(By.cssSelector("div.modal-footer")).isDisplayed();
	}
	
//	When user enters "Lamda Update" and "lamda2@gmail"
	@When("user enters {string} and {string}")
	public void user_enters_name_email(String name, String email) {
		driver.findElement(By.id("nameCashier1")).sendKeys(name);
	    driver.findElement(By.id("exampleInputEmail1")).sendKeys(email);
	}
	
//	And user click button update
	@And("user click button update")
	public void user_click_button_update() {
//		driver.findElement(By.cssSelector("button#saveBtn")).click();
		WebElement saveButton = driver.findElement(By.cssSelector("button#saveBtn"));
		
		if (saveButton.isEnabled() && saveButton.isDisplayed()) {
		    System.out.println("Tombol Save dapat diklik");
		    saveButton.click();
		} else {
		    System.out.println("Tombol Save tidak dapat diklik");
		}
		Assert.assertFalse(!saveButton.isEnabled() && !saveButton.isDisplayed());
	}

//	Then user should see the edit employee success notification
	@Then("user should see the edit employee success notification")
	public void user_should_see_the_edit_employee_success_notification() {
		List<WebElement> notification = driver.findElements(By.xpath("//div[contains(text(),'Employee has been update successfully')]"));
		if (!notification.isEmpty()) {
			System.out.println("Notification is success update employee is displayed!");
		} else {
			System.out.println("Notification is not displayed or Failed to update employee!");
		}
		Assert.assertTrue(!notification.isEmpty());
	}
	
	@Then("user should be able to see {string} edit notification")
	public void user_should_be_able_to_see_unsuccessReason_edit_notification(String unsuccessReason) {
		if (unsuccessReason.equals("name field is wrong")){
			List<WebElement> notification = driver.findElements(By.xpath("//div[contains(text(),'Employee has been update successfully')]"));
			if (!notification.isEmpty()) {
				System.out.println("Notification name field is wrong is displayed!");
			} else {
				System.out.println("Notification name field is wrong is not displayed!");
			}
			Assert.assertTrue(!notification.isEmpty());
		} else if (unsuccessReason.equals("email field is wrong")){   
			List<WebElement> EmailFieldWrongNotification = driver.findElements(By.xpath("//div[contains(text(),'Email Field is Wrong!')]"));
			if (!EmailFieldWrongNotification.isEmpty()) {
				System.out.println("Notification email field wrong is displayed!");
			} else {
				System.out.println("Notification email field wrong is not displayed!");
			}
			Assert.assertTrue(!EmailFieldWrongNotification.isEmpty());
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
	
//	And modal pop up edit should be closed automatically
	@And("modal pop up edit should be closed automatically")
	public void modal_pop_up_edit_should_be_closed_automatically() {
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