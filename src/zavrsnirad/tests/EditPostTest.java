package zavrsnirad.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import zavrsnirad.pages.PostPage;

public class EditPostTest {
	public WebDriver wd;
	private PostPage postPage;

	public EditPostTest(WebDriver wd) {
		this.wd = wd;
		this.postPage = new PostPage(wd);
	}

	public void editTest() {
		Scanner sc = new Scanner(System.in);
		postPage.clickEdit(0);
		postPage.clickEditTitleField();
		postPage.getEditTitleField().clear();
		System.out.println("New post title");
		String title = sc.nextLine();
		postPage.setEditTitleField(title);
		postPage.clickEditLocationField();
		postPage.getEditLocationField().clear();
		System.out.println("New post location");
		String location = sc.nextLine();
		postPage.setEditLocationField(location);
		postPage.clickEditDescriptionField();
		postPage.getEditDescriptionField().clear();
		System.out.println("New post description");
		String description = sc.nextLine();
		postPage.setEditDescriptionField(description);
		postPage.setChangeImage();	

		postPage.clickEditPostButton();
		if (wd.getCurrentUrl().equals(PostPage.PAGE_URL)) {
			System.out.println("Post was successfully edited.");
		} else {
			System.out.println("Posting was not edited successfully.");
		}
	}
}
