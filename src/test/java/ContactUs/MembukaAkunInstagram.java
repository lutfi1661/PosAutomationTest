package ContactUs;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import java.util.Iterator; 
import java.util.Set;


import java.time.Duration;

import static org.junit.Assert.*;

//Author : Muhammad Rasyid Fadlurrahman
//Date	: 26/04/2023
//Description : Testing POS ContactUs Feature

public class MembukaAkunInstagram {

	@When("User clicks on instagram logo")
    public void User_clicks_on_instagram_logo() {
    	Driver.getInstance().findElement(By.xpath("//a[@href=\"http://instagram.com/blevenpos\"]")).click();
       
    }
	
	@Then("User is navigated to the bleven instagram page")
    public void User_is_navigated_to_the_bleven_instagram_page() {
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
