package SeleniumGRID;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GRID_edge 
{
	
	@Test
	public void edge() throws MalformedURLException, URISyntaxException 
	{
		URL url = new URL("http://172.16.16.180:4444");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("MicrosoftEdge");
		cap.setPlatform(Platform.WINDOWS);
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("https://www.google.co.in/");
	}
}
