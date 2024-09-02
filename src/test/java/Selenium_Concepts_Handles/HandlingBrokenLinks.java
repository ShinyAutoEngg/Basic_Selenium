package Selenium_Concepts_Handles;

import java.net.URL;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingBrokenLinks 
{
	@Test
	public void brokenLinks() throws URISyntaxException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://106.51.90.215/Build/Online_Shopping_System/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		for(WebElement eachLink : allLinks)
		{
			String link=eachLink.getAttribute("href");
			URL url = new URI(link).toURL();
			HttpURLConnection huc= (HttpURLConnection)url.openConnection();
			int code=huc.getResponseCode();
			if(code>300)
			{
				System.out.println(link+ " : is broken");
			}
//			else
//			{
//				System.out.println(link+ " : is not broken");
//			}
		}
	}
}
