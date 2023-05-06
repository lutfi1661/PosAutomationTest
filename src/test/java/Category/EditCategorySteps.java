package Category;

import Driver.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;

import java.util.concurrent.TimeUnit;

public class EditCategorySteps {
    WebDriver driver = Driver.getInstance();

    @When("user find old category {string}")
    public void user_find_old_category(String oldCategory) {
        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(oldCategory);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @And("user click edit category icon")
    public void user_click_edit_category_icon() {
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[3]/button[1]")).click();

    }

    @Then("edit category screen popped up")
    public void edit_category_screen_popped_up() {
    }

    @And("user change category name with {string}")
    public void user_change_category_name_with(String newCategory) {
        WebElement textInput = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/section/div/div/div/div/div[2]/div[2]/div[22]/div/form/div/div[2]/div/input"));
//        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/section/div/div/div/div/div[2]/div[2]/div[22]/div/form/div/div[2]/div/input")).sendKeys(Keys.CONTROL + "a");
        textInput.sendKeys(Keys.CONTROL + "a");
        textInput.sendKeys(newCategory);

    }

    @And("user submit new updated category")
    public void user_submit_new_updated_category() {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/section/div/div/div/div/div[2]/div[2]/div[22]/div/form/div/div[3]/button[2]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        driver.navigate().refresh();
    }

    @Then("updated category {string} is showed in data table")
    public void updated_category_is_showed_in_data_table(String newCategory) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("//*[@id=\"table_filter\"]/label/input")).sendKeys(newCategory);
        String actual = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr/td[2]")).getText();
        Assert.assertEquals(newCategory, actual);
    }
}
