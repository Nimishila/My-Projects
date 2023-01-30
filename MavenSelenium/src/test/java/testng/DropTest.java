package testng;

import org.testng.annotations.Test;

import pomPageFactory.Homepage;
import utility.DriverManager;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class DropTest extends DriverManager
{
 WebDriver driver;
 Homepage home;
 
@Test(priority=3, enabled=true)
///////single drop down////////
public void drop() throws InterruptedException, IOException
	{
		this.driver=super.driver;
		home=new Homepage(driver);
	  /*home.clickinputform();
	  Thread.sleep(4000);*/
	  WebElement selectinput = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[4]/a"));
	  selectinput.click();
	  Thread.sleep(4000);
	  //screenshot();
 	  WebElement drop =  driver.findElement(By.id("single-input-field"));  	  
  	  //Select objdrop = new Select(drop);  	
      //////////three methods/////////
  	  //objdrop.selectByValue("Green");  	 //select list value 
  	  dropvalue(drop,"Green");
  	  Thread.sleep(4000);  	  
  	  
  	 /* objdrop.selectByVisibleText("Yellow"); //select visible text 	  
  	  Thread.sleep(4000);  	  
  	  objdrop.selectByIndex(1);  	  //select index 
  	  Thread.sleep(4000);*/
	}

  @Test(priority = 4, enabled=true)
////////Multiple drop down////////
    public void drop1() throws InterruptedException
  {
  	WebElement drop =  driver.findElement(By.id("multi-select-field"));
    Select objdrop = new Select(drop);
  	Boolean value = objdrop.isMultiple();
  	  if(value) 
  	  {
  		  System.out.println("This is multiple;");
  	  }else 
  	  {
  		  System.out.println("This is not multiple;");
  	  }
  	  objdrop.selectByValue("Green");
  	  Thread.sleep(4000);
  	  objdrop.selectByValue("Red");
  	  Thread.sleep(4000);
  	   objdrop.deselectAll();//deselect the items which is selected
  }
  @AfterMethod
	public void aftermethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==2)
		{
			screenshot();
		}
	}

  /*@BeforeTest

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
  }*/
}
	