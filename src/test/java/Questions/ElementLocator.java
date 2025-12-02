package Questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class ElementLocator {
	
	public static List<WebElement> locateNonTextType(WebDriver driver,String url) {
		driver.get(url);
		WebElement form=driver.findElement(By.id("contactForm"));
//		return form.findElements(By.cssSelector("input[type]:not([type='text'])"));
		return form.findElements(By.xpath("//form//input[@type and not(@type='text')]"));
		
	}

	
	public static List<WebElement> locateContactElement(WebDriver driver,String url) {
		driver.get(url);
		WebElement form=driver.findElement(By.id("contactForm"));
//		return form.findElements(By.cssSelector("input[name^='contact']"));
		
//		 return form.findElements(By.cssSelector("input[name^='contact']"));
		
		return form.findElements(By.xpath("//form//input[starts-with(@name,'contact')]"));
		
	}
	
	public static WebElement locatesubmitElement(WebDriver driver,String url) {
		driver.get(url);
		WebElement form=driver.findElement(By.id("contactForm"));
		
//		return form.findElement(By.cssSelector("button[type='submit']"));
		return form.findElement(By.xpath("//form//button[@type='submit']"));
	}
	
	public static List<WebElement> locateMissingElement(WebDriver driver,String url) {
		driver.get(url);
		WebElement form=driver.findElement(By.id("contactForm"));
//		return form.findElements(By.cssSelector("input:not([id])"));
		return form.findElements(By.xpath("//form//input[not(@id)]"));
		
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
      WebDriver driver=new ChromeDriver();
      
      String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\ContactUs-Form\\contact.html";
      System.out.println(locateNonTextType(driver,url).size());
      System.out.println(locateContactElement(driver,url).size());
      System.out.println(locatesubmitElement(driver,url).getText());
      System.out.println(locateMissingElement(driver,url).size());
      
	}

}
