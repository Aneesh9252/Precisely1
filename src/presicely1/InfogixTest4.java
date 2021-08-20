package presicely1;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class InfogixTest4 {

	private static final boolean False = false;

	@Test
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://www.infogix.com"); // Entering into the page
		driver.manage().window().maximize(); // maximizing the window

		driver.findElement(By.xpath("html/body/div[1]/header/div/nav[1]/a")).click(); // click on the search 
		driver.findElement(By.name("s")).sendKeys("Govern"); // type the search item in the text box
		driver.findElement(By.name("s")).submit(); // submit the search item

		driver.navigate().to("https://www.infogix.com/page/2/?s=Govern"); // navigate to the page where the element present

		JavascriptExecutor js= (JavascriptExecutor)driver; // scroll down to the area where the element resides
		js.executeScript("window.scrollBy(0,550)","");

		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div/ul/li[5]/div/div/h4/a")).click(); // click on the element "Building Data Trust with Strategic Data Governance"

		String expectedUrl="https://www.infogix.com/solutions/regulatory-compliance/ "; // Expected URL
		System.out.println("Expected URL is:"+expectedUrl); // Printing the Expected URL

		WebElement link=  driver.findElement(By.linkText("regulatory compliance")); 
		String href = link.getAttribute("href");// The link mentioned in the source code
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); // wait
		System.out.println("The of the Link is: " +href);
		link.click();// click the link and mentioned in the code

		Thread.sleep(5000);

		driver.navigate().to(expectedUrl);// navigate to the new page
		String newPageUrl=driver.getCurrentUrl();
		System.out.println("Actual URL shown:"+newPageUrl);// Actual URL showing in the redirected page

		Assert.assertFalse(false, expectedUrl);

		System.out.println("URL Mismatch");


		Thread.sleep(5000);

		driver.quit();// close all windows


	}


}





