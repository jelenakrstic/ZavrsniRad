package zavrsnirad.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public static final String PAGE_URL = "http://localhost/izlet/izlet/index.php";

	public static WebElement getRegisterLink(WebDriver driver) {
		WebElement wb = driver.findElement(By.xpath(""));
		return wb;
	}

}
