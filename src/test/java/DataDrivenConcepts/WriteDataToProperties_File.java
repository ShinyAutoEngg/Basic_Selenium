package DataDrivenConcepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataToProperties_File {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		prop.setProperty("username", "admin");
		prop.setProperty("password", "admin");
		prop.setProperty("browser", "chrome");
		prop.setProperty("url", "http://localhost:8888");
		
		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "/src/test/resources/commonData.properties");
		prop.store(fout, "common data");
		fout.close();
		
		System.out.println("data written successfully");
		
		
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/commonData.properties");
		prop.load(fin);
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url =prop.getProperty("url");
		String browser = prop.getProperty("browser");
		
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
	    driver.findElement(By.name("user_name")).sendKeys(username);
		//enter the password
		driver.findElement(By.name("user_password")).sendKeys(password);
		//click on submit button
		driver.findElement(By.id("submitButton")).click();

	}

}
