package zavrsnirad.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import zavrsnirad.pages.PostPage;
import zavrsnirad.utils.ExcelUtils;

public class PostTest {

	public WebDriver wd;
	public PostPage postPage;

	public PostTest(WebDriver wd) {
		this.wd = wd;
		this.postPage = new PostPage(wd);
	}

	// test post for one user
	public void post(String title, String location, String text) throws Exception {
		postPage.clickNewPostButton();
		postPage.clickTitleField();
		postPage.setPostTitleField(title);
		postPage.clickLocationField();
		postPage.setLocationField(location);
		postPage.setImage();
		postPage.selectTransport("car");
		postPage.clickDescriptionField();
		postPage.setDescriptionField(text);

		postPage.clickPostButton();
		if (wd.getCurrentUrl().equals(PostPage.PAGE_URL)) {
			System.out.println("Posting was successful.");
		} else {
			System.out.println("Posting was not successful.");
		}
	}

	// test post feature
	public void postTest(boolean automatic) throws Exception {
		if (automatic) {
			ExcelUtils.setExcelFile(ExcelUtils.PATH, ExcelUtils.POST_SHEET);
			for (int i = 0; i < 5; i++) {
				String title = ExcelUtils.getCellData(i, 1);
				String location = ExcelUtils.getCellData(i, 2);
				String text = ExcelUtils.getCellData(i, 0);
				post(title, location, text);
			}
		} else {
			// we are creating at least 3 posts: two for deleting and one for editing
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter post title");
			String title = sc.nextLine();
			System.out.println("Enter post location");
			String location = sc.nextLine();
			System.out.println("Enter post text");
			String text = sc.nextLine();
			post(title, location, text);
			System.out.println("Enter second post title");
			title = sc.nextLine();
			System.out.println("Enter second post location");
			location = sc.nextLine();
			System.out.println("Enter second post text");
			text = sc.nextLine();
			post(title, location, text);
			System.out.println("Enter third post title");
			title = sc.nextLine();
			System.out.println("Enter third post location");
			location = sc.nextLine();
			System.out.println("Enter third post text");
			text = sc.nextLine();
			post(title, location, text);
		}
	}
}
