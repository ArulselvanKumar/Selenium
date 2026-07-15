package seleniumPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		String parentwindow = driver.getWindowHandle();
		
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wikipedia-search-results']//a")));
		
		List<WebElement> link = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//a"));
		int count = link.size();
		System.out.println(count);
		
		
		if(count<3) {
			System.out.println("Less than 3 results available");
		}else {
			}
		for(int i=0; i<3;i++) {
			 link = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//a"));
			 link.get(i).click();
			 Set<String> windows = driver.getWindowHandles();
			 
			 for (String Childwindow:windows) {
				 
				 if(!Childwindow.equals(parentwindow)) {
					 
					 driver.switchTo().window(Childwindow);
					 String Title = driver.getTitle();
					 if(!Title.isEmpty()){
						 System.out.println("Pass");
					 }else {
						 System.out.println("Fail");
					 }
					 driver.close();
					 driver.switchTo().window(parentwindow);
					 break;
					 }
				 }
			 }
		}
			
		}
		
		


