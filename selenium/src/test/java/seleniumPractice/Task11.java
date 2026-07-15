package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("input1")).sendKeys("Welcome to Section 1");
	    driver.findElement(By.id("btn1")).click();
	    
	    WebElement f1 =driver.findElement(By.id("input1"));
		String text1 =f1.getAttribute("value");
		System.out.println(text1);
	    
	    driver.findElement(By.id("input2")).sendKeys("Welcome to Section 2");
	    driver.findElement(By.id("btn2")).click();
	    
	    WebElement f2 =driver.findElement(By.id("input2"));
		String text2 =f2.getAttribute("value");
		System.out.println(text2);
		
	    driver.findElement(By.id("input3")).sendKeys("Welcome to Section 3");
	    driver.findElement(By.id("btn3")).click();
	    
	    WebElement f3 =driver.findElement(By.id("input3"));
		String text3 =f3.getAttribute("value");
		System.out.println(text3);
	}

}
