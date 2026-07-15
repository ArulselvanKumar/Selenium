package seleniumPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='button']")));
		driver.findElement(By.xpath("//span[@role='button']")).click();

		WebElement searchBox=driver.findElement(By.xpath("//input[@class='nw1UBF v1zwn25']"));
		searchBox.click();
		searchBox.sendKeys("Wireless Mouse");
		driver.findElement(By.xpath("//button[@class ='XFwMiH']")).click();
		
		List<WebElement> products= driver.findElements(By.xpath("//a[@class='GnxRXv']"));
		String name ="";
		String price ="";
		double rating=0;
		
		for(int i=0;i<5;i++) {
			String parentWindow = driver.getWindowHandle();
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).click(products.get(i)).keyUp(Keys.CONTROL).perform();
			Set<String> windows = driver.getWindowHandles();
			for(String child:windows) {
				if(!child.equals(parentWindow)) {
					driver.switchTo().window(child);
					String name1= driver.findElement(By.xpath("//h1[@class='v1zwn21m v1zwn26 _1psv1zeb9 _1psv1ze0']")).getText();
					String price1=driver.findElement(By.xpath("//div[@class='v1zwn21m v1zwn20 _1psv1zeb9 _1psv1ze0']")).getText();
					String text1=driver.findElement(By.xpath("//div[@class='css-146c3p1']")).getText();
					double rating1 = Double.parseDouble(text1);
					System.out.println(name1);
					System.out.println(price1);
					System.out.println(rating1);
					
					if(rating1>rating) {
						rating=rating1;
						name=name1;
						price=price1;
				}
					driver.close();
					driver.switchTo().window(parentWindow);
					break;
				}
				
			}
			
			products= driver.findElements(By.xpath("//a[@class='GnxRXv']"));
		}
		System.out.println("Highest rated product:");
		System.out.println(name);
		System.out.println(price);

		System.out.println(rating);
		driver.quit();

}}