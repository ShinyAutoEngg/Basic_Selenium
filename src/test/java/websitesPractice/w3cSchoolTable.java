package websitesPractice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class w3cSchoolTable 
{
	@Test
	public void main()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		String company="Island Trading";
		String country=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[contains(.,'"+company+"')]/td[3]")).getText();
		System.out.println(company+" : "+country);
	}
}
