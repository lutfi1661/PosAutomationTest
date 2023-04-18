package Logout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
	
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
	@And("^user login with ([^\\\"]*)and ([^\\\"]*) successfully$")
	public void user_login_with_email_and_password_successfully(String email, String password) throws InterruptedException 
	{
		driver.navigate().to("https://app.bleven.web.id/login");
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);	
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(3500);
	}
	
	@When("clicks on logout button")
	public void clicks_on_logout_button() 
	{
		driver.findElement(By.id("logoutbutton")).click();
	}

	@Then("user is navigated to the login page")
	public void user_is_navigated_to_the_login_page() throws InterruptedException
	{
		Thread.sleep(3500);
	}
	
	@Then("user try to go to dashboard witout login")
	public void user_try_to_go_to_dashboard_witout_login() throws InterruptedException
	{
		driver.navigate().to("https://app.bleven.web.id/home");
		Thread.sleep(3500);
		driver.close();
		driver.quit();
	}
		
}

