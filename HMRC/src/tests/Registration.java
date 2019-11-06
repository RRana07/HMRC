package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.SignInPage;

class Registration {
	private WebDriver driver;
	
	// Pages
	private HomePage homePage;
	private SignInPage signInPage;
	
	/**
	 * Setup before test
	 */
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}
	
	/**
	 * Before every test
	 */
	@BeforeEach
	public void beforeTest() {
		driver = new ChromeDriver();		
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	}
	
	/**
	 * Invalid email address
	 */
	@Test
	void invalidEmailAddressDuringRegistrationA(){
		signInPage.goToPage();		
		signInPage.inputInValidRegEmailAddressA();
		signInPage.clickCreateAccount();
		String msg = signInPage.getMessageOnInvalidEmail();
		
		assertEquals(msg, "Invalid email address.");
	}
	
	/**
	 * Invalid email address
	 */
	@Test
	void invalidEmailAddressDuringRegistrationB(){
		signInPage.goToPage();
		signInPage.inputInValidRegEmailAddressB();
		signInPage.clickCreateAccount();
		String msg = signInPage.getMessageOnInvalidEmail();
		
		assertEquals(msg, "Invalid email address.");
	}
	
	/**
	 * Invalid email address
	 */
	@Test
	void invalidEmailAddressDuringRegistrationC(){
		signInPage.goToPage();
		signInPage.inputInValidRegEmailAddressC();
		signInPage.clickCreateAccount();
		String msg = signInPage.getMessageOnInvalidEmail();
		
		assertEquals(msg, "Invalid email address.");
	}
	
	/**
	 * Valid registration
	 */
	@Test
	void validRegistration() {
		signInPage.goToPage();
		signInPage.inputValidRegEmailAddress("azz");
		signInPage.clickCreateAccount();
		signInPage.selectMaleGender();
		signInPage.enterFirstName("Joe");
		signInPage.enterLastName("JJ");
		signInPage.enterValidRegisterFormPassword();
		//signInPage.selectDOBDay();
		//signInPage.selectDOBMonth();
		//signInPage.selectDOBYear();
		signInPage.enterCompany();
		signInPage.enterAddress();
		signInPage.selectState();
		signInPage.enterZipCode("12345");
		signInPage.selectCountry();
		signInPage.enterHomeNumber();
		signInPage.enterMobileNumber();
		signInPage.enterAddressAlias();
		signInPage.clickRegister();
	}
	
	/**
	 * Invalid sign in email
	 */
	@Test
	void invalidSignInEmail() {
		signInPage.goToPage();
		signInPage.inputInvalidSignInEmailAddress();
		signInPage.clickSignInButton();
		assertEquals(signInPage.getMessageOnInvalidSignin(), "Invalid email address.");
	}
	
	/**
	 * No password on sign in
	 */
	@Test
	void noPassword() {
		signInPage.goToPage();
		signInPage.inputValidSignInEmailAddress();
		signInPage.clickSignInButton();
		assertEquals(signInPage.getMessageOnInvalidSignin(), "Password is required.");
	}
	
	/**
	 * Incorrect sign in
	 */
	@Test
	void incorrectSignIn() {
		signInPage.goToPage();
		signInPage.inputInCorrectEmailAddress();
		signInPage.inputIncorrectPassword();
		signInPage.clickSignInButton();
		assertEquals(signInPage.getMessageOnInvalidSignin(), "Authentication failed.");
	}
	
	/**
	 * Valid sign in 	 
	 */
	@Test
	void validSignIn() {
		signInPage.goToPage();
		signInPage.inputValidSignInEmailAddress();
		signInPage.inputCorrectPassword();
		signInPage.clickSignInButton();
		assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
	}
	
	/**
	 * Clean up after each test
	 */
	@AfterEach
	public void cleanUp() {
		driver.close();
	}

}
