package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
private	By name =By.xpath("//button[contains(text(),'NO THANKS')]");
private	By name1 =By.cssSelector("a[href*='sign_in']");
private By name3 = By.xpath("//div[contains(@class,'video-banner')]/h3");
public WebDriver driver;
	public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver = driver;
}
	public WebElement popup() 
	{
		return driver.findElement(name);
	}
	public WebElement getlogin()
	{
		return driver.findElement(name1);
	}
	public WebElement gettitle()
	{
		return driver.findElement(By.xpath("//h2[contains(text(),'Featured Courses')]"));
	}
	public  WebElement navigationbar()
	{
		return driver.findElement(By.xpath("//ul[contains(@class,'navbar-right')]"));
	}
	public WebElement validtext()
	{
		return driver.findElement(By.xpath("//h2[contains(text(),'Featured Courses')]"));
	}
	public WebElement validtitle()
	{
		return driver.findElement(name3);
	}
}

