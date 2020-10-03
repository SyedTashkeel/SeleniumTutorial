package SeleniumTestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptionhandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");	
		Thread.sleep(3000);
		
		try{
			driver.findElement(By.name("fake")).click();
		
		}catch (NoSuchElementException e)
			{
			System.out.println("No such element found");
			System.out.println("Hello WebElement");
			
			//Throw detailed exception
			//throw(e);
		}
		try{
			driver.switchTo().alert().accept();
		
		}catch (NoAlertPresentException e)
			{
			System.out.println("No Alert Present Exception");
			System.out.println("Hello Alert");
			
			//Print detailed exception
			//e.printStackTrace();
			
			}
		
		try{
			driver.switchTo().window("fake");
		
		}catch (NoSuchWindowException e)
			{
			System.out.println("No Window Exception");
			System.out.println("Hello Window");
						
			}
		
		try{
			driver.switchTo().frame("fake");
		
		}catch (NoSuchFrameException e)
			{
			System.out.println("No Frame Exception");
			System.out.println("Hello Frame");
						
			}
		System.out.println("Hello Exceptions Tutorial");
	
	}
	
}
