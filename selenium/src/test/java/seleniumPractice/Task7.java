package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		String parentwindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		Set <String> wd = driver.getWindowHandles();
		
		for(String childwindow : wd) {
			if(!childwindow.equals(parentwindow)) {
				driver.switchTo().window(childwindow);
				String Title = driver.getTitle();
				if(!Title.isEmpty()) {
					System.out.println("Pass");

				}else {
					System.out.println("Fail");

				}
				driver.close();
				driver.switchTo().window(parentwindow);
			}
		}
	}

}
