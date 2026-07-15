package seleniumPractice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task23 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@role='button']")));
		driver.findElement(By.xpath("//span[@role='button']")).click();

		WebElement searchBox=driver.findElement(By.xpath("//input[@class='nw1UBF v1zwn25']"));
		searchBox.click();
		searchBox.sendKeys("Laptop");
		driver.findElement(By.xpath("//button[@class ='XFwMiH']")).click();
		
		
		List<String> nameList = new ArrayList<>();
		List<String> priceList = new ArrayList<>();
		
		int count=0;
		while(count<50) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='RG5Slk']")));
			List<WebElement> productName =driver.findElements(By.xpath("//div[@class='RG5Slk']"));
			List<WebElement> productPrice =driver.findElements(By.xpath("//div[@class='hZ3P6w DeU9vF']"));

			for(int i=0;i<productName.size();i++) {
				String productText = productName.get(i).getText();
				String priceText = productPrice.get(i).getText();
				priceText= priceText.replaceAll("[₹,]","");
				
				nameList.add(productText);
				priceList.add(priceText);
				System.out.println((count+1)+"."+productText+"\n"+priceText);
				count++;
				if(count==50){
				break;
			}
			}
			if(count<50) {
				
				WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();",next);
				Thread.sleep(2000);
				
			}
		
	}
		
		System.out.println("-------------------");
		
		
		for(int i=0;i<priceList.size()-1;i++) {
			for(int j=i+1;j<priceList.size();j++) {
				int price1= Integer.parseInt(priceList.get(i));
				int price2 =Integer.parseInt(priceList.get(j));
				if(price1<price2) {
					String price=priceList.get(i);
					priceList.set(i, priceList.get(j));
					priceList.set(j, price);
					
					String Name = nameList.get(i);
					nameList.set(i, nameList.get(j));
					nameList.set(j, Name);

				}
			}
		}
		System.out.println("Top Five Expensive Products List");
		
		
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"."+nameList.get(i)+"=Rs:"+priceList.get(i));
		}

}}
