package Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownandCheckBox {
	
	public static void fillOfDate(WebDriver driver,String url) {
		driver.get(url);
		WebElement element=driver.findElement(By.id("month"));
		Select drop=new Select(element);
		
		drop.selectByIndex(9);
		
		WebElement ele1=driver.findElement(By.id("day"));
		
		Select day=new Select(ele1);
		day.selectByIndex(17);
		
		WebElement ele2=driver.findElement(By.id("year"));
		
		Select year=new Select(ele2);
		year.selectByIndex(2);
	}

	public static void anwerQuestion(WebDriver driver,String url) {
		driver.get(url);
		driver.findElement(By.xpath("/html/body/div/form/div[1]/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/form/div[2]/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/form/div[3]/input[1]")).click();
		
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\Dropdown\\form.html";
		
        fillOfDate(driver,url);
        anwerQuestion(driver,url);
	}

}
