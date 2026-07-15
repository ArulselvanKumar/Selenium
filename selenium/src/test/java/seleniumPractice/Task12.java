package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		/*WebElement text1 = driver.findElement(By.xpath("//button[contains(@class,'st')]"));
		String status1 = text1.getText();
		System.out.println(status1);*/
		
		driver.findElement(By.xpath("//button[contains(@class,'st')]")).click();
		WebElement text2 = driver.findElement(By.xpath("//button[contains(@class,'st')]"));
		String status1 = text2.getText();
			if(!status1.equals("Start")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
			text2.click();
	        String status2 = text2.getText();
			
			if(!status2.equals("Start")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
			driver.quit();
			
		}
		
		
}


