package ContactUs;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

//Author : Muhammad Rasyid Fadlurrahman
//Date	: 26/04/2023
//Description : Testing POS ContactUs Feature

public class MengirimPesanPadaDeveloper {
	
	@Given("browser is open")
    public void browserIsOpen() {
        Driver.getInstance();
    }

    @And("User already in home page")
    public void User_already_in_home_page() {
        Driver.getInstance().navigate().to("https://app.bleven.web.id/login");
        Driver.getInstance().findElement(By.xpath("//input[@id='email']")).sendKeys("fiora@gmail.com");
        Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("fiora");
        Driver.getInstance().findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
    }
    
    @When("User clicks on contact us at the left corner")
    public void User_clicks_on_contact_us_at_the_left_corner() {
        Driver.getInstance().findElement(By.cssSelector("[href=\"/contact-us\"]")).click();
       
    }
    
    @And("User enters {word} {word} and {word}")
    public void User_enters_name_mail_and_message(String arg1, String arg2, String arg3) {
    	if(arg1.equals("<blank>")) {
			arg1 = "";
		}
		if(arg2.equals("<blank>")) {
			arg2 = "";
		}
		if(arg3.equals("<blank>")) {
			arg3 = "";
		}
		Driver.getInstance().findElement(By.name("user_name")).sendKeys(arg1); 
		Driver.getInstance().findElement(By.name("user_email")).sendKeys(arg2);
		Driver.getInstance().findElement(By.name("message")).sendKeys(arg3);
    }
    
    @And("User clicks on submit button")
    public void User_clicks_on_submit_button() {
    	Driver.getInstance().findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    @Then("User should be able to see Your message has been sent successfully")
    public void User_should_be_able_to_see_Your_message_has_been_sent_uccessfully() {
    	try {
    		String textInformation = Driver.getInstance().findElement(By.className("modal-body")).getText();
        	assertEquals("Your message has been sent successfully!",textInformation);
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }
    }
    
    @Then("User should be able to see Failed to sent message")
    public void User_should_be_able_to_see_Failed_to_sent_message() {
    	try {
    		String textInformation = Driver.getInstance().findElement(By.className("modal-body")).getText();
        	assertEquals("Failed to sent message",textInformation);
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }
    }
}
