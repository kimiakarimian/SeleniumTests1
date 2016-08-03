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

public class OHPrice {
	
	WebDriver driver;
	String baseUrl ="https://jungle-socks.herokuapp.com/";
	String Zquantity;
	String eQuantity;
	String lQuantity;
	String gQuantity;
	@Test
	@Parameters("browser")
	public void testOhTotalPrice(String browserName){
		
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("20");
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("2");
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("13");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("OH");
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
		
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
       String zquantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int quant = Integer.parseInt(zquantity);
	 eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	 int equant = Integer.parseInt(eQuantity);
	 gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
	 int gquant = Integer.parseInt(gQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
      if (quant > 23 || equant > 3 || gquant >15){
		 
		 System.out.println("----Please Contact Developer quantity excedes the In Stock Value----- " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText());
		
		
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText());
		
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[8]/td[2]")).getText(), "$578.55");
		
		
			}
	
	@Test
	@Parameters("browser")
	public void testOhTotalPriceOfOutofBoundAndInBoundValue(String browserName){
		
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("-20");
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("100");
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("13");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("OH");
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
		
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
//       String zquantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
//	 int quant = Integer.parseInt(zquantity);
//	 eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
//	 int equant = Integer.parseInt(eQuantity);
	 gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int gquant = Integer.parseInt(gQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
      if (gquant >15){
		 
		 System.out.println("----Please Contact Developer quantity excedes the In Stock Value----- " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[6]/td[2]")).getText(), "$232.05");
		
		driver.close();
			}
	
	@Test
	@Parameters("browser")
	public void testOhTotalPriceOfOutOfBoundValue(String browserName){
		
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("1000");
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("50");
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("100");
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("134");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("OH");
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
		
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
       String zquantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int quant = Integer.parseInt(zquantity);
	 eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
	 int equant = Integer.parseInt(eQuantity);
	 lQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	 int lquant = Integer.parseInt(lQuantity);
	 gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]")).getText();
	 int gquant = Integer.parseInt(gQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
      if (quant > 23 || equant > 3 || gquant >15 ||lquant > 12 ){
		 
		 System.out.println("----Please Contact Developer quantity excedes the In Stock Value----- " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[9]/td[2]")).getText(), "$0.00");
		
		driver.close();
			}
	
	@Test
	@Parameters("browser")
	public void testOhTotalPriceOfNegativeAndZero(String browserName){
		
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("-1000");
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("-50");
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("0");
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("-134");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("OH");
		WebElement selected_state = state.getFirstSelectedOption();
		System.out.println("Selected State is "+selected_state.getText());
		//state.selectByVisibleText("California");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.name("commit")).click();
		
	/*	
//		String Subtotal = driver.findElement(By.id("subtotal")).getText();
       String zquantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int quant = Integer.parseInt(zquantity);
	 eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
	 int equant = Integer.parseInt(eQuantity);
	 lQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	 int lquant = Integer.parseInt(lQuantity);
	 gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]")).getText();
	 int gquant = Integer.parseInt(gQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
      if (quant > 23 || equant > 3 || gquant >15 ||lquant > 12 ){
		 
		 System.out.println("----Please Contact Developer quantity excedes the In Stock Value----- " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
	*/	
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[2]")).getText(), "$0.00");
		
		driver.close();
			}
	
	
	

}



