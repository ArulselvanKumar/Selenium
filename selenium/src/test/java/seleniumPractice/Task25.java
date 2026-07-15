package seleniumPractice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task25 {

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
		searchBox.sendKeys("Power bank");
		driver.findElement(By.xpath("//button[@class ='XFwMiH']")).click();
		
		List<WebElement>powerBank = driver.findElements(By.xpath("//a[@class='GnxRXv']"));
		LocalDate earlydate= null;
		String date ="";
		for(int i =0;i<10;i++) {
			String parentWindow = driver.getWindowHandle();
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).click(powerBank.get(i)).keyUp(Keys.CONTROL).perform();
			Set<String> windows = driver.getWindowHandles();
			for(String child:windows) {
				if(!child.equals(parentWindow)) {
					driver.switchTo().window(child);
					String name1= driver.findElement(By.xpath("//div[@class='_1psv1zeb9 _1psv1ze0 _1psv1ze29']")).getText();
					System.out.println(name1);
					
					String date1=name1.replace("\n"," ").replace("Delivery by","").split(",")[0].trim();
					System.out.println("date1=[" +date1+ "]");					

					DateTimeFormatter format =DateTimeFormatter.ofPattern("d MMM yyyy");
					LocalDate CD = LocalDate.parse(date1+" 2026",format);
					if(earlydate==null|| CD.isBefore(earlydate)) {
						earlydate=CD;
						date=name1;
						
					}
		}
		

	}

		}
		
	}}
