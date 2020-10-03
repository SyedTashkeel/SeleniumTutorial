package SeleniumTestPackage.TestNGListener;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserTest {
	
	public WebDriver driver;
	
	/** This function will execute before each test tag in testng.xml
	 *  @param
	 *  @browser
	 */
	
	@BeforeTest
	@Parameters("browser")
		public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'Chrome'
		if(browser.equalsIgnoreCase("chrome")) {
			//create chrome instance
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("edge")) {
			//create Edge instance
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			}
		else {
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
		}
	@Test
		public void testParameterWithXML() throws InterruptedException{
		
		driver.get("https://www.yahoo.com/");
		Thread.sleep(3000);
		WebElement signin= driver.findElement(By.className("_yb_17s9m"));
		signin.click();
		Thread.sleep(3000);
	}
		
	}
