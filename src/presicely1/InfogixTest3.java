package presicely1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InfogixTest3 {


	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		driver.get("https://www.infogix.com"); // Entering into the Infogix Home Page
		driver.manage().window().maximize(); // Maximizing the browser window


		driver.findElement(By.id("menu-item-9950")).click(); // Clicking on "contact" in the menu item.
		driver.findElement(By.name("FirstName")).sendKeys("Aneesh"); // Filling the form with the details provided
		driver.findElement(By.id("LastName")).sendKeys("Aneesh");
		driver.findElement(By.id("Company")).sendKeys("Infogix");
		driver.findElement(By.id("Email")).sendKeys("aneesh1234@gmail.com");
		driver.findElement(By.id("Phone")).sendKeys("0123456789");

		WebElement countryselect=driver.findElement(By.id("HQ_Location_Country__c")); // Selecting the country from the drop down
		Select country= new Select(countryselect);
		country.selectByVisibleText("United States");

		WebElement industry=driver.findElement(By.id("Industry__c")); // selecting the Industry from the drop down
		Select Ind= new Select(industry);
		Ind.selectByVisibleText("Media & Communication");		

		WebElement textInput=driver.findElement(By.id("Next_Step_Comments__c")); // Entering the text sentence in the text box
		textInput.sendKeys("This is a coding challenge for Test Automation position. Please disregard this message");

		driver.findElement(By.xpath("//*[@id='LblConsent_to_Processing__c']")).click(); // Clicking on the accept/reject box

		driver.findElement(By.xpath("//button[@type='submit']")).click(); // Clicking on the submit button


		Thread.sleep(2000); // wait for 2 seconds to get the fully loaded new page.

		WebElement t=driver.findElement(By.xpath("//*[text()='Thank You!']"));// Locating the Thank You element in the page
		System.out.println(t.getText()); // Thank You Message is verified in the final page.
		System.out.println("Test successfully passed and verified Thank You Message!");


	}
}
