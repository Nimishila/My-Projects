package utilityClass;

import org.testng.annotations.Test;

import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestUtility extends DriverManager {
	WebDriver driver;
///////click/////////
	@Test(priority = 1, enabled = false)
	  public void TC_inputForm() throws InterruptedException 
	{
		//implementation of element
		  WebElement inputform = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		  inputform.click();//for click
		  Thread.sleep(4000);//for wait 4sec
		  //Enter Message inspect
		  WebElement enterMessage = driver.findElement(By.id("single-input-field"));//implementation
		  enterMessage.sendKeys("HelloApp");//enter the value
		  //show message inspect
		  WebElement showMessage = driver.findElement(By.id("button-one"));//implementation
		  showMessage.click();
		  Thread.sleep(4000);
		  WebElement textMessage = driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
		  String text = textMessage.getText();
		  //check enter message and display message equal
		  if(text.contains("HelloApp")) 
		  {
			  Assert.assertTrue(true,"Messages are same");
		  }else 
		  {
			  Assert.assertTrue(false,"Mismatch messages");
		  }		 
	}
	@Test(priority=2, enabled=true)
	 public void TC_addition() throws InterruptedException
	 {
		  WebElement inputform2 = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		  inputform2.click();
		  Thread.sleep(4000);
		  WebElement valueA = driver.findElement(By.id("value-a"));
		  valueA.sendKeys("14");
		  WebElement valueB = driver.findElement(By.id("value-b"));
		  valueB.sendKeys("6");
		  WebElement getTotal=driver.findElement(By.id("button-two"));
		  getTotal.click();	  
		  Thread.sleep(4000);
		  WebElement result=driver.findElement(By.id("message-two"));		
		  // value=20;
		  String r=result.getText();
		  if(r.contains("20"))
		  {
			  Assert.assertTrue(true,"Result passed");		
			  }else 					
		  {
			  Assert.assertTrue(false,"Result failed ");
		  }		 
		  
	 }
	
	  @BeforeTest
	    public void beforeTest() throws InterruptedException
		  {
		  String url="https://selenium.obsqurazone.com/index.php";
		  String browser="Chrome";
		  launchBrowser(url,browser);
		  }

		  @AfterTest
		  public void afterTest() 
		  {
			  closeBrowser();
		  }
		
}

