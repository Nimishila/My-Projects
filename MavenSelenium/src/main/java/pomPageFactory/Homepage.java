package pomPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
	WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);///initial page factory
	}
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul/li[2]/a")////for input form
	public WebElement inputform;
	
	@FindBy(id="single-input-field")
	public WebElement enterMessage;
	
	@FindBy(id="button-one")
	public WebElement showMessage;
	
	@FindBy(id="alert-modal")
	public WebElement alertsAndModals;

	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div/ul/li[2]/a")
    public WebElement checkboxDemo;

	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div/ul/li[3]/a")
    public WebElement radioButtonsDemo;
	
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul/li[4]/a")
	public WebElement table;
  	
	public void clicktable()
	{
		table.click();
	}
	public void clickinputform()
	{
		inputform.click();
	}
	
	public void clickentermsg(String data)
	{
		  enterMessage.clear();
		  enterMessage.sendKeys(data);
	}
	public void clickshowMessage()
	{
		showMessage.click();
	}
	
	public void clickalertsAndModals() 
	{
		alertsAndModals.click();
	}
	
	public void clickcheckbox() 
	{
		checkboxDemo.click();
	}
	public void clickradioButtons()
	{
		radioButtonsDemo.click();
	}
	

}