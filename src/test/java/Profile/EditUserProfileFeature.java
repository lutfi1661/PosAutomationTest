package Profile;

import org.openqa.selenium.By;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EditUserProfileFeature {
	@And("user clicks on profile")
	public void user_clicks_on_profile() {
		Driver.getInstance().findElement(By.cssSelector("[href=\"/profile\"]")).click();
	}
	
	@And("user clicks on edit profile button")
	public void user_clicks_on_edit_profile_button() {
		Driver.getInstance().findElement(By.cssSelector("[href=\"/profileedit\"]")).click();
	}
	
	@And("user inputs {word}")
	public void user_inputs_fullname(String fullname) {
		if(fullname.equals("<blank>")) {
			fullname = "";
		}
		Driver.getInstance().findElement(By.id("name")).sendKeys(fullname);
	}
	
	@And("user clicks on save changes button")
	public void user_clicks_on_save_changes_button() {
		Driver.getInstance().findElement(By.id("saveButton")).click();
	}
	
	@And("profile updated notification is shown")
	public void profile_updated_notification_is_shown() {
		Driver.getInstance().findElement(By.className("Toastify__toast-container"));
	}
	
	@And("user clicks on back button")
	public void user_clicks_on_back_button() {
		Driver.getInstance().findElement(By.cssSelector("[href=\"/profile\"]")).click();
	}
	
	@Then("now user full name is the same as {word}")
	public void now_user_full_name_is_the_same_as_fullname(String fullname) {
		try {
			try {
				  Thread.sleep(3000);
				} catch (InterruptedException e) {
				  Thread.currentThread().interrupt();
				}	
			String nameValue = Driver.getInstance().findElement(By.id("name")).getAttribute("value");
			System.out.println("nameValue = " + nameValue);
			System.out.println("fullname = " + fullname);
			assertEquals(fullname, nameValue);
		} finally {
            Driver.deleteInstance();
		}
	}
}

//*[@id="root"]/div[1]/div[2]/div/div/a
//*[@id="backButton"]
