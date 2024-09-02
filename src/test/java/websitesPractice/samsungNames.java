package websitesPractice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class samsungNames 
{
	
	
	@Test
	public void samsung() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Samsung",Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'Samsung Galaxy')]"));
		for(WebElement e : list)
		{
			String name=e.getText();
			System.out.println(name);
		}
	}
}
