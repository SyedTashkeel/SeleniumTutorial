package SeleniumTestPackage.TestNGListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners(ListenerTest.class)

public class TestCaseTestNGListeners {
	
	public WebDriver driver;
	
	@Test
	public void login() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.edureka.co/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#search-input")).sendKeys("Test Automation Engineer Masters Program");
		driver.findElement(By.className("search_input_result")).click();
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
	}

	// Forcefully fail the test
	
	@Test
	public void TestToFail() {
		
		System.out.println("This test is to fail");
		Assert.assertTrue(false);
		
	}
}
