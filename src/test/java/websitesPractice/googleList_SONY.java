package websitesPractice;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class googleList_SONY
{
	@Test
	public void mtd() throws InterruptedException
	{
		TreeSet<String> ts = new TreeSet<>();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com/");
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Shiny");
		Thread.sleep(3000);
		List<WebElement> listOfNames = driver.findElements(By.xpath("//li[@class='sbct PZPZlf']"));
		for(WebElement e: listOfNames)
		{
			String name=e.getText();
			ts.add(name);
			
		}
		System.out.println(ts);
		int i=0;
		String[] s = new String[ts.size()];
		for(String n : ts)
		{
			s[i++]=n;
		}
		System.out.println(s[2]);
		
		for(WebElement ele : listOfNames)
		{
			if(ele.getText().equals(s[2]))
			{
				ele.click();
				break;
			}
		}

	}
}
