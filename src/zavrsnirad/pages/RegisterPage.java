package zavrsnirad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	public static final String PAGE_URL = "http://localhost/izlet/";
	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//form[@action='processregister.php']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//form[@action='processregister.php']//input[@name='password']";
	private static final String REGISTER = "//input[@id='blue_btn']";

	private WebDriver wd;

	public RegisterPage(WebDriver wd) {
		this.wd = wd;
	}

	// get firstname field
	public WebElement getFirstNameField() {
		return wd.findElement(By.xpath(FIRST_NAME));
	}

	// click on Firstname field
	public void clickFirstnameField() {
		getFirstNameField().click();
	}

	// set value to firstname field
	public void setFirstNameField(String value) {
		getFirstNameField().sendKeys(value);
	}

	// get lastname field
	public WebElement getLastNameField() {
		return wd.findElement(By.xpath(LAST_NAME));
	}

	// click Lastname field
	public void clickLastnameField() {
		getLastNameField().click();
	}

	// set value to lastname field
	public void setLastNameField(String str) {
		getLastNameField().sendKeys(str);
	}

	// get username field
	public WebElement getUsernameField() {
		return wd.findElement(By.xpath(USERNAME));
	}

	// set value to username field
	public void clickUsernameField() {
		getUsernameField().click();
	}

	// set value to username
	public void setUsernameField(String str) {
		getUsernameField().sendKeys(str);
	}

	// get email field
	public WebElement getEmailField() {
		return wd.findElement(By.xpath(EMAIL));
	}

	// click email field
	public void clickEmailField() {
		getEmailField().click();
	}

	// set value to set email
	public void setEmailField(String str) {
		getEmailField().sendKeys(str);
	}

	// get password field
	public WebElement getPasswordField() {
		return wd.findElement(By.xpath(PASSWORD));
	}

	// click on Password field
	public void clickPasswordField() {
		getPasswordField().click();
	}

	// set value to password field
	public void setPasswordField(String str) {
		getPasswordField().sendKeys(str);
	}

	// get registration Button
	public WebElement getRegisterButton() {
		return wd.findElement(By.xpath(REGISTER));
	}

	// click registration button
	public void clickRegisterButton() {
		getRegisterButton().click();
	}

}
