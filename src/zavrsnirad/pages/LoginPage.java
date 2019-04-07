package zavrsnirad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public static final String PAGE_URL = "http://localhost/izlet/izlet/dashboard.php";
	public static final String LOGIN_URL = "http://localhost/izlet/izlet/index.php";

	private static final String USERNAME = "//input[@placeholder='username']";
	private static final String PASSWORD = "//input[@placeholder='password']";
	private static final String LOG_IN_BTN = "//input[@value='Log in']";
	private static final String LOG_OUT_BTN = "//a[@id='logoutBtn']";

	private WebDriver wd;

	public LoginPage(WebDriver wd) {
		this.wd = wd;
	}

	// get username field
	public WebElement getUsernameField() {
		return wd.findElement(By.xpath(USERNAME));
	}

	// set value to username field
	public void setUsernameField(String value) {
		WebElement username = getUsernameField();
		username.sendKeys(value);
	}

	// click username field
	public void clickUsernameField() {
		getUsernameField().click();
	}

	// get password field
	public WebElement getPasswordField() {
		return wd.findElement(By.xpath(PASSWORD));
	}

	// click password field
	public void clickPasswordField() {
		getUsernameField().click();
	}

	// set value to password field
	public void setPasswordField(String value) {
		WebElement password = getPasswordField();
		password.sendKeys(value);
	}

	// get LogIn Button
	public WebElement getLogInButton() {
		return wd.findElement(By.xpath(LOG_IN_BTN));
	}

	// click LogIn Button
	public void clickLogInButton() {
		getLogInButton().click();
	}

	// Method to get LogOut Button
	public WebElement getLogOutButton() {
		return wd.findElement(By.xpath(LOG_OUT_BTN));
	}

	// click LogOut Button
	public void clickLogOutButton() {
		getLogOutButton().click();
	}

}
