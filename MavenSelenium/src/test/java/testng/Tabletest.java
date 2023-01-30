package testng;

import org.testng.annotations.Test;

import pomPageFactory.Homepage;
import utility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Tabletest extends DriverManager {
	static WebDriver driver;
	Homepage home;
  @Test(priority=1,enabled=true)
  public void getname() throws InterruptedException {
	  home.clicktable();
	  Thread.sleep(3000);
	  WebElement name=driver.findElement(By.xpath("//table[@id='dtBasicExample']/tbody/tr[6]/td[1]"));//////dynamic xpath
	  String namevalue=name.getText();
	  System.out.println(namevalue);
  }
  @Test(priority=2,enabled=true)
  public void getnametest() throws InterruptedException {
	  for(int i=1;i<11;i++)
	  {
	  WebElement nametest=driver.findElement(By.xpath("//table[@id='dtBasicExample']/tbody/tr["+ i +"]/td[1]"));//////dynamic xpath
	  
	 String text=nametest.getText();
	  if(text.equals("Briellemson"))
	  {
		  Assert.assertTrue(true);
		  System.out.println("Testcase Passed");
	  }else {
		  
		  WebElement next=driver.findElement(By.xpath("//*[@id=\"dtBasicExample_next\"]/a"));
		  Boolean status=next.isEnabled();
		  if(status)
		  {
			  next.click();
			  Thread.sleep(4000);
		  }
		  else
		  {
			  Assert.fail("Testcase Failed");
		  }
	  }
		  
	  }
  }
  @BeforeTest

  public void beforeTest() throws InterruptedException 
  {
  String url = "https://selenium.obsqurazone.com/index.php";
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
