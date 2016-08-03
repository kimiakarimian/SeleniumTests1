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

public class GAPrice {
	
	WebDriver driver;
	String baseUrl ="https://jungle-socks.herokuapp.com/";
	String zQuantity;
	String eQuantity;
	String lQuantity = "";
	String gQuantity;
	@Test
	@Parameters("browser")
	public void testCaPrice(String browserName){
//		ExtentReports logger = ExtentReports.get(CaPrice.class);
//		logger.init("//Users//kimiakarimian//Documents//Reports", true);
//		logger.startTest(" Verify California Total Price");
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys(zQuantity);
		
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys(eQuantity);
		
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys(lQuantity);
		
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("GA");
		
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
		
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
       zQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	   int quant = Integer.parseInt(zQuantity);
	   
	   lQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	   int lquant = Integer.parseInt(eQuantity);
	 
	  eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	  int equant = Integer.parseInt(eQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
     if (quant > 23 || equant > 3 || lquant > 12){
		 
		 System.out.println(" Errorrr " );
		 Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText());
		
		
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText());
		
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText(), "$356.40");
		
	}

}
