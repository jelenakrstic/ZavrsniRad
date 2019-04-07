package zavrsnirad.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import zavrsnirad.pages.LoginPage;
import zavrsnirad.utils.ExcelUtils;

public class LogInTest {
	public WebDriver wd;
	private LoginPage loginPage;

	public LogInTest(WebDriver wd) {
		this.wd = wd;
		this.loginPage = new LoginPage(wd);
	}

	// test login for one user
	public void logIn(String username, String password) {
		loginPage.clickUsernameField();
		loginPage.setUsernameField(username);
		loginPage.clickPasswordField();
		loginPage.setPasswordField(password);

		loginPage.clickLogInButton();

		if (wd.getCurrentUrl().equals(LoginPage.PAGE_URL)) {
			System.out.println("Log in successful.");
		} else {
			System.out.println("Log in was not successful.");
		}
	}

	// logout user
	public void logOut() {
		loginPage.getLogOutButton().click();
		if (wd.getCurrentUrl().equals(LoginPage.LOGIN_URL)) {
			System.out.println("Log out was successful.");
		} else {
			System.out.println("Log out was not successful.");
		}
	}

	// test login feature
	public void logInTest(boolean automatic) throws Exception {
		if (automatic) {
			ExcelUtils.setExcelFile(ExcelUtils.PATH, ExcelUtils.USER_SHEET);
			// we start from 1 because of the header row
			for (int i = 1; i < ExcelUtils.getRowCount(ExcelUtils.USER_SHEET); i++) {
				String username = ExcelUtils.getCellData(i, 2);
				String password = ExcelUtils.getCellData(i, 4);
				logIn(username, password);
				logOut();
			}
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter username");
			String username = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			logIn(username, password);
			logOut();
		}
	}
}
