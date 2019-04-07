package zavrsnirad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PostPage {

	public static final String PAGE_URL = "http://localhost/izlet/izlet/dashboard.php";
	public static final String IMAGE_PATH = "C:\\Users\\Krstic\\Desktop\\izlet\\images\\bg3.png";
	public static final String CHANGED_IMAGE_PATH = "C:\\Users\\Krstic\\Desktop\\izlet\\images\\izletbg.jpeg";
	private static final String NEW_POST = "//div[@id='newPostBtn']";
	private static final String TITLE = "//input[@placeholder='Naziv']";
	private static final String LOCATION = "//input[@placeholder='Lokacija']";
	private static final String BROWSE = "image";
	private static final String TRANSPORT = "//div[@class='popupPost']//select[@name='transport']";
	private static final String DESCRIPTION = "//textarea[@placeholder='Opis']";
	private static final String POST_BTN = "//input[@name='postSubmit']";
	private static final String THREE_DOTS_CLASS_NAME = "fa-ellipsis-v";
	private static final String DELETE_CLASS_NAME = "fa-trash-alt";
	private static final String EDIT_CLASS_NAME = "fa-edit";
	private static final String CHANGE_IMAGE = "editImage";
	private static final String CHANGE_TITLE = "title";
	private static final String CHANGE_LOCATION = "location";
	private static final String CHANGE_DESCRIPTION = "description";
	private static final String EDIT_POST_BTN = "//div[@class='popupEdit']//input[@value='Post']";

	private WebDriver wd;

	public PostPage(WebDriver wd) {
		this.wd = wd;
	}

	// get Make A Post button
	public WebElement getNewPost() {
		return wd.findElement(By.xpath(NEW_POST));
	}

	// click Make A Post button
	public void clickNewPostButton() {
		getNewPost().click();
	}

	// get post title field
	public WebElement getPostTitleField() {
		return wd.findElement(By.xpath(TITLE));
	}

	// click post title field
	public void clickTitleField() {
		getPostTitleField().click();
	}

	// set value to post title field
	public void setPostTitleField(String str) {
		getPostTitleField().sendKeys(str);
	}

	// get edit title input field
	public WebElement getEditTitleField() {
		return wd.findElement(By.id(CHANGE_TITLE));
	}

	// click on edit title input field
	public void clickEditTitleField() {
		getEditTitleField().click();
	}

	// set value to edit title field
	public void setEditTitleField(String value) {
		getEditTitleField().sendKeys(value);
	}

	// get edit location input field
	public WebElement getEditLocationField() {
		return wd.findElement(By.id(CHANGE_LOCATION));
	}

	// click on edit location input field
	public void clickEditLocationField() {
		getEditLocationField().click();
	}

	// set value to edit location field
	public void setEditLocationField(String value) {
		getEditLocationField().sendKeys(value);
	}

	// get edit description input field
	public WebElement getEditDescriptionField() {
		return wd.findElement(By.id(CHANGE_DESCRIPTION));
	}

	// click on edit description input field
	public void clickEditDescriptionField() {
		getEditDescriptionField().click();
	}

	// set value to edit description field
	public void setEditDescriptionField(String value) {
		getEditDescriptionField().sendKeys(value);
	}

	// find Location field
	public WebElement getLocationField() {
		return wd.findElement(By.xpath(LOCATION));
	}

	// click location field
	public void clickLocationField() {
		getLocationField().click();
	}

	// set value to location field
	public void setLocationField(String value) {
		getLocationField().sendKeys(value);
	}

	// Method to find Browse Image Button
	public WebElement getBrowseButton() {
		return wd.findElement(By.id(BROWSE));
	}

	// Method to set image
	public void setImage() throws Exception {
		getBrowseButton().sendKeys(IMAGE_PATH);
		Thread.sleep(3000);
	}

	// select dropdown transport field and select bz value
	public void selectTransport(String value) {
		Select transport = new Select(wd.findElement(By.xpath(TRANSPORT)));
		transport.selectByValue(value);
	}

	// get description field
	public WebElement getDescriptionField() {
		WebElement driver = wd.findElement(By.xpath(DESCRIPTION));
		return driver;
	}

	// click description field
	public void clickDescriptionField() {
		getDescriptionField().click();
	}

	// set value to description field
	public void setDescriptionField(String str) {
		getDescriptionField().sendKeys(str);
	}

	// get post Button
	public WebElement getPostButton() {
		return wd.findElement(By.xpath(POST_BTN));
	}

	// click post Button
	public void clickPostButton() {
		getPostButton().click();
	}

	public void deletePost(int n) {
		// first we click on the three dots to expand the link
		wd.findElements(By.className(THREE_DOTS_CLASS_NAME)).get(n).click();
		// after that we click on the delete icon
		WebElement element = wd.findElements(By.className(DELETE_CLASS_NAME)).get(n);
		if (element != null) {
			element.click();
		}
	}

	public void clickEdit(int n) {
		// first we click on the three dots to expand the link
		wd.findElements(By.className(THREE_DOTS_CLASS_NAME)).get(n).click();
		// after that we click on the edit icon
		WebElement element = wd.findElements(By.className(EDIT_CLASS_NAME)).get(n);
		if (element != null) {
			element.click();
		}
	}

	public WebElement getChangeImage() {
		return wd.findElement(By.id(CHANGE_IMAGE));
	}

	public void setChangeImage() {
		getChangeImage().sendKeys(CHANGED_IMAGE_PATH);
	}

	// get edit post submit button
	public WebElement getEditPostButton() {
		return wd.findElement(By.xpath(EDIT_POST_BTN));
	}

	// click edit post button
	public void clickEditPostButton() {
		getEditPostButton().click();
	}
}
