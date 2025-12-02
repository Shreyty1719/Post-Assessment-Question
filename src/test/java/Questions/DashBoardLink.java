package Questions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class DashBoardLink {

	public static List<String> findAllDashboardLinks(WebDriver driver,String url){
		List<String> result=new ArrayList<>();
		driver.get(url);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(int i=0;i<links.size();i++) {
			result.add(links.get(i).getAttribute("href"));
		}
		
		return result;
	}
	
	public static List<String> findAllValidDashboardLinks(WebDriver driver,String url) throws InterruptedException{
		List<String> result=new ArrayList<>();
		driver.get(url);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		String mainTitle=driver.getTitle();
		int i=0;
		int n=links.size();
		while(i<n) {
			List<WebElement> link=driver.findElements(By.tagName("a"));
			link.get(i).click();
			String title=driver.getTitle();
			Thread.sleep(3000);
//			String pageTitle=driver.findElement(By.tagName("h2")).getText();
			if(title.equals(mainTitle)) {
				driver.navigate().back();
				Thread.sleep(3000);
				List<WebElement> linkk=driver.findElements(By.tagName("a"));

				result.add(linkk.get(i).getAttribute("href"));
				
			}
			else {
				driver.navigate().back();
				Thread.sleep(3000);
				
			}
			i++;
			
			
		}
		return result;
	}
	
	public static List<String> findAllDashboardInvalid(WebDriver driver,String url) throws InterruptedException{
		List<String> result=new ArrayList<>();
		driver.get(url);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		String mainTitle=driver.getTitle();
		int i=0;
		int n=links.size();
		while(i<n) {
			List<WebElement> link=driver.findElements(By.tagName("a"));
			link.get(i).click();
			String title=driver.getTitle();
			Thread.sleep(3000);
//			String pageTitle=driver.findElement(By.tagName("h2")).getText();
			if(!title.equals(mainTitle)) {
				driver.navigate().back();
				Thread.sleep(3000);
				List<WebElement> linkk=driver.findElements(By.tagName("a"));

				result.add(linkk.get(i).getAttribute("href"));
				
			}
			else {
				driver.navigate().back();
				Thread.sleep(3000);
				
			}
			i++;
			
			
		}
		return result;
	}
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\dashboard-links\\index.html";
	List<String> list=findAllDashboardLinks(driver,url)		;
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	
	List<String> list2=findAllValidDashboardLinks(driver,url);
	for(int i=0;i<list2.size();i++) {
		System.out.println(list2.get(i));
	}
		
		List<String> list3=findAllDashboardInvalid(driver,url);
		for(int i=0;i<list3.size();i++) {
			System.out.println(list3.get(i));
		}
	}

}
