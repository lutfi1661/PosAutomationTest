package Dashboard;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenampilkanStatisticOfBestSelling {
	WebDriver driver = null;

	@Given("browser dashboards is opened")
	public void browser_dashboards_is_opened() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/aqil/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	
//  When user dashboards is on dashboard page
	@When("user dashboards is on dashboard page")
	public void user_dashboards_is_on_dashboard_page() {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	}
	
	@When("cashiers is on transaction page")
	public void cashiers_is_on_transaction_page() {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("putri@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("putri");
	    driver.findElement(By.tagName("form")).submit();
	}
	
//  Then user click button total
	@Then("user click button total")
	public void user_click_button_total() {
		// Temukan elemen canvas
	    try {
	    	Thread.sleep(10000);
		} catch (InterruptedException e) {
		        e.printStackTrace();
		}
	    
	    WebElement canvas = driver.findElement(By.tagName("canvas"));
	    Actions actions = new Actions(driver);
	    
	    boolean isClicked = false;
		try {
			actions.moveToElement(canvas, 257, 22).click().perform();
		} catch (NoSuchElementException e) {
			isClicked = false;
		}
		Assert.assertFalse("Failed to display the 'Failed to create employee' notification! ", isClicked);
	} 
	
//	Then user should be able to see the component statistic of best selling 
	@Then("user should be able to see the component statistic of best selling")
	public void user_should_be_able_to_see_the_component_statistic_of_best_selling() {
		
		List<WebElement> bestSelling = driver.findElements(By.xpath("//h5[text()='Statistic of Best Selling']"));
		if (bestSelling.isEmpty()) {
			System.out.println("Statistic of Best Selling is not displayed in dashboard page!");
		} else if (!bestSelling.isEmpty()){
			System.out.println("Statistic of Best Selling is displayed in dashboard page!");
		}
		Assert.assertTrue(!bestSelling.isEmpty());
	}
	
//	Then user should not be able to see the component statistic of best selling 
	@Then("user should not be able to see the component statistic of best selling")
	public void user_should_not_be_able_to_see_the_component_statistic_of_best_selling() {
		List<WebElement> bestSelling = driver.findElements(By.xpath("//h5[text()='Statistic of Best Selling']"));
		if (bestSelling.isEmpty()) {
			System.out.println("Statistic of Best Selling is not displayed in transaction page!");
		} else if (!bestSelling.isEmpty()){
			System.out.println("Statistic of Best Selling is displayed in transaction page!");
		}
		Assert.assertTrue(bestSelling.isEmpty());
	}
	
}
