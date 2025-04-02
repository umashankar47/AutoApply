package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Apply {
	
	private boolean followPage;

//	private String jobTitle;	
	
	Apply(boolean followPage) {
		
		this.followPage = followPage;	
		
	}
	
	
	public static void applyNow(WebDriver driver, Information information) {
		
		
	
		
		Map<String , String > elem = new HashMap<String, String>();	
		
		elem.put("", information.getFirstName());
		elem.put("", information.getLastName());	
		elem.put("text-entity-list-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740529-multipleChoice", information.getEmail());
		elem.put("text-entity-list-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740537-phoneNumber-country", information.getCountryCode());
		elem.put("single-line-text-form-component-formElement-urn-li-jobs-applyformcommon-easyApplyFormElement-4197206858-10935740537-phoneNumber-nationalNumber", information.getPhoneNumber());	
	
		
	
		for(Entry<String , String > es : elem.entrySet()) {
			
			
			try {
				
				
//				 WebElement dropdownElement = driver.findElement(By.id(es.getKey()));
//				 
//				 Select dropdown = new Select(dropdownElement);
//				 
//				 dropdown.selectByValue(es.getValue());
//				 
//				 WebElement selectedOption = dropdown.getFirstSelectedOption();
//				 
//			     System.out.println("Selected: " + selectedOption.getText());
//			     
//			     WebElement inputField = driver.findElement(By.id(es.getKey()));
//
//			     inputField.sendKeys(es.getValue());
				
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

}
