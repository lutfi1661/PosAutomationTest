package Driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
	private static Driver instance = null;
	public WebDriver driver = null;
	
	private Driver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
	
	public static synchronized WebDriver getInstance() {
		if (instance == null)
			instance = new Driver();
		
		return instance.driver;
	}
	
	public static synchronized void deleteInstance() {
		if (instance != null)
			instance = null;
	}
}