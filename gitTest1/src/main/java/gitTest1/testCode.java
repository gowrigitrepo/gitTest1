package gitTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testCode {

	static WebDriver driver;
	static By locator;

	public static void waitMethod(By locator) {
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	@Test
	public static void jenkinsTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://qa-tekarch.firebaseapp.com/");

		locator = By.id("email_field"); // identifying the locator

		waitMethod(locator);

		WebElement username = driver.findElement(locator); // locating the webelement

		username.sendKeys("admin123@gmail.com"); // sending the value of the web element

		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();

	}

}
