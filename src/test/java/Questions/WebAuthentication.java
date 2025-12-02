package Questions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAuthentication {
	
	public static void login(WebDriver driver,String url) {
		
		
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
		
		System.out.println("Text:"+driver.findElement(By.xpath("/html/body/p")).getText());
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
 String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Login\\login.html";
        login(driver,url);


	}

}
