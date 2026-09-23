	package PageObject;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class DriverManagerClass {
	
	public  Properties probs;
	
	public static WebDriver  driver;
	
	protected DriverManagerClass() throws IOException{
	
		probs=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\NadhiyaSubramani\\eclipse-workspace\\Selenium\\src\\main\\java\\PageObject\\Confiure");
		probs.load(fs);
		System.out.println("Loaded properties: " + probs.size());
		System.out.println("username value: " + probs.getProperty("username"));
	}
	
	public void driverinilization() {
		
		Driverclass.setdriverinstance();
	 driver=Driverclass.getDriver();
	 driver.manage().window().maximize();
	}
	
	public static void screenshot() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des=new File("D:/Automationscreenshots"+"_"+System.currentTimeMillis()+".png");
				FileUtils.copyFile(src, des);
	}
}
