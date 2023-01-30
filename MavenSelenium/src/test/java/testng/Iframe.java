package testng;

import org.testng.annotations.Test;

import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Iframe extends DriverManager 
{
	static WebDriver driver;

  @Test(priority=1,enabled=true)
  public void iframe() throws InterruptedException 
  {
  WebElement frame = driver.findElement(By.xpath("/html/body/iframe"));
  driver.switchTo().frame(frame);
  WebElement python = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/ul/li[2]/a"));
  python.click();
  driver.switchTo().defaultContent();
  Thread.sleep(3000); 
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException
	  {
	  String url="https://www.javatpoint.com/oprweb/test.jsp?filename=htmliframes";
	  String browser="Firefox";
	  launchBrowser(url,browser);
	  this.driver=super.driver;
	
	  }

@AfterTest
	  public void afterTest() 
	  {
		  closeBrowser();
	  }
	
}
