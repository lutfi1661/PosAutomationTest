package Dashboard;

import Driver.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

//Author : Reihan Reinaldi Suryaman
//Date	: 24/04/2023
//Description : Testing GoGrids view event feature

public class MenampilkanExpiredSoonFeature {
    @When("user is logging in as admin")
    public void userIsLoggingInAsAdmin() {
        Driver.getInstance().navigate().to("https://app.bleven.web.id/login");
        Driver.getInstance().findElement(By.xpath("//input[@id='email']")).sendKeys("fiora@gmail.com");
        Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("fiora");
        Driver.getInstance().findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
    }

    @Then("user should be able to see expired soon section")
    public void userShouldBeAbleToSeeExpiredSoonSection() {
        try {
            assertTrue(Driver.getInstance().findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/div/div[2]/div[4]/div/div[2]")).isDisplayed());
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }

    }
}
