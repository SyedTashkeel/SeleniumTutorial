package SeleniumTestPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAndAlerts {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	//	driver.get("https://login.yahoo.com/");
	//	driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("sadat_tashkeel");
	//	Thread.sleep(3000);
	//	driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		driver.get("https://login.yahoo.com/account/create/");
		
		WebElement firstname= driver.findElement(By.id("usernamereg-firstName"));
		WebElement lastname= driver.findElement(By.id("usernamereg-lastName"));
		WebElement signin= driver.findElement(By.linkText("Sign in"));
		
		sendKeys(driver,firstname,30,"Tashkeel");
		sendKeys(driver,lastname,30,"Syed");
		clickOn(driver,signin,30);
		
		// Alert Types - Simple, Prompt & Confirmation Alerts
		
		WebElement login= driver.findElement(By.id("login-signin"));
		clickOn(driver,login,30);
		
		Alert alert = driver.switchTo().alert();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(3000);
		alert.accept();
		
		//Pop-up embedded window
		
		WebElement pop= driver.findElement(By.id("pop-up"));
		clickOn(driver,pop,30);
		Robot robot = new Robot();
		robot.mouseMove(400, 5);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		
		driver.quit();
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
