package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> svgelement = driver.findElements(By.xpath("//*[local-name()='svg']"));
		int s = svgelement.size();
		System.out.println(s);
		WebElement c = driver.findElement(By.xpath("//*[local-name()='circle']"));
		WebElement r = driver.findElement(By.xpath("//*[local-name()='rect']"));
		WebElement t = driver.findElement(By.xpath("//*[local-name()='polygon']"));

		
		c.click();
		String color = c.getAttribute("fill");
		System.out.println(color);
		
		if(c.isDisplayed()&&r.isDisplayed()&&t.isDisplayed()) {
			System.out.println("pass");
		}else {
			System.out.println("Fail");
		}




	}

}
