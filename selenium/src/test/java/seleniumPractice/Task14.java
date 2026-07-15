package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task14 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		
		WebElement dd = driver.findElement(By.id("comboBox"));
		js.executeScript("arguments[0].scrollIntoView();",dd);
		dd.click();
		driver.findElement(By.xpath("//div[@class='option' and text()='Item 50']")).click();

		String v =dd.getAttribute("value");
		System.out.println(v);
		
		if(v.equals("Item 50")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		

	}

}
