package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	
	private String email;
	private String password;
	private String loginUrl;
	
	public Login(String email, String password) {
		this.email = email;
		this.password = password;
		
	}
	
	
	public Login setloginUrl(String loginUrl) {
		
		this.loginUrl = loginUrl;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
		
	public String getPassword() {
		return password;
	}

	public void loginLinkedIn(WebDriver driver) {
		
		
        // Open LinkedIn Login Page
        driver.get(this.loginUrl);

        // Login
        driver.findElement(By.id("username")).sendKeys(this.email);
        driver.findElement(By.id("password")).sendKeys(this.password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Wait for the page to load
        try { 
        	
        	Thread.sleep(5000); 
        
        } 
        catch (InterruptedException e) { 
        	
        	e.printStackTrace(); 
        	
        }

        System.out.println("Logged in successfully!");
		

		
	}

}
