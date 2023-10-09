package com.insight.base;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		public WebDriver driver;
		public WebDriver initalizeBrowser(String url) throws Exception
		{
			Properties prop=new Properties();
			FileInputStream fis= new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Infy\\src\\test\\resources\\Properties\\Config.properties");
			prop.load(fis);
			System.out.println(prop.getProperty("browser"));
			String browsername=prop.getProperty("browser");
			if(browsername.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browsername.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new ChromeDriver();
			}
			else if(browsername.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty(url));
			
			return driver;
			
		}
		
		public void waitForVisibility(WebElement e)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(e));
		}
		
		public void waitUntilElementIsClickable(WebElement e)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		
		public void click(WebElement e)
		{
			waitForVisibility(e);
			waitUntilElementIsClickable(e);
			e.click();
		}
		
		public void sendKeys(WebElement e, String text)
		{
			waitForVisibility(e);
			e.sendKeys(text);
		}
		
		public void clearText(WebElement e)
		{
			waitForVisibility(e);
			e.clear();
		}
		
		public String getText(WebElement e)
		{
			waitForVisibility(e);
			return e.getText();	
		}
		
		public void navigateBack()
		{
			driver.navigate().back();
		}
		
		public void acceptAlert()
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert - "+driver.switchTo().alert().getText());
			alert.accept();
		}
		
		public void dismissAlert()
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			Alert alert=wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert - "+driver.switchTo().alert().getText());
			alert.dismiss();
		}
		
		public void scrollIntoView(WebElement e, int up, int down)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+up+","+down+")");
		}
		
		public void scrollIntoView(WebElement e)
		{
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded()",e);
			
		}
		
		public void switchToNextWindow() {
			Set<String> windowPopup = driver.getWindowHandles();
			Iterator<String> iterate = windowPopup.iterator();
			List<String> windowIndex = new ArrayList<String>();
			while(iterate.hasNext())  {
				windowIndex.add(iterate.next());
			}
			driver.switchTo().window(windowIndex.get(1));	
			driver.manage().window().maximize();
			System.out.println("Switched to window");
			System.out.println("Window Title.."+ driver.getTitle());
		}
		
		public String getCurrentTime() {
			DateFormat dateformat = new SimpleDateFormat("hh:mm a");
			Date time = new Date(0);
			String time1 = dateformat.format(time);
			return time1;
		}
		public String getCurrentDate() {
			DateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
			Date date = new Date(0);
			String date1 = dateformat.format(date);
			return date1;	

}
}
