package zavrsnirad.tests;

import org.openqa.selenium.WebDriver;

import zavrsnirad.pages.PostPage;

public class DeletePostTest {
	public WebDriver wd;
	private PostPage postPage;

	public DeletePostTest(WebDriver wd) {
		this.wd = wd;
		this.postPage = new PostPage(wd);
	}

	public void deleteTest() {
		postPage.deletePost(0);
		postPage.deletePost(0);

		if (wd.getCurrentUrl().equals(PostPage.PAGE_URL)) {
			System.out.println("Deleting was successful.");
		} else {
			System.out.println("Deleting was not successful.");
		}
	}
}
