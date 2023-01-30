package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
  @Test(priority=1, enabled=false)//false means this method can't be executed
  public void tcHome() {
		//String expectedUrl="https://www.obsqurazone.com/";
	    String expectedUrl="fgjhkjhjc";
		String actualUrl=driver.getCurrentUrl();
		if(expectedUrl.equals(actualUrl))
		{
			Assert.assertTrue(true);
			System.out.println("Test PASSED");
		}
		else
		{
			Assert.assertTrue(false,"Test FAILED");
			//System.out.println("Test FAILED");
		}
  }
  @Test(priority=2, enabled=true)//enable=true means - only this method is executed or run
  //priority set
  public void tcTittle() {
	   // String expectedtitle="#1 Software Testing Training Courses in Kochi, Kerala - Obsqura Zone";
	    String expectedtitle="12556215";
		String actualtitle=driver.getTitle();
	    //Hard Assert
		//Assert.assertEquals(actualtitle, expectedtitle,"This Testcase home is failed due to mismatch ");
		//System.out.println("After Hard Assertion");//this statement will cannot print after hard assertion bcs its failed
		
		//Soft Assert
		SoftAssert obj=new SoftAssert();//creating softassert class object
		obj.assertEquals(actualtitle, expectedtitle, "This Testcase home is failed due to mismatch ");
		System.out.println("After Soft Assertion");//this stmt will print if the TC is fail or not
		obj.assertAll();
        /*if(expectedtitle.equals(actualtitle))
		{
			System.out.println("Test PASSED");
		}
		else
		{
			System.out.println("Test FAILED");
		}*/
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();//constructor
		driver.get("https://www.obsqurazone.com/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
