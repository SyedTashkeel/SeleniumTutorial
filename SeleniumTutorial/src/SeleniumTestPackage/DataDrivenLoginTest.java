package SeleniumTestPackage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLoginTest {

	WebDriver driver;
	
	@Test(dataProvider="dataInputValue") 	
	public void yahooSignUp(String firstname, String lastname) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://login.yahoo.com/account/create/");
		
		WebElement fName = driver.findElement(By.id("usernamereg-firstName"));
		WebElement lName = driver.findElement(By.id("usernamereg-lastName"));
		WebElement signin= driver.findElement(By.linkText("Sign in"));
		
		sendKeys(driver,fName,30,firstname);
		sendKeys(driver,lName,30,lastname);
		clickOn(driver,signin,30);
		
		System.out.println(firstname);
		System.out.println(lastname);
		
		Assert.assertEquals("Sign", "Sign");
		
		driver.quit();
	}

	@DataProvider(name="dataInputValue")
	public Object[][] dataInput() {
		
		Object[][] data= new Object[3][2];
		
		//Since we are specifying 3 row and 2 columns, passing below array values
		data[0][0] = "Admin";
		data[0][1] = "(1)23456";
		
		data[1][0] = "Admin1";
		data[1][1] = "1(2)3456";
		
		data[2][0] = "Admin2";
		data[2][1] = "12(3)456";
		
		return data;
	}
	
	// Explicit wait methods for text SendKeys & button Click
	
	public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value) {
		
		new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver1, WebElement element, int timeout) {
		
		new WebDriverWait(driver1,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
}
	