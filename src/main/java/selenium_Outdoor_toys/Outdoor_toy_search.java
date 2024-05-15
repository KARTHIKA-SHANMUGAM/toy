package selenium_Outdoor_toys;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Outdoor_toy_search {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\2317582\\eclipse-workspace\\selenium_example\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.ebay.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.linkText("Advanced")).click();

		driver.findElement(By.id("_nkw")).sendKeys("outdoor toys");

		WebElement element_1 = driver.findElement(By.name("_in_kw"));
		Select select_1 = new Select(element_1);
		select_1.selectByVisibleText("Any words, any order");

		WebElement dropdownCategory = driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat"));
		Select selectCategory = new Select(dropdownCategory);
		selectCategory.selectByVisibleText("Toys & Hobbies");

		driver.findElement(By.name("LH_TitleDesc")).click();

		driver.findElement(By.name("s0-1-17-6[4]")).click();

		driver.findElement(By.name("LH_FR")).click();

		driver.findElement(By.name("LH_RPA")).click();

		driver.findElement(By.name("s0-1-17-6[7]")).click();

		driver.findElement(By.xpath("//button[contains(text(), 'Search')]")).click();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			String href = link.getAttribute("href");
			String text = link.getText();
			if (text.toLowerCase().contains("toys")) {
				System.out.println("Item: " + text + ", Link: " + href);
			}
		}

		driver.quit();
	}
}
