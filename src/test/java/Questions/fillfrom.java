package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fillfrom {
public static void fillform(WebDriver driver,String url) throws InterruptedException {
	driver.get(url);
	Thread.sleep(2000);
	driver.findElement(By.name("firstName")).sendKeys("Fizz");
	Thread.sleep(2000);
	driver.findElement(By.name("lastName")).sendKeys("Buzz");
	Thread.sleep(2000);
	driver.findElement(By.name("email")).sendKeys("fizz_buzz@hackerrank.com");
	Thread.sleep(2000);
	driver.findElement(By.name("password")).sendKeys("fizz_buzz@Hrw");
	Thread.sleep(2000);
	driver.findElement(By.name("confirmPassword")).sendKeys("c_fizz_buzz@Hrw");
	
	Thread.sleep(2000);
	submit(driver);
	
}
public static void submit(WebDriver driver) throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"registerForm\"]/button")).click();
}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Registration-Form\\home.html";
     
     fillform(driver,url);
     
	}

}
