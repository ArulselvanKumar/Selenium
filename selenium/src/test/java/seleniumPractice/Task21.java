package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
	
		
		driver.findElement(By.xpath("//button[text()='English']")).click();
		//driver.findElement(By.xpath("//input[@class= 'ng-tns-c68-7 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("Erode");
		//driver.findElement(By.xpath("//a[@class='fa fa-window-close pull-right loginCloseBtn ng-tns-c25-12']")).click();
		WebElement date = driver.findElement(By.xpath("//input[@class='ng-tns-c69-9 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']"));
		String dmy=date.getAttribute("value");
		System.out.println(dmy);
}
}