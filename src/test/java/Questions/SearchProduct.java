package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class SearchProduct {

	public static Map<String,String> productSearch(WebDriver driver,String url,String search){
		driver.get(url);
		Map<String,Integer> map=new HashMap<>();
		
		driver.findElement(By.name("productName")).sendKeys(search);
		driver.findElement(By.xpath("//html/body/div/form/button")).click();
		List<WebElement> header=driver.findElements(By.tagName("th"));
		
		
	
		HashMap<String,String> mapp=new HashMap<>();
		
		for(int i=0;i<header.size();i++) {
			String text=header.get(i).getText();
			map.put(text, i);
		}
		int productVendor=map.get("Product Vendor");
		int productPrice=map.get("Product Price");
		
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++) {
			List<WebElement> cellData=rows.get(i).findElements(By.tagName("td"));
			
			mapp.put(cellData.get(productVendor).getText(),cellData.get(productPrice).getText());
			
			
		}
		
		
		return mapp;
	}
	
	public static String searhMinimum(WebDriver driver,String url,String productName) throws InterruptedException {
		String result="";
		driver.get(url);

		driver.findElement(By.name("productName")).sendKeys("Laptop");
		driver.findElement(By.xpath("//html/body/div/form/button")).click();
		int price=Integer.MAX_VALUE;
		List<WebElement> header=driver.findElements(By.tagName("th"));
		HashMap<String,Integer> map=new HashMap<>();
		
		for(int i=0;i<header.size();i++) {
			String text=header.get(i).getText().trim();
			map.put(text,i);
		}
		
		
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		int productIndex=map.get("Product Name");
		int productPrice=map.get("Product Price");
		for(int i=1;i<rows.size();i++) {
			List<WebElement> cellData=rows.get(i).findElements(By.tagName("td"));
			
			if((cellData.get(productIndex).getText()).equals(productName)) {
				if(price>Integer.parseInt(cellData.get(productPrice).getText())){
					price=Integer.parseInt(cellData.get(productPrice).getText());
					
				}
			}
		}
		
		result=String.valueOf(price);
		Thread.sleep(3000);
		
		return result;
	}
	public static void main(String[] args) throws InterruptedException {

		String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\product-search\\searchPage.html";

         System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");

         WebDriver driver=new ChromeDriver();
System.out.println(productSearch(driver,url,"pen"));

System.out.println(searhMinimum(driver,url,"Laptop"));

	}

}
