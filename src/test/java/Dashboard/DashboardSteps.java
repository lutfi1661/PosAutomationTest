package Dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open()
	{
		System.setProperty("webdriver.chrome.driver","D:\\COLLEGE\\VI\\PPL\\W11\\CucumberJava\\src\\test\\resources\\drivers\\chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	  		
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	@And("user login to bleven pos successfully for dashboard")
	public void user_enters_email_and_password_for_dashboard() throws InterruptedException 
	{
		driver.navigate().to("https://app.bleven.web.id/login");
		driver.findElement(By.id("email")).sendKeys("cholid@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");	
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(200);
	}
	
	@When("clicks on employee card")
	public void clicks_on_employee_card() 
	{
		driver.findElement(By.id("employeecard")).click();
	}


	@Then("user is navigated to the employee page")
	public void user_is_navigated_to_the_employee_page() throws InterruptedException
	{
		Thread.sleep(3500);
		driver.close();
		driver.quit();
	}
		
}

