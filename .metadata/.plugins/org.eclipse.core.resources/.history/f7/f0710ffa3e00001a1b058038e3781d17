package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver driver; 
	
	/**
	 * Constructor
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Go to home page
	 */
	public void goToPage() {
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	/**
	 * Click on the signin Button 
	 */
	public void ClickOnSignInButton() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]"));
		element.click();
	}
	
}
