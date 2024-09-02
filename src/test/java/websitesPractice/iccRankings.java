package websitesPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iccRankings 
{
	@Test
	public void findRank() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.get("https://www.icc-cricket.com/rankings");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[.='Accept All Cookies']")).click();
		String rank=driver.findElement(By.xpath("//div[@class='si-table swiper-slide' and contains(.,'team Rankings') and contains(.,'test ')]/descendant::span[.='India']/ancestor::div[@class='si-table-row']/div[@class='si-table-data si-pos']/span[@class='si-text']")).getText();
		System.out.println(rank);
		WebElement videos = driver.findElement(By.xpath("//a[.='videos' and @aria-label='videos' and @data-id='4a43df0d-fcbb-4b2a-ab47-a4f0e32f4c5d']"));
		String value=videos.getAttribute("text");
		System.out.println(value);
		Dimension size = videos.getSize(); 
		
	}
}
