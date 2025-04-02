package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Apply {
	
	private boolean followPage;

//	private String jobTitle;	
	
	public  Apply setFollowPage(boolean followPage) {	
		
		this.followPage = followPage;	
		
		return this;
	}
	
	
	public static void applyNow1(WebDriver driver, Information information) {
		
		
		Map<String , String > elem = new HashMap<String, String>();	
		
		elem.put("", information.getFirstName());
		elem.put("", information.getLastName());	
		elem.put("text-entity-list-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740529-multipleChoice", information.getEmail());
		elem.put("text-entity-list-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740537-phoneNumber-country", information.getCountryCode());
		elem.put("single-line-text-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740537-phoneNumber-nationalNumber", information.getPhoneNumber());	
	
		
	
		for(Entry<String , String > es : elem.entrySet()) {
			
			
			try {
				
					WebElement element = driver.findElement(By.id(es.getKey()));
				
				
						if(element.getTagName().equalsIgnoreCase("select")) {
								
								
								Select dropdown = new Select(element);
					 
								dropdown.selectByValue(es.getValue());
					
							}
						else if(element.getTagName().equalsIgnoreCase("input")){
								
								element.sendKeys(es.getValue());
								
							}
						else {
			                    
			                    System.out.println("Element not found");
			                }
						     
			     
				} catch (Exception e) {
						// TODO: handle exception
				
					System.out.println("Exception : "+e);
				}				
		}	
		
	}

	
	public static void applyNowResume(WebDriver driver, Information information) {
		
		
		System.out.println("Upload New Resume ? ");
		Scanner scanner = new Scanner(System.in);
		
        String response = scanner.nextLine();
        
        scanner.close();
        
    
        if(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
        	
        	
            // Locate the hidden file input
            WebElement fileInput = driver.findElement(By.id("jobs-document-upload-file-input-upload-resume-urn:li:fsu_jobApplicationFileUploadFormElement:urn:li:jobs_applyformcommon_easyApplyFormElement:(4197206858,10935740521,document)"));

            // Upload file by sending the file path
    fileInput.sendKeys(information.getResumeUrl());  // Use absolute path

            System.out.println("Resume uploaded successfully!");
        	
        }
       
		
		
		
	}
	
	
	
//	 WebElement dropdownElement = driver.findElement(By.id(es.getKey()));
//	 
//	 Select dropdown = new Select(dropdownElement);
//	 
//	 dropdown.selectByValue(es.getValue());
//	 
//	 WebElement selectedOption = dropdown.getFirstSelectedOption();
//	 
//    System.out.println("Selected: " + selectedOption.getText());
//    
//    WebElement inputField = driver.findElement(By.id(es.getKey()));
//
//    inputField.sendKeys(es.getValue());
}
