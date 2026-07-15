package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List <WebElement> Label = driver.findElements(By.xpath("//div[@id='mobiles']//label"));
		boolean available = false;

		for(WebElement l: Label) {
			String labellist = l.getText();
			System.out.println(labellist);
			if(labellist.equalsIgnoreCase("samsung")) {
				available = true;
			}
		}
			
			if(available) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		

	}
	
}
