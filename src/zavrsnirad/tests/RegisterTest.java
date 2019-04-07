package zavrsnirad.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import zavrsnirad.pages.RegisterPage;
import zavrsnirad.utils.ExcelUtils;

public class RegisterTest {

	public WebDriver wd;
	private RegisterPage registerPage;

	public RegisterTest(WebDriver wd) {
		this.wd = wd;
		registerPage = new RegisterPage(wd);
	}

	// test register for one user
	public void register(String firstname, String lastname, String username, String email, String password) {
		registerPage.clickFirstnameField();
		registerPage.setFirstNameField(firstname);
		registerPage.clickLastnameField();
		registerPage.setLastNameField(lastname);
		registerPage.clickUsernameField();
		registerPage.setUsernameField(username);
		registerPage.clickEmailField();
		registerPage.setEmailField(email);
		registerPage.clickPasswordField();
		registerPage.setPasswordField(password);

		registerPage.clickRegisterButton();

		if (wd.getCurrentUrl().equals(RegisterPage.PAGE_URL)) {
			System.out.println("Registration was not successful.");
		} else {
			System.out.println("Registration was successful.");
		}
	}

	// test register feature
	public void registerTest(boolean automatic) throws Exception {
		if (automatic) {
			ExcelUtils.setExcelFile(ExcelUtils.PATH, ExcelUtils.USER_SHEET);
			// we start from 1 because of the header row
			for (int i = 1; i < ExcelUtils.getRowCount(ExcelUtils.USER_SHEET); i++) {
				String firstname = ExcelUtils.getCellData(i, 0);
				String lastname = ExcelUtils.getCellData(i, 1);
				String username = ExcelUtils.getCellData(i, 2);
				String email = ExcelUtils.getCellData(i, 3);
				String password = ExcelUtils.getCellData(i, 4);
				register(firstname, lastname, username, email, password);
			}
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter firstname");
			String firstname = sc.next();
			System.out.println("Enter lastname");
			String lastname = sc.next();
			System.out.println("Enter username");
			String username = sc.next();
			System.out.println("Enter email");
			String email = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			register(firstname, lastname, username, email, password);
		}
	}
}
