package Betika;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Log_In {
		String my_dir = System.getProperty("user.dir");
		WebDriver driver;

	
		@BeforeTest
		  public void setUp()
  		{    			
  	    	String os = System.getProperty("os.name").toLowerCase();    			
  	    	if (os.contains("win"))
  	    	{    			    
  	    		System.out.println("You Are on Windows "); 			   
  	    		System.setProperty("webdriver.chrome.driver", my_dir + "\\Chrome\\chromedriver.exe");
  	    		driver = new ChromeDriver(getChromeOptions());
  	    	} 
  	    	else if 
  	    	(os.contains("nix") || os.contains("aix") || os.contains("nux")) 
  	    	{
  	    	    System.out.println("You Are on Linux ");
  	    	    System.setProperty("webdriver.chrome.driver", my_dir + "/chromedriver");
  	    	    System.out.println("Chrome Driver Path = " + my_dir + "/chromedriver");
  	    	    driver = new ChromeDriver(getChromeOptions());
  	    	} 
  	    	else 
  	    	{
  	    	    System.out.println("Not Detected");
  	    	}
  	}
		  
		  private ChromeOptions getChromeOptions(){
  	    	final ChromeOptions options = new ChromeOptions();
  	    	//options.addArguments("--headless");
  	    	//options.addArguments("--window-size=1280,800");
  	    	return options;}
		  
		@AfterTest		
	    	public void tearDown(){
	    	driver.quit();
			}
		  
		  public static void main(String[] args){
	      	TestNG testng = new TestNG();
	      	testng.setTestClasses(new Class[] {Log_In.class});
	      	testng.run();}
		 
		  @Test
		   public void login_authentication() throws InterruptedException 
		      {
			  	   driver.manage().window().maximize();
		           driver.get("https://www.betika.com/en-ke/login");
		           System.out.println("TC1 Verify that user can log in to betika site Success:");
		           driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("0723107746");
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("27301198");
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//button[@class='button account__payments__submit session__form__button login button button__secondary'][contains(.,'Login')]")).click();
		           System.out.println("Log in successful");
		           Thread.sleep(2000);
		          
		      }

		  @Test
		   public void Bet_placing() throws InterruptedException 
		      {
			  		Thread.sleep(2000);
			  		driver.findElement(By.xpath("(//span[@class='prebet-match__odd__odd-value bold'])[1]")).click();
			  		driver.findElement(By.xpath("//input[@type='number']")).clear();
			  		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1");
			  		driver.findElement(By.xpath("//span[contains(.,'Place Bet for KES1')]")).click();
			  		System.out.println("TC2 Verify that user can place a bet Successful:");
			  		
		      }
		  
}
		           
		       
		  