package lesson9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCase {
	
	WebDriver driver = new ChromeDriver();
	String Myurl = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";

	@BeforeTest
	public void mySetup() {
		driver.get(Myurl);
		driver.manage().window().maximize();
	}
	
	
	
	@Test(priority = 1)
	public void loginTest() {
		WebElement userNameInput = driver.findElement(By.id("user-name"));
		userNameInput.sendKeys(userName);
		
		
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		
		
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		
		
	}
	
	
	@Test(priority = 2,enabled = false)
	public void addAllItem() {
		
		List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(myAddtoCardButton.size());
		for(int i =0;i<myAddtoCardButton.size();i++) {
			myAddtoCardButton.get(i).click();
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void addoneitemandskipthenextone() {
		
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(myAddtoCardButton.size());
		for(int i =0;i<myAddtoCardButton.size();i=i+2) {
			myAddtoCardButton.get(i).click();
		}
		
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void addoneitemandskipthenextonetoright() {
		
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(myAddtoCardButton.size());
		for(int i =1;i<myAddtoCardButton.size();i=i+2) {
			myAddtoCardButton.get(i).click();
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void addfoureiteamandskipthem() {
		
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(myAddtoCardButton.size());
		for(int i =0;i<myAddtoCardButton.size();i++) {
			myAddtoCardButton.get(i).click();
			
			
			if(i==3) {
				break;
			}
			
		}
		
	}
	
	
	@Test(priority = 6,enabled = false)
	public void addallitemexceptionthree() {
		
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(myAddtoCardButton.size());
		for(int i =0;i<myAddtoCardButton.size();i++) {
			
			if(i==2) {
				continue;
			}
			
			myAddtoCardButton.get(i).click();
			
		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void findallelementthatTextlabs() {
		
         List<WebElement> itemsName = driver.findElements(By.className("inventory_item_name"));
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(itemsName.size());
		for(int i =0;i<itemsName.size();i++) {
			
	      String itemName = itemsName.get(i).getText();
	      
	      if(itemName.contains("Labs")) {
	    	 myAddtoCardButton.get(i).click();
	      }
			
		}
		
	}
	
	

	@Test(priority = 8,enabled = false)
	public void notalltextlabs() {
		
         List<WebElement> itemsName = driver.findElements(By.className("inventory_item_name"));
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
		System.out.println(itemsName.size());
		for(int i =0;i<itemsName.size();i++) {
			
	      String itemName = itemsName.get(i).getText();
	      
	      if(itemName.contains("Labs")) {
	    	continue;
	      }
	      
	      myAddtoCardButton.get(i).click();
			
		}
		
	}
	
	
	@Test(priority = 9)
	public void above15() {
		
         List<WebElement> above15 = driver.findElements(By.className("inventory_item_price"));
         List<WebElement> myAddtoCardButton = driver.findElements(By.className("btn"));
		
         
		 for(int i =0;i<above15.size();i++) {
			
			   String priceText = above15.get(i).getText().replace("$", "");
		        
		        
		        double price = Double.parseDouble(priceText);
	         
		        System.out.println(price);
		        
		        if(price>15) {
		        	myAddtoCardButton.get(i).click();
		        }
			
		}
		
	}
	
	
}
