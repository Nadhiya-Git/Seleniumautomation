package PageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class customercration {
    WebDriver driver;
    WebDriverWait wait;

    public customercration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='button' and @aria-label='Customer 360']")
    public WebElement customer360;

    @FindBy(xpath = "//span[@class='ci-customer']")
    public WebElement customer;

    @FindBy(xpath = "//img[@aria-label='Add Customer']")
    public WebElement addcustomer;

    @FindBy(xpath = "//input[@name='Customer Name']")
    public WebElement customername;

    @FindBy(xpath = "//label[@data-attr='Customer Type']")
    public WebElement customertype;

    @FindBy(xpath = "//button[@actionid='90050771005081']")
    public WebElement save;

    public void customercreatyonmethod() {
        // Wait explicitly for each element before interacting
        wait.until(ExpectedConditions.elementToBeClickable(customer360)).click();
        wait.until(ExpectedConditions.elementToBeClickable(customer)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addcustomer)).click();
        
        wait.until(ExpectedConditions.visibilityOf(customername)).sendKeys("Martin");
        
        // Handle custom dropdown (click element -> click option)
        wait.until(ExpectedConditions.elementToBeClickable(customertype)).click();
        WebElement option = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Small and Medium Size Business']"))
        );
        option.click();

        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    }
}