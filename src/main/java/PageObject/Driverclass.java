package PageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driverclass {
	public static ThreadLocal< RemoteWebDriver> driver=new ThreadLocal<>();
	
	public static void setdriverinstance() {
		
		driver.set(new ChromeDriver());
	}
	public static WebDriver getDriver() {
	    return driver.get();
	}

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }}
}
