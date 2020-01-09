package Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import Resources.Baseclass;

public class Assetvalidation extends Baseclass {
	public static Logger log =LogManager.getLogger(Baseclass.class.getName());
	LandingPage lp;
	public WebDriver driver;
	@BeforeTest()
	public void initializebrowser() throws IOException, InterruptedException
	{
		driver =initializeDriver();
		//driver.get("http://www.qaclickacademy.com/");
		log.info("driver is initialized at Assertions");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page at Assertions");
		driver.manage().window().maximize();
		
	}
@Test
public void  Assertions() throws IOException
{
	
lp=new LandingPage(driver);
	//lp.validtext();
	//log.error("error has occured");
	Assert.assertEquals(lp.validtext().getText(), "FEATURED COURSES");
	
	lp.navigationbar();
	Assert.assertTrue(lp.navigationbar().isDisplayed());
	log.info("Successfully validated text message");
	
}
@Test
public void validatingtext()
{
	//LandingPage ll = new LandingPage(driver);
	Assert.assertEquals(lp.validtitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	//log.info("Successfully validated text message");
}
	@AfterTest()
	public void closebrowser() throws InterruptedException
	{
		//Thread.sleep(3000);
		driver.close();
		driver = null;
	}
}
