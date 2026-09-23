package PageObject;


import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Loginpage{

	 WebDriver driver;
	    Properties probs;
	@FindBy(id="username")
	public WebElement username;
	@FindBy(id="password")
	public WebElement passowrd;
	@FindBy(id="submitBtn")
	public WebElement login;
	  public Loginpage(WebDriver driver, Properties probs) {
	        this.driver = driver;
	        this.probs = probs;
	        PageFactory.initElements(driver, this);
	    }
		    public void loginfunction(String username1,String password1) throws InterruptedException, IOException {
		    	
		    	
		    	driver.get(probs.getProperty("url"));
		    Thread.sleep(2000);
		        username.sendKeys(username1);
		        passowrd.sendKeys(password1);
		        login.click();
		        DriverManagerClass.screenshot();		
		    }
		
		
	}


