package Testing;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobjects.LandingPage;
import Pageobjects.PageLogin;
import Resources.Baseclass;

public class Homepage extends Baseclass {
	public static Logger log =LogManager.getLogger(Baseclass.class.getName());
	public WebDriver driver;//by putting static another class wont modify the current object
	@Test(dataProvider="a")
	public void basepageNavigation(String username,String password) throws IOException, InterruptedException
	{  
		System.out.println("before initialize driver");
		driver =initializeDriver();
		//System.out.println(LogManager.getLogger(Baseclass.class.getName()));
		log.info("driver is initialized");
		//driver.get("http://www.qaclickacademy.com/");
	 driver.get(prop.getProperty("http://qaclickacademy.com"));
	  driver.manage().window().maximize();
	  log.info("Navigated to home page");
	  LandingPage pd = new LandingPage(driver);
	  pd.popup().click();
	  pd.getlogin().click();
	  PageLogin pl = new PageLogin(driver);
	  pl.getEmail().sendKeys(username);
	  pl.getPassword().sendKeys(password);
	  pl.Login().click();
	  log.info("login page is successfully run");
	}
	@DataProvider(name="a")
	public Object[][] getdata()
	 {
	  Object[][] a = new Object[2][2];
	  a[0][0]="username1";
	  a[0][1]="password1";
	  a[1][0]="username2";
	  a[1][1]="password2";
	  return a;
	  
}


	@AfterMethod()
	public void close()
	{
		driver.close();
		driver = null;
	}
}
