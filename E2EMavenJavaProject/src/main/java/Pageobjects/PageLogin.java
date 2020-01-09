package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogin {
public WebDriver driver;

public PageLogin(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver = driver;
}

public WebElement getEmail()
{
	return driver.findElement(By.id("user_email"));
}

public WebElement getPassword()
{
	return driver.findElement(By.id("user_password"));
}
public WebElement Login()
{
	return driver.findElement(By.xpath("//input[contains(@class,'login-button')]"));
}
}
