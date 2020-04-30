package Automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	google get=new google();
	
  @BeforeTest
  public void chrome() throws IOException {
		//String Driverpath=prop.getProperty();
  get.launchurl("./config.properties");
  }

	
	  @Test(expectedExceptions= {Exception.class}) 
	  public void getexception() throws IOException {
	  get.launchurl("./config.properties"); 
	  }
	 
  @Test
  public void verifyTitle() {
	  String expectedTitle="Google";
	 String Title=get.verifyTitle();
	 System.out.println(Title);
	 Assert.assertEquals(Title, expectedTitle,"Title testcase");
  }
  
  @Test
  public void verifygmailtext() {
	  String expectedTitle="Gmail";
	  String gtext=get.verifygmailtext();
	  Assert.assertEquals(gtext, expectedTitle,"text textcase");
  }
  @AfterTest
  public void quite() {
	  get.closeBrowser();  
  }
}
