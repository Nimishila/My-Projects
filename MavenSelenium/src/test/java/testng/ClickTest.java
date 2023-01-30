package testng;

import org.testng.annotations.Test;

import pomPageFactory.Homepage;
import utility.DriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;

public class ClickTest extends DriverManager
{
	static WebDriver driver;
	Homepage home;//creating object of home page
///////click/////////
	@Test(priority = 1, enabled =true,dataProvider="Values")
	  public void TC_inputForm(String name, String country) throws InterruptedException, IOException 
	{
		//implementation of element
		 /* WebElement inputform = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		  inputform.click();//for click*/
		  home.clickinputform();
		  Thread.sleep(4000);//for wait 4sec
		  //Enter Message inspect
		 /* WebElement enterMessage = driver.findElement(By.id("single-input-field"));//implementation
		  enterMessage.sendKeys("HelloApp");//enter the value*/
		  home.clickentermsg(name);
		  //show message inspect
		 /* WebElement showMessage = driver.findElement(By.id("button-one"));//implementation
		  showMessage.click();*/
		  home.clickshowMessage();
		 Thread.sleep(4000);
		 //screenshot();
		  WebElement textMessage = driver.findElement(By.xpath("//*[@id=\"message-one\"]"));
		  String text = textMessage.getText();
		  //check enter message and display message equal
		  if(text.contains(name)) 
		  {
			  Assert.assertTrue(true,"Messages are same");
		  }else 
		  {
			  Assert.assertTrue(false,"Mismatch messages");
		  }		 
	}
	@Test(priority=2, enabled=false)
	 public void TC_addition() throws InterruptedException, IOException
	 {
		  /*WebElement inputform2 = driver.findElement(By.xpath("//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a"));
		  inputform2.click();
		  Thread.sleep(4000);*/
		home.clickinputform();
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
		 // screenshot();
		  String r=result.getText();
		  if(r.contains("20"))
		  {
			  Assert.assertTrue(true,"Result passed");		
			  }else 					
		  {
			  Assert.assertTrue(false,"Result failed ");
		  }		 
		  
	 }
	
@AfterMethod
	public void aftermethod(ITestResult result) throws InterruptedException, IOException 
	{
		if(result.getStatus()==2)
		{
			screenshot();
		}		
	}
	@DataProvider(name="Values")//for given different values
    public Object[][] getDataFromDataprovider()
	{
		return new Object[][]{{ "Namasthe", "India" },{ "Welcome", "UK" },{ "Hi", "USA" }};
	}

	 @BeforeTest
	    public void beforeTest() throws InterruptedException
		  {
		  String url="https://selenium.obsqurazone.com/index.php";
		  String browser="Chrome";
		  launchBrowser(url,browser);
		  this.driver=super.driver;
		  home=new Homepage(driver);
		  }

	 @AfterTest
		  public void afterTest() 
		  {
			  closeBrowser();
		  }
		
		
}
