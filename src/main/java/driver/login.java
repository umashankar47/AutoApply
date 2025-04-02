package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;




public class login {
	
	    public static void main(String[] args) {
	    	
	    	//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/chrome/ChromeDriver.html
	    	
	    	
	    	
	    	
	        // Setup WebDriver
//	        WebDriverManager.chromedriver().setup();
	    	
	    	
	    	ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("debuggerAddress", "localhost:9222");
	        
	        
	        
	        WebDriver driver = new ChromeDriver(options);
	        
	        System.out.println("Driver setup successfully!  " + driver.toString());
	        
	        // Set timeout
	        Duration timeout = Duration.ofSeconds(10);
	        //wait for 10 seconds
	        driver.manage().timeouts().implicitlyWait(timeout);
	        
	        
	        
	        

	        // Open LinkedIn Login Page
	        driver.get("https://www.linkedin.com/login");

	        // Login
	        driver.findElement(By.id("username")).sendKeys("musicplug79@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("MusicPlugPassword@123#");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        // Wait for the page to load
	        try { 
	        	
	        	Thread.sleep(5000); 
	        
	        } 
	        catch (InterruptedException e) { 
	        	
	        	e.printStackTrace(); 
	        	
	        }

	        System.out.println("Logged in successfully!");
	        
//	        driver.get("https://www.linkedin.com/jobs/search/?f_AL=true");
	        driver.get("https://www.linkedin.com/jobs/search/?currentJobId=4186768321&f_AL=true&geoId=102713980&keywords=Java&origin=JOB_SEARCH_PAGE_SEARCH_BUTTON&refresh=true");
	        	
	        	

//	        driver.quit();
	    
	}

}
