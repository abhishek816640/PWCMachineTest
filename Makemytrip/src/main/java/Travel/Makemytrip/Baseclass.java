package Travel.Makemytrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baseclass {
	
	public WebDriver driver;
	
	  public Baseclass(){
		  System.setProperty("webdriver.chrome.driver","C://TestAutomation//PageObjectModel//drivers//chromedriver.exe");
	    driver = new ChromeDriver();
	    //System.setProperty("webdriver.chrome.driver","C://TestAutomation//PageObjectModel//drivers//chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  }
	  
	  
	  
	  public void searchflight(String From,String To)
	  {
		  
		  driver.get("https://www.makemytrip.com/");
		  driver.manage().window().maximize();
		 WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
		  WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		  WebElement departuredate =driver.findElement(By.xpath("((//div[@class='DayPicker-Week'])[5]//div[@class='DayPicker-Day'])[7]"));
		  WebElement buttonSearch = driver.findElement(By.xpath("//a[text()='Search']"));
		  driver.findElement(By.xpath("//label[@for=\"fromCity\"]")).click();
		  from.sendKeys(From);
		  driver.findElement(By.xpath("//label[@for=\"toCity\"]")).click();
		  destination.sendKeys(To);
		  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		  departuredate.click();
		  buttonSearch.click();
		  
		  
	  }
	  
	  public void getflightdetails()
	  {
		  WebDriverWait wait = new WebDriverWait(driver,5);
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[text()='View Prices'])[1]//ancestor::button"))));
		  driver.findElement(By.xpath("(//span[text()='View Prices'])[1]//ancestor::button")).click();
		  driver.findElement(By.xpath("(//button[text()='Book Now'])[1])")).click();
	  }
	  public String addpassengerdetails(String Name,String Mobile,String Email,String Gender)
	  {
		  driver.findElement(By.xpath("//b[text()='Yes, Secure my trip. ']//..//..//span[@class='customRadioBtn']")).click();
		  WebElement name = driver.findElement(By.xpath("//input[@placeholder='First & Middle Name']"));
		  name.sendKeys(Name);
		  WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Mobile No']"));
		  mobile.sendKeys(Mobile);
		  WebElement mail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		  mail.sendKeys(Email);
		  driver.findElement(By.xpath("//input[@value=Gender]")).click();
		  driver.findElement(By.xpath("//button[text()='Continue']")).click();
		  driver.findElement(By.xpath("//button[text()='Got it']")).click();
		  String confirmReview = driver.findElement(By.xpath("//h3[text()='Review Details']")).getText();
		  return confirmReview;
	  }
	  
	  public void addadult()
	  {
		  WebDriverWait wait = new WebDriverWait(driver,5);
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='+ ADD NEW ADULT']"))));
		  driver.findElement(By.xpath("//button[text()='+ ADD NEW ADULT']")).click();
	  }
	  
	  
	  public  String getDatafromProperties()
	  {
		  File file = new File("C:/TestAutomation/PWCTest/Makemytrip/src/main/java/Travel/Makemytripdatafile/Data.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String From = prop.getProperty("From").trim();
			String To = prop.getProperty("To").trim();
			searchflight(From,To);
			getflightdetails();
			String Name = prop.getProperty("Name").trim();
			String Mobile = prop.getProperty("Mobile").trim();
			String Email = prop.getProperty("Email").trim();
			String Gender = prop.getProperty("Gender").trim();
			String confirmReview = addpassengerdetails(Name,Mobile,Email,Gender);
			return confirmReview;
	  }
	  
	  
	 

}
