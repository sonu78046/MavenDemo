package Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class google {
	public WebDriver driver;
	public void launchurl(String config) throws IOException {
		Properties prop=new Properties();
		try {
			FileInputStream ip= new FileInputStream(config);
			prop.load(ip);
			String path=prop.getProperty("chromeDriverPath");
			String Url=prop.getProperty("url");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			System.setProperty("webdriver.chrome.driver","chromeDriverPath");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(Url);
		} 
		catch(Exception e)
		{
			
		}
	}
	
		
	public String verifyTitle(){
		return driver.getTitle();
  }
  public String verifygmailtext() {
	  String text=driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).getText();
	  return text;
	  
  }
  public void closeBrowser() {
	  driver.close();
  }

}
