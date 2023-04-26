package Employee;

import Driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

//Author : Reihan Reinaldi Suryaman
//Date	: 24/04/2023
//Description : Testing GoGrids view event feature

public class HapusEmployeeFeature {

    private int jmlEmployee = 0;

    @Given("browser is open")
    public void browserIsOpen() {
        Driver.getInstance();
    }

    @And("user had logged in as administrator")
    public void userHadLoggedInAsAdministrator() {
        Driver.getInstance().navigate().to("https://app.bleven.web.id/login");
        Driver.getInstance().findElement(By.xpath("//input[@id='email']")).sendKeys("fiora@gmail.com");
        Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("fiora");
        Driver.getInstance().findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
    }

    @And("there is at least one employee")
    public void thereIsAtLeastOneEmployee() {
        Driver.getInstance().findElement(By.cssSelector("[href=\"/employee\"]")).click();
        Driver.getInstance().findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/section/div/div/div/div/div[1]/div/div/button")).click();
        new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='nama_user']"))).sendKeys("Dummy Employee");
        Driver.getInstance().findElement(By.xpath("//input[@id='email_user']")).sendKeys("dummyemployee@gmail.com");
        Driver.getInstance().findElement(By.xpath("//input[@id='password']")).sendKeys("dummypass");
        Driver.getInstance().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("dummypass");
        Driver.getInstance().findElement(By.xpath("//*[@id=\"saveBtn\"]")).click();
        Driver.getInstance().navigate().to("https://app.bleven.web.id/home");
    }

    @When("user clicks on employee menu")
    public void userClicksOnEmployeeMenu() {
        Driver.getInstance().findElement(By.cssSelector("[href=\"/employee\"]")).click();
        jmlEmployee = Driver.getInstance().findElements(By.tagName("tr")).stream().toList().size();
        System.out.println("Before " + jmlEmployee);
    }

    @And("user clicks on trash icon button on one of the employee")
    public void userClicksOnTrashIconButtonOnOneOfTheEmployee() {
        int lastEmployee = jmlEmployee - 1;
        Driver.getInstance().findElement(By.xpath("//*[@id=\"table\"]/tbody/tr["+ lastEmployee +"]/td[5]/button[2]")).click();
    }

    @And("user confirm delete employee action")
    public void userConfirmDeleteEmployeeAction() {
        Driver.getInstance().switchTo().alert().accept();
    }

    @Then("employee selected is deleted")
    public void employeeSelectedIsDeleted() {
        int lastEmployee = jmlEmployee - 1;

        Driver.getInstance().navigate().refresh();
        try{
            assertThrows(NoSuchElementException.class, () -> {
                Driver.getInstance().findElement(By.xpath("//*[@id=\"table\"]/tbody/tr["+ lastEmployee +"]"));
            });
        } finally {
            Driver.getInstance().close();
            Driver.deleteInstance();
        }
    }
}
