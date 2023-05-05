package ContactUs;

import org.openqa.selenium.By;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

public class MembukaAkunInstagramSebagaiEmployeeFeature {
//	@Given("browser is open")
//	public void browserIsOpen() {
//        Driver.getInstance();
//    }
//	
	@And("user is already in home page as employee")
	public void user_is_already_in_home_page_as_employee() {
		 Driver.getInstance().navigate().to("https://app.bleven.web.id/login");
	     Driver.getInstance().findElement(By.xpath("//input[@id='email']")).sendKeys("putri@gmail.com");
	     Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("putri");
	     Driver.getInstance().findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
	}
	
	@When("user clicks on contact us button")
	public void user_clicks_on_contact_us_button() {
		Driver.getInstance().findElement(By.cssSelector("[href=\"/contact-us\"]")).click();
	}
	
	@And("user clicks on instagram button")
	public void user_clicks_on_instagram_button() {
		Driver.getInstance().findElement(By.xpath("//a[@href=\"http://instagram.com/blevenpos\"]")).click();
	}
	
	@Then("user is navigated to bleven instagram profile")
	public void user_is_navigated_to_bleven_instagram_profile() {
		try {
			String parent = Driver.getInstance().getWindowHandle();
			System.out.println(parent);
			Set<String> s = Driver.getInstance().getWindowHandles();
			Iterator<String> I1= s.iterator();

			while(I1.hasNext())
			{

			String child_window=I1.next();

			if(!parent.equals(child_window))
				{
				Driver.getInstance().switchTo().window(child_window);
				String textInformation = Driver.getInstance().getCurrentUrl();
				assertEquals("https://www.instagram.com/blevenpos/",textInformation);
				Driver.getInstance().switchTo().window(parent);
				}
			}
			
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }
	}
}
