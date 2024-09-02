package websitesPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class w3cSchoolWebTable
{
	@Test
	public void samsung() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement dd=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	
		Select sel = new Select(dd);
		sel.selectByIndex(3);
		//System.out.println();
		 List<WebElement> allList = sel.getAllSelectedOptions();
		 wait.until(ExpectedConditions.visibilityOfAllElements(allList));
		 for(WebElement a: allList)
		 {
			 System.out.println(a.getText());
		 }
	}
	
	
	@Test
	public void m1()
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='w3-white w3-padding notranslate w3-padding-16']/descendant::tbody/tr[*]/td"));
		for(WebElement w: list)
		{
				String value = w.getText();
				if(value.contains("Roland Mendel"))
				{
					System.out.println("Name is :"+value);
				}
		}
	}
}
