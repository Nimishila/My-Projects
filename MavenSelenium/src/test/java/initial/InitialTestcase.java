package initial;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialTestcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();//constructor
		driver.get("https://www.obsqurazone.com/");
		driver.manage().window().maximize();
		
		//////////////////////////******Testcase*******///////////////////////////////
		
		String expectedUrl="https://www.obsqurazone.com/";
		String actualUrl=driver.getCurrentUrl();
		if(expectedUrl.equals(actualUrl))
		{
			System.out.println("Test PASSED");
		}
		else
		{
			System.out.println("Test FAILED");
		}
		
		////////////////////////*******Title testcase*********/////////////////////////
		String expectedtitle="#1 Software Testing Training Courses in Kochi, Kerala - Obsqura Zone";
		String actualtitle=driver.getTitle();
		if(expectedtitle.equals(actualtitle))
		{
			System.out.println("Test PASSED");
		}
		else
		{
			System.out.println("Test FAILED");
		}
		driver.close();

	}

}
