package Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
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
	
	@And("user is on login page")
	public void user_is_on_login_page() 
	{    
		driver.navigate().to("https://app.bleven.web.id/login");
	}
	
	@When("^user enters ([^\"]*) and ([^\"]*)$")
	public void user_enters_email_and_password(String email, String password) 
	{
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);	
			
	}

	@And("clicks on login button")
	public void clicks_on_login_button() 
	{
		driver.findElement(By.id("loginbutton")).click();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException
	{
		Thread.sleep(3500);
		driver.close();
		driver.quit();
	}
		
}

