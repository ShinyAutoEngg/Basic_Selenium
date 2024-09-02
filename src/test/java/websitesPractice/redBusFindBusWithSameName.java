package websitesPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class redBusFindBusWithSameName 
{
	@Test
	public void redbus() throws InterruptedException
	{
		
		//driver.findElement(By.xpath(""));
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
		//driver.findElement(By.xpath("//label[.='From']")).click();
		driver.findElement(By.xpath("//div[@class='sc-ifAKCX kPhbmx' and contains(.,'From')]/descendant::input[@type='text']")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sc-gZMcBi hviMLb']/descendant::text[.='Koyambedu']")).click();
		driver.findElement(By.xpath("//div[@class='sc-ifAKCX kPhbmx' and contains(.,'To')]/descendant::input[@type='text']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[@class='sc-gZMcBi hviMLb']/descendant::text[.='Madiwala']")).click();
		driver.findElement(By.xpath("//div[@id='onwardCal']//i")).click();
		String month=driver.findElement(By.xpath("//div[@class='sc-jzJRlG hrJoeL']/descendant::div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD' and @style='flex-grow: 2; font-size: 0.875rem;']")).getText();
		System.out.println(month);
		while(true)
		{
			driver.findElement(By.xpath("//div[@class='sc-jzJRlG hrJoeL']/descendant::div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD' and @style='flex-grow: 2; font-size: 0.875rem;']/following-sibling::div[@class=\"DayNavigator__IconBlock-qj8jdz-2 iZpveD\"]//*[name()='svg']")).click();
			Thread.sleep(2000);
			if(month.contains("Nov 2024"))
			{
				break;
			}
		}
	}
}
