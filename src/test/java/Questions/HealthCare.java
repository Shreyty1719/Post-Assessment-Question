package Questions;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class HealthCare {
	
	public static List<String> findAmountMissMatchPatient(WebDriver driver,String url) throws InterruptedException{
		driver.get(url);
		List<String> result=new ArrayList<>();
		int i=1;
		List<WebElement> row=driver.findElements(By.tagName("tr"));
		int n=row.size();
		while(i<n) {
			
			List<WebElement> rows=driver.findElements(By.tagName("tr"));
			List<WebElement> cellData=rows.get(i).findElements(By.tagName("td"));
			String amountPaid=cellData.get(3).getText();
			
			cellData.get(3).findElement(By.tagName("a")).click();
			Thread.sleep(3000);
		String claimPaid=	driver.findElement(By.id("sum")).getText();
		
		if(amountPaid.equals(claimPaid)) {
			 driver.navigate().back();
			 Thread.sleep(3000);
			 List<WebElement> r=driver.findElements(By.tagName("tr"));
			 List<WebElement> cellDataa=r.get(i).findElements(By.tagName("td"));
			 String pateintId=cellDataa.get(0).getText();
			result.add(pateintId);
			
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
		String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Healthcare\\patientsPage.html";
		
		System.out.println(findAmountMissMatchPatient(driver,url));
	}

}
