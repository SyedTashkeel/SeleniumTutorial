package SeleniumTestPackage.WebDriverITest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		//Initiate EventFiringWebDriver
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		//Initiate EventCapture (class)
		EventCapture eCapture = new EventCapture();
		// Register EventCapture with EventFiringWebDriver
		// Register method will allow implementation of WebDriver EventListerners 
		
		eventHandler.register(eCapture);
		eventHandler.navigate().to("https://www.yahoo.com/");
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		
		eventHandler.manage().window().maximize();
		
		eventHandler.findElement(By.linkText("Sign in")).click();
		eventHandler.navigate().to("https://www.edureka.co/");
		eventHandler.navigate().back();
		
		eventHandler.quit();
		//unregister eCapture to detach
		eventHandler.unregister(eCapture);
		
		System.out.println("End of listerners class");
		
	}

}
