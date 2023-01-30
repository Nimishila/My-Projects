package testng;

import org.testng.annotations.Test;

import pomPageFactory.Homepage;
import utility.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RadioCheckTest extends DriverManager
{
	WebDriver driver;
	Homepage home;
	
  @Test(priority=5,enabled=true)
  public void radiobutton() throws InterruptedException 
  {
	/* home.clickinputform();
	 Thread.sleep(2000);*/
	 this.driver=super.driver;
	 home=new Homepage(driver);
	 home.clickradioButtons();
	 WebElement tickMale = driver.findElement(By.id("inlineRadio1"));
	 Thread.sleep(3000);
	 tickMale.click();
	 WebElement showSelectedValue = driver.findElement(By.id("button-one"));
	 showSelectedValue.click();
	 Thread.sleep(3000);
	 WebElement textCheckBox = driver.findElement(By.id("message-one"));
	 String text = textCheckBox.getText();Thread.sleep(3000);
	 if (text.contains("Radio button 'Male' is checked")) 
	 { //compare the value
		 Assert.assertTrue(true);
		 System.out.println("It has checked Male");

	 }else 
	 {
		 Assert.assertTrue(false,"It has not checked Male.");
	 }
	 }

 /* @BeforeTest

  public void beforeTest() throws InterruptedException 
  {
  String url = "https://selenium.obsqurazone.com/index.php";
  String browser="Chrome";
  launchBrowser(url,browser);
  this.driver=super.driver;
  home=new Homepage(driver);
  }*/

  @AfterTest

  public void afterTest() 
  {
	  closeBrowser();
  }
}
