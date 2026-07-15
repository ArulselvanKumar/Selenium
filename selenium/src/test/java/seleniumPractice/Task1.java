package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("name")).sendKeys("Arulselvan");
		driver.findElement(By.id("email")).sendKeys("arulselvan@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8764676591");
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("53,Nethaji street,Surampatti valasu,Erode");
		driver.findElement(By.xpath("//label[@class='form-check-label']")).click();
		driver.findElement(By.xpath("//input[@value='wednesday']")).click();
		driver.findElement(By.xpath("//input[@id='saturday']")).click();
		WebElement d = driver.findElement(By.id("country"));
		Select country = new Select(d);
		//country.selectByVisibleText("France");
		country.selectByIndex(1);
		WebElement c = driver.findElement(By.id("colors"));
		Select color = new Select(c);
		color.selectByVisibleText("Green");
		
		WebElement a = driver.findElement(By.id("animals"));
		Select animal = new Select(a);
	    animal.selectByValue("rabbit");
	    
	    driver.findElement(By.id("datepicker")).click();
	   
	   String month =  driver.findElement(By.className("ui-datepicker-month")).getText();
	   String year = driver.findElement(By.className("ui-datepicker-year")).getText();

	    while(!(month.equals("February") && year.equals("2026"))) {
	    	 driver.findElement(By.xpath("//span[text()='Prev']")).click();
	    	 month =driver.findElement(By.className("ui-datepicker-month")).getText();
	    	 year =driver.findElement(By.className("ui-datepicker-year")).getText();	
	    }
	    driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='15']")).click();
	    
	    
	    
	    

	}

}
