package Questions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


class  LoanDetails{
	String fname;
	String lname;
	String email;
	int ind1;
	int ind2;
	
	public LoanDetails(String fname,String lname,String email,int ind1,int ind2) {
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.ind1=ind1;
		this.ind2=ind2;
	}
}

public class EbankingApp {

	public static String applyLoan(WebDriver driver,String url,LoanDetails loan) throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("firstName")).sendKeys(loan.fname);
		driver.findElement(By.id("lastName")).sendKeys(loan.lname);
		driver.findElement(By.id("email")).sendKeys(loan.email);
		WebElement ele1=driver.findElement(By.id("loanType"));
		Select drop1=new Select(ele1);
		drop1.selectByIndex(loan.ind1);
		WebElement ele2=driver.findElement(By.id("loanDuration"));
		Select drop2=new Select(ele2);
		drop2.selectByIndex(loan.ind2);
		driver.findElement(By.id("submitBtn")).click();
		
		Thread.sleep(3000);
	return 	driver.findElement(By.id("secretCode")).getText();
		
	}
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","c:/Java Software/chromedriver-win64/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
		String url="C:\\Users\\shreya-tyagi\\Downloads\\Selenium-practice-html-code 1 1\\Selenium-practice-html-code 1\\LoanDetails-practice\\loanPage.html";
	LoanDetails loan=new LoanDetails("Shreya","Tyagi","shreya118@gmail.com",2,4);
	
	
	System.out.println(applyLoan(driver,url,loan));
		
	}

}
