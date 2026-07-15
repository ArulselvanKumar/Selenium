package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		 WebElement drag = driver.findElement(By.id("draggable"));
		 WebElement drop =driver.findElement(By.id("droppable"));
		    Actions dr = new Actions(driver);
		    dr.dragAndDrop(drag, drop).perform();
		    WebElement droptext = driver.findElement(By.xpath("//div[@id='droppable']//p"));
		    String d = droptext.getText();
		    System.out.println(d);
		    
		    if(d.contains("Dropped!")) {
		    	System.out.println("Pass");
		    	
		    }else {
		    	System.out.println("Fail");
		    }
		    driver.quit();
		

	}

}
