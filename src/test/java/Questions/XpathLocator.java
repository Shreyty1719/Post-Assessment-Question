package Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {
	
public static String relative(WebDriver driver,String url) {
//	driver.get(url);
	
	return "//div[@id='bucket']//input";
}

public static String absolute(WebDriver driver,String url) {
//	driver.get(url);
	return "/html/body//div[@id='bucket']//input";
}
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
WebDriver driver=new ChromeDriver();
String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Registration-Form\\home.html";
System.out.println(relative(driver,url));
System.out.println(absolute(driver,url));
	}

}
