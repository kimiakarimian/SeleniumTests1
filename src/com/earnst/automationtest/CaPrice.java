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


public class CaPrice {

	WebDriver driver;
	String baseUrl ="https://jungle-socks.herokuapp.com/";
	String Zquantity;
	String eQuantity;
	String lQuantity;
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
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("20");
		
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("2");
		WebElement state_dropDown = driver.findElement(By.name("state"));
		Select state = new Select(state_dropDown);
		state.selectByValue("CA");
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
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
     if (quant > 23 || equant > 3){
		 
		 System.out.println(" Errorrr " );
		 Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText());
		
		
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText());
		
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText(), "$356.40");
		
		driver.close();
			}
	
	@Test
	@Parameters("browser")
	public void TestCATotalPriceOutOfBound(String browserName){
	
	if(browserName.equalsIgnoreCase("firefox")){
			
			
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/kimiakarimian/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("line_item_quantity_zebra")).clear();
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("25");
		
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("-1");
		
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("3");
		
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
		
		
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
		
		String zQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
		   int zquant = Integer.parseInt(zQuantity);
		   
		   String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
		   int eQuant = Integer.parseInt(eQuantity);
		   
//		   String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
//		   int eQuant = Integer.parseInt(eQuantity);
//		   
//		   String gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]")).getText();
//		   int gQuant = Integer.parseInt(gQuantity);
	   
	   
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
   if (zquant > 23 || eQuant > 12  ){
		 
		 System.out.println(" Errorrr " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }
   else{
	   Assert.assertTrue(true, "In Stock Value");
   }
       
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText(), "$105.00");
		
		//System.out.print(driver.findElement(By.id("taxes")).getAttribute(arg0));
		driver.close();
	}
	
	@Test
	@Parameters("browser")
	public void TestCATotalPrice(String browserName){
	
	if(browserName.equalsIgnoreCase("firefox")){
			
			
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/kimiakarimian/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("line_item_quantity_zebra")).clear();
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("10");
		
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("5");
		
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("3");
		
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("15");
		
		
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
		
		String zQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
		   int zquant = Integer.parseInt(zQuantity);
		   
		   String lQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
		   int lQuant = Integer.parseInt(lQuantity);
		   
		   String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
		   int eQuant = Integer.parseInt(eQuantity);
		   
		   String gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]")).getText();
		   int gQuant = Integer.parseInt(gQuantity);
	   
	   
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
   if (zquant > 23 || lQuant > 12 || eQuant > 3 || gQuant > 15 ){
		 
		 System.out.println(" Errorrr " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }
   else{
	   Assert.assertTrue(true, "In Stock Value");
   }
       
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[9]/td[2]")).getText(), "$637.20");
		
		//System.out.print(driver.findElement(By.id("taxes")).getAttribute(arg0));
		driver.close();
	}

	@Test
	@Parameters("browser")
	public void TestCATotalPriceNotAcceptable(String browserName){
	
	if(browserName.equalsIgnoreCase("firefox")){
			
			
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/kimiakarimian/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("line_item_quantity_zebra")).clear();
		driver.findElement(By.id("line_item_quantity_zebra")).sendKeys("-25");
		
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("-1");
		
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("3000");
		
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("0");
		
		
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
		
//		String zQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
//		   int zquant = Integer.parseInt(zQuantity);
		   
//		   String lQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
//		   int lQuant = Integer.parseInt(lQuantity);
		   
//		   String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
//		   int eQuant = Integer.parseInt(eQuantity);
//		   
		   String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
		   int eQuant = Integer.parseInt(eQuantity);
	   
	   
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
   if ( eQuant > 3 ){
		 
		 System.out.println(" Errorrr " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }
   else{
	   Assert.assertTrue(true, "In Stock Value");
   }
       
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[7]/td[2]")).getText(), "$0.00");
		
		//System.out.print(driver.findElement(By.id("taxes")).getAttribute(arg0));
		driver.close();
	}
	
	

}
