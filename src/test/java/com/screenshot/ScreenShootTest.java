package com.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.Takescreenshot;

public class ScreenShootTest {
	
	  WebDriver driver;
	 
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\neosphere\\eclipse-workspace\\first_project\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

}
	@Test
	public void testcase1() 
	{
		driver.findElement(By.name("q")).sendKeys("Screenshotdemo");
		Assert.assertTrue(true);
		
		//Takescreenshot.takescreenshot(driver, "screen1");
	}
	
	@Test
	public void testcase2() 
	{
		//driver.findElement(By.name("q")).sendKeys("Screenshotdemo");
		
		//Takescreenshot.takescreenshot(driver, "screen2");
		Assert.assertTrue(false);
	}
	
	@AfterMethod
	public void teardown(ITestResult result) 
	{
		
		if(result.FAILURE==result.getStatus())
		{
			
			Takescreenshot.takescreenshot(driver, result.getName());
		}
		driver.close();
		
	}
}
