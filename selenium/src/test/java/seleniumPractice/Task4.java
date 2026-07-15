package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement act =driver.findElement(By.className("dropbtn"));
	    Actions m = new Actions(driver);
	    m.moveToElement(act).perform();
	    WebElement text = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	    String t =text.getText();
	    System.out.println(t);
	    WebElement text2 =driver.findElement(By.xpath("//a[text()='Laptops']"));
	    String t2 = text2.getText();
	    System.out.println(t2);
	    driver.findElement(By.linkText("Laptops")).click();
	   
	    
	

	}
}
