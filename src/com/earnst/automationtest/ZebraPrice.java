package com.earnst.automationtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZebraPrice {
	
	WebDriver driver;
	String baseUrl ="https://jungle-socks.herokuapp.com/";
	String Zquantity = "24";
	@Test
	@Parameters("browser")
	public void testZebraPrice(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/kimiakarimian/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("line_item_quantity_zebra")).clear();
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("24");
//		Select sel1 = new Select(driver.findElement(By.name("state")));
//		   sel1.selectByValue("CA");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("CA");
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
       String quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int quant = Integer.parseInt(quantity);
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
   if (quant > 23){
		 
		 System.out.println(" Errorrr " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }
       
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		
		//System.out.print(driver.findElement(By.id("taxes")).getAttribute(arg0));
		
		
			}
	
		
	}
	
	


