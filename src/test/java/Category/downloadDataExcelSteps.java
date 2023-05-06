package Category;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class downloadDataExcelSteps {
	WebDriver driver = null;
	
	@Given("User excel category has opened the browser")
	public void User_excel_category_has_opened_the_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:/Users/LENOVO/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    driver = new ChromeDriver(options);
	    driver.manage().window().maximize();	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	@And("User excel category already in home page")
	public void User_excel_category_already_in_home_page() {
	    driver.navigate().to("https://app.bleven.web.id/login");
	    driver.findElement(By.id("email")).sendKeys("fiora@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("fiora");
	    driver.findElement(By.tagName("form")).submit();
	}
	
	@When("User excel category clicks sidebar submenu Category")
	public void User_excel_category_clicks_sidebar_submenu_Category() {
	    driver.findElement(By.cssSelector("img[alt='Category Logo']")).click();
	}

	@And("User excel category clicks Download Excel button on page {string}")
	public void User_excel_category_clicks_Download_Excel_button_on_page_custom(String page) {
		if (!page.equals("1")) {
			driver.findElement(By.xpath("//a[text()='"+ page +"']")).click();
		}
		driver.findElement(By.className("buttons-csv")).click();
	}
	
	@Then("File Excel Downloaded Succesfully")
	public void File_Excel_Downloaded_Succesfully() {
        if (driver.getCurrentUrl().contains("/category")) {
            System.out.println("Successfully download file excel");
        } else {
            System.out.println("Failed to download file excel");
        }
	}
}
