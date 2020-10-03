package SeleniumTestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenuimWebElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// CSS Selector
		
		driver.get("https://www.ebay.com/");
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#gh-ac")).sendKeys("lexmark printer");
		Thread.sleep(3000);
		
		driver.findElement(By.id("gh-btn")).click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		//Partial value relative xPath using contains
		
		driver.findElement(By.xpath("//span[contains(text(),'LED')]")).click();
		
		//Changing value relative xPath using starts With
		
		WebElement productImg = driver.findElement(By.xpath("//img[starts-with(@class,'s-item__image')]"));
		productImg.click();
		
		//xPath for text identification
		
		driver.findElement(By.xpath("//text(),'Category'"));
		
		/*driver.get("https://www.amazon.com/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		Thread.sleep(3000);
		
		driver.findElement(By.className("nav-input")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Apple")).click();
		Thread.sleep(3000); */
		
						
		//driver.navigate().to("https://acloudguru.com/");
		//Thread.sleep(3000);
		
		//driver.navigate().back();
		
		//driver.quit();
		
		}

}
