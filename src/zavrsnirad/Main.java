package zavrsnirad;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import zavrsnirad.pages.HomePage;
import zavrsnirad.tests.DeletePostTest;
import zavrsnirad.tests.EditPostTest;
import zavrsnirad.tests.LogInTest;
import zavrsnirad.tests.PostTest;
import zavrsnirad.tests.RegisterTest;
import zavrsnirad.utils.ExcelUtils;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krstic\\Downloads\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.get(HomePage.PAGE_URL);

		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to run tests automatically (y/n): ");
		boolean automatic;
		char c = sc.next().toLowerCase().charAt(0);
		switch (c) {
		case 'y':
			automatic = true;
			break;
		case 'n':
			automatic = false;
			break;
		default:
			System.out.println("Unknown option. Tests will run automatically.");
			automatic = true;
			break;
		}

		try {
			RegisterTest registerTest = new RegisterTest(wd);
			LogInTest loginTest = new LogInTest(wd);
			PostTest postTest = new PostTest(wd);
			DeletePostTest deletePostTest = new DeletePostTest(wd);
			EditPostTest editPostTest = new EditPostTest(wd);

			registerTest.registerTest(automatic);
			loginTest.logInTest(automatic);

			// login as some user who will create posts
			if (automatic) {
				// Now we login as the 10th user from excel file. That user will create posts
				ExcelUtils.setExcelFile(ExcelUtils.PATH, ExcelUtils.USER_SHEET);
				String username = ExcelUtils.getCellData(10, 2);
				String password = ExcelUtils.getCellData(10, 4);
				loginTest.logIn(username, password);
			} else {
				System.out.println("Enter username");
				String username = sc.next();
				System.out.println("Enter password");
				String password = sc.next();
				loginTest.logIn(username, password);
			}
			postTest.postTest(automatic);
			deletePostTest.deleteTest();
			editPostTest.editTest();

			loginTest.logOut();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
