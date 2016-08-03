package com.earnst.automationtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BoundaryTest {

	WebDriver driver;
	String baseUrl ="https://jungle-socks.herokuapp.com/";
	String Zquantity = "24";
	@Test
	@Parameters("browser")
	public void testPrice(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/kimiakarimian/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
				
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("line_item_quantity_lion")).clear();
		driver.findElement(By.id("line_item_quantity_lion")).sendKeys("150");
		driver.findElement(By.id("line_item_quantity_elephant")).clear();
		driver.findElement(By.id("line_item_quantity_elephant")).sendKeys("100");
		driver.findElement(By.id("line_item_quantity_giraffe")).clear();
		driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys("80");
		Select sel1 = new Select(driver.findElement(By.name("state")));
		   sel1.selectByValue("MN");;
		driver.findElement(By.name("commit")).click();
	
		//String Subtotal = driver.findElement(By.id("subtotal")).getText();
//		String quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
//	 int quant = Integer.parseInt(quantity);

	
	 
	 String zquantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText();
	 int quant1 = Integer.parseInt(zquantity);
	 String eQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]")).getText();
	 int equant = Integer.parseInt(eQuantity);
	 String gQuantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]")).getText();
	 int gquant = Integer.parseInt(gQuantity);
	 
//	 int subt = Integer.parseInt(Subtotal);
//	
	 
if (quant1 > 23 || equant > 3 || gquant >15){
		 
		 System.out.println(" Errorrr " );
		Assert.assertTrue(false, "Please Contact Developer quantity excedes the In Stock Value");
		 
	 }else {
		 Assert.assertTrue(true, " In Stock Value");
	 }
       
		
		System.out.print(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]")).getText());
		
		//System.out.print(driver.findElement(By.id("taxes")).getAttribute(arg0));
		
		
			}
	
		
	}
	