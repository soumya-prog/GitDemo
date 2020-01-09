package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Baseclass {
	public  static WebDriver driver;
	public Properties prop;
		public  WebDriver initializeDriver() throws IOException, InterruptedException
		{
		 prop = new Properties();
		 //System.getProperty("user.dir");
		 //"C:\\Users\\Pavankumar\\eclipse-workspace\\E2EMavenJavaProject = System.getProperty("user.dir")
		 // to avoid hard coded path in framework
		 System.out.println("before reading data properties");
			//FileInputStream fis= new FileInputStream(System.getProperty("C:\\Users\\Pavankumar\\eclipse-workspace\\E2EMavenJavaProject\\src\\main\\java\\Resources\\datadriven.properties"));
			System.out.println("after reading data properties");
			//prop.load(fis);
			//mvn test -Dbrowser=chrome
			String browsername="chrome";//prop.getProperty("browser");
			//String browsername = System.getProperty("browser");
			// instead of selecting the browser from dataproperties file we can do it from Maven Jenkins integration
			if(browsername.equals("chrome"))
			{
				System.out.println("hello");
				System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver");
				/*ChromeOptions options = new ChromeOptions();
				if(browsername.contains("headless"))
					// headless means no browser will open while testing
					options.addArguments("headless");
				driver = new ChromeDriver(options);*/
				driver = new ChromeDriver();
				System.out.println(browsername);
			
			}
			else if(browsername.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browsername.equals("IE"))
			{
				//IE code
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return driver;
		}
		public void getscreenshot() throws IOException, InterruptedException
		{
			//driver =initializeDriver();
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String ts= timestamp.toString().replace("-", "").replace(":","").replace("\\s","");
		FileHandler.copy(src, new File("C://Screenshot_error//screenshot"+ts+".png"));

		//driver = null;
		}
}
