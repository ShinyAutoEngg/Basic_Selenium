package websitesPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon_getPriceOfAMobile 
{
	@Test
	public void getPriceOfAMobile()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.get("https://www.amazon.in/");
		WebElement list = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Select sel= new Select(list);
		List<WebElement> opt = sel.getOptions();
		for(WebElement e:opt)
		{
			System.out.println(e.getText());
		}
		boolean isMul=sel.isMultiple();
		System.out.println("Muliple Select :"+isMul);
		sel.selectByVisibleText("Baby");
		sel.selectByIndex(5);
		WebElement submitIcon = driver.findElement(By.xpath("//input[@type='submit']"));
		Actions act = new Actions(driver);
		act.moveToElement(submitIcon).click().perform();
		WebElement radio = driver.findElement(By.xpath("//span[.='Bajaj' and @class='a-size-base a-color-base']/ancestor::li/descendant::i"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(radio));
		radio.click();
		List<WebElement> bajajList = driver.findElements(By.xpath("//span[contains(.,'Bajaj') and @class='a-size-base-plus a-color-base a-text-normal']"));
		for(WebElement ele : bajajList)
		{
			System.out.println(ele.getText());
		}
		
		String price=driver.findElement(By.xpath("//span[.='Bajaj Immersion 1500 Watts Water Heater Rod | Nickel Plated Heating| ISI Certified | 2 Years Warranty | Silver']/ancestor::div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']/descendant::span[@class='a-price-whole']")).getText();
		System.out.println(price);
	}

}
