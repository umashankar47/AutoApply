package EasyApply.Linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import data.Information;
import data.Login;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	
    	Map<String ,String> config = readConfig();
    	
       	
    	ChromeOptions options = new ChromeOptions();
    	
    	String debubgAddress = config.get("debugAddress");
    	
        options.setExperimentalOption("debuggerAddress", debubgAddress);
        
        
        
        WebDriver driver = new ChromeDriver(options);
        
        System.out.println("Driver setup successfully!  " + driver.toString());
        
        // Set timeout
        Duration timeout = Duration.ofSeconds(10);
        //wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(timeout);
           
    	
//    	Login login = new Login(config.get("email").toString(), config.get("password").toString());
//    	login.setloginUrl(config.get("loginUrl").toString());
        
        Login login = readData();
        Information information = readInfo();
        
    	
    	Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Login");
            System.out.println("2. Go to job Search");
            System.out.println("3. Start Applying");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Option 1.");
                    login.loginLinkedIn(driver);
                    break;
                case 2:
                    System.out.println("You selected Option 2.");
                    break;
                case 3:
                    System.out.println("You selected Option 3.");
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    	
    	
    	
    	
       
      
        
    }
    
    
    private static Map<String, String> readConfig() {
    		
    	
    	Yaml yaml = new Yaml();
		
		System.out.println("Reading config.yaml file");
		
		 Map<String, String> data = new HashMap<String, String>();

            try (InputStream input = new FileInputStream("config.yaml")) {        
            			
            	data = yaml.load(input);     
                
            } catch (Exception e) {
            	
            	
                e.printStackTrace();
            }
            
         
            
            return data;
    }


	public static Login readData() {
    	

 		
 		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
 		
 		Login login = new Login();
		
		System.out.println("Reading login.yaml file");
		
		try {
			 login = mapper.readValue(new File("login.yaml"), Login.class);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
            
       return login;     
            
    }
	
	public static Information readInfo( ) {
		
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
 		
 		Information info = new Information();
		
		System.out.println("Reading login.yaml file");
		
		try {
			
			
			 info = mapper.readValue(new File("Info.yaml"), Information.class);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
            
       return info;    
	
		
	}
		
	
}
