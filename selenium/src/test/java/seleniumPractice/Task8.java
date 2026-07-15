package seleniumPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("PopUp")).click();
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String> wd = driver.getWindowHandles();
		
			if(wd.size()>1) {
				System.out.println("Pass");
				
			}else {
				System.out.println("Fail");
			}
			
			
			for(String Childwindow: wd) {
				if(!Childwindow.equals(parentwindow)) {
					driver.switchTo().window(Childwindow);
					String title = driver.getTitle();
					if(!title.isEmpty()) {
						System.out.println("Pass");
					}else {
						System.out.println("Fail");
					}
					driver.close();
					
				}
			}
			driver.quit();
		}
		
		
	}


