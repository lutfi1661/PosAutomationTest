package Category;

import io.cucumber.java.en.*;
import Driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AddCategorySteps {

    WebDriver driver = Driver.getInstance();

    @Given("user is on the category page")
    public void user_is_on_category_page() {
        driver.navigate().to("https://app.bleven.web.id/home");
        driver.findElement(By.id("email")).sendKeys("cholid@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.tagName("form")).submit();
        driver.findElement(By.cssSelector("img[alt='Category Logo']")).click();
    }

    @When("user click add category button")
    public void user_click_add_category_button() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/section/div/div/div/div/div[1]/div/div/button")).click();
    }

    @Then("screen popped up")
    public void screen_popped_up() {
    }

    @And("user input new category name {string}")
    public void user_input_new_test_canned_food_name(String category) {
        driver.findElement(By.id("kategori_id")).sendKeys(category);
    }

    @And("user submit new category")
    public void user_submit_new_category() {
        driver.findElement(By.xpath("//*[@id=\"saveBtn\"]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        driver.navigate().refresh();
    }

    @Then("new category {string} is showed in data table")
    public void new_category_is_showed_in_data_table(String category) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(category);
        String actual = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]")).getText();
        Assert.assertEquals(category, actual);
    }

}
