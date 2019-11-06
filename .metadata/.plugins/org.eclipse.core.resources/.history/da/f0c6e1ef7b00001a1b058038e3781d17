package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressPage {
	// the web driver
	WebDriver driver;

	// element for highest price dress
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]/ul/li[2]/div")
	private WebElement highestPriceDress; 
	
	// add to cart element
	@FindBy(how=How.XPATH, using="//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")
	private WebElement addToCart;
	
	// the cart element
	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	private WebElement cart;
	
	// close button for the layer cart 
	@FindBy(how=How.XPATH, using="//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
	private WebElement layerCartCloseButton;
	
	// Sign out button
	@FindBy(how=How.XPATH, using="//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
	private WebElement signOutButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"product_4_16_0_234736\"]/td[2]/p/a")
	private WebElement dressName;
	
	/**
	 * DressPage constructor
	 * @param driver
	 */
	public DressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Go to the dress page
	 */
	public void goToPage() {
		driver.navigate().to("http://automationpractice.com/index.php?id_category=8&controller=category");
	}
	
	/**
	 * Click the cart
	 */
	public void clickOnCart() {
		cart.click();
	}
	
	/**
	 * Click on the dress with the highest price
	 */
	public void addTheHighestPriceDressToCart() {
		Actions action = new Actions(driver);
		action.moveToElement(highestPriceDress).moveToElement(addToCart).click();	
		action.build().perform();
	}
	
	/**
	 * Close the layer cart window
	 */
	public void closeLayerCart() {
		// wait for layer cart close button to load
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.elementToBeClickable(layerCartCloseButton));
		
		layerCartCloseButton.click();
	}
	
	/**
	 * Click sign out 
	 */
	public void clickSignOut() {
		signOutButton.click();
	}
	
	/**
	 * @return, the details of the most expensive dress from cart
	 */
	public String getSingleDressDetailFromCart() {
		return dressName.getText();
	}
}
