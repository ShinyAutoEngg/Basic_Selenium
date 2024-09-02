package websitesPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorPractice 
{
	@Test
	public void allJavaScriptExecutor() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.location='https://www.icc-cricket.com/rankings'");
		jse.executeScript("location.reload()");
		WebElement about = driver.findElement(By.xpath("//a[.='about' and @aria-label='about' and @data-id=\"42cd0b59-0041-4453-83b8-f3053c7c1a3b\"]"));
		jse.executeScript("arguments[0].scrollIntoView(true);",about);
		jse.executeScript("arguments[0].click();",about);
		String docTitle=jse.executeScript("return document.title;").toString();
		String docURL=jse.executeScript("return document.URL;").toString();
		System.out.println(docTitle+" | "+docURL);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Accept All Cookies']")).click();
		jse.executeScript("0,document.body.scrollHeight"); //not working
		WebElement img = driver.findElement(By.xpath("//img[@src='https://images.icc-cricket.com/image/private/t_w_180/v1705588073/prd/assets/sponsors/5-T1-Emirates_dfab1b.png']"));
		jse.executeScript("arguments[0].scrollIntoView(true);",img);
		Thread.sleep(2000);
		boolean isBroken = (boolean)jse.executeScript("return arguments[0].naturalWidth===0 && arguments[0].naturalHeight===0;",img);
		if(isBroken==true)
		{
			System.out.println("Image is broken");
		}
		else
		{
			System.out.println("Image is not broken");
		}
	}
}
