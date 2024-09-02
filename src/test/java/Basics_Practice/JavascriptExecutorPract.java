package Basics_Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutionJob;

public class JavascriptExecutorPract
{
	@Test
	public void demoForJSE() throws AWTException
	{ 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location='https://www.google.com/'");
		WebElement searchBar = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		//searchBar.click();
		//jse.executeScript("arguments[0].setAttribute('value','selenium')",searchBar);
		jse.executeScript("document.getElementById('APjFqb').value='selenium'");
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[@class='aajZCb']/descendant::li[@class='sbct PZPZlf' and contains(.,' ide for chrome')]")).click();
	}
	
	
	@Test
	public void amazon() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		WebElement ke = driver.findElement(By.xpath("//a[@aria-label='Kitchen essentails']/descendant::span[.='Kitchen essentails']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", ke);
//		Point kePoints = ke.getLocation();
//		int x=kePoints.getX();
//		int y=kePoints.getY();
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy("+x+","+y+")");
		Thread.sleep(6000);
		ke.click();
	}
	
	@Test
	public void amazon2() throws Throwable
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		WebElement alldd = driver.findElement(By.xpath("//select[@id=\"searchDropdownBox\"]"));
		Actions act=new Actions(driver);
		act.moveToElement(alldd).click().perform();
		Select sel=new Select(alldd);
		//sel.selectByIndex(5);
		//sel.selectByValue("abc");
		//sel.selectByVisibleText("amazon");
       	//sel.getAllSelectedOptions();
		boolean optMultiple=sel.isMultiple();
		if(optMultiple==true)
		{
			System.out.println("IT is multiple");
		}
		else
		{
			System.out.println("Not multiple");
		}
			List<WebElement> allOps = sel.getOptions();
		  for(WebElement e : allOps)
		  {
			  System.out.println(e.getText());
		  }
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		//	wait.until(ExpectedConditions.visibilityOf(ke));
			wait.until(ExpectedConditions.visibilityOfAllElements(allOps));
			//wait.until(ExpectedConditions.);
		  
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-none']//span[.='Pigeon']/parent::a/descendant::label")).click();
	}
	
	@Test
	public void amazon3() throws Throwable
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone",Keys.ENTER);
		String parentWin=driver.getWindowHandle();
		driver.findElement(By.xpath("//span[.='Apple iPhone 13 (128GB) - Starlight']")).click();
		String partialTitle="Apple-iPhone-13-128GB-Starlight";
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> it=wins.iterator();
		while(it.hasNext())
		{
			String winID=it.next();
			driver.switchTo().window(winID);
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle))
			{
				break;
			}
		}
		driver.switchTo().window(parentWin);
	}
}
