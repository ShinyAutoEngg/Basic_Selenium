package websitesPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart_pageClicksAndConfirmProducts 
{
	@Test
	public void demoWithNextSetOfPages() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone 15",Keys.ENTER);
		List<WebElement> listOfPhones = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		int noOfPhones=listOfPhones.size();
		int sum=noOfPhones;
		System.out.println(noOfPhones);
		while(true)
		{
			try
			{
		driver.findElement(By.xpath("//a[@class='_9QVEpD' and .='Next']")).click();
		Thread.sleep(4000);
		int phonesInEachPageList = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).size();
		sum=sum+phonesInEachPageList;
		
			}
			catch(Exception e)
			{
				break;
			}
		}
		

		System.out.println(sum);

	}
	
	
	@Test
	public void withoutNextSetOfPages() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone 15 pro",Keys.ENTER);
		List<WebElement> listOfPhones = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		int noOfPhones=listOfPhones.size();
		int sum=noOfPhones;
		System.out.println(noOfPhones);
		List<WebElement> noOfPages = driver.findElements(By.xpath("//a[@class='cn++Ap']"));
		System.out.println(noOfPages.size());
		for(WebElement e : noOfPages)
		{
			
			e.click();
			Thread.sleep(3000);
			int page = driver.findElements(By.xpath("//div[@class='KzDlHZ']")).size();
			sum=sum+page;
		}
		
		System.out.println(sum);
	}
}
