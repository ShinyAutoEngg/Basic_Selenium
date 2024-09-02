package websitesPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicMedals
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://olympics.com/en/paris-2024/medals");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		Thread.sleep(4000);
		String name="Australia";
		WebElement posEle=driver.findElement(By.xpath("//span[text()='India']/parent::div/following-sibling::span[@class='e1oix8v91 emotion-srm-5nhv3o']"));
		String pos=posEle.getText();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", posEle);
		driver.findElement(By.xpath(""));
		System.out.println(pos);
	}
}
