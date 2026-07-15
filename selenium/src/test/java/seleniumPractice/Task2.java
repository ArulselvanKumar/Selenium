package seleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
			
	    

	    
		WebElement field = driver.findElement(By.id("field1"));
		String text = field.getAttribute("value");
		System.out.println(text);
		   
	    WebElement dc = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
	    Actions dble = new Actions(driver);
	    dble.doubleClick(dc).perform();
	    
	    WebElement field2 = driver.findElement(By.id("field2"));
	    String text2 =field2.getAttribute("value");
	    System.out.println(text2);
	    
	    if(text.equals(text2)) {
	    	System.out.println("Pass");
	    }else {
	    	System.out.println("fail");
	    }
	    
	    driver.quit();
	    
	
	    
	
	}

}
