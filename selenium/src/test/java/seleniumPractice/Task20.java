package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
		
		driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
		driver.findElement(By.xpath("//input[@class = 'button-1 search-box-button']")).submit();
		WebElement s =driver.findElement(By.xpath("//h2[@class='product-title']//a"));
		String store =s.getText();
		System.out.println(store);
		
		
		driver.findElement(By.xpath("//a[@href='/books']")).click();
		driver.findElement(By.xpath("//a[@href='/fiction']")).click();
		driver.findElement(By.id("add-to-cart-button-45")).click();

		wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='cart-qty']"),"(1)"));
		WebElement addcart=driver.findElement(By.xpath("//span[@class='cart-qty']"));
		String count = addcart.getText();
		System.out.println(count);
		WebElement successMessage = driver.findElement(By.xpath("//p[@class='content']"));
		System.out.println(successMessage.getText());
		
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		
		List<WebElement>table=driver.findElements(By.xpath("//table[@class='cart']//tr"));
		for(int i=1;i<table.size();i++) {
			WebElement row =table.get(i);
			List<WebElement>col = row.findElements(By.tagName("td"));
			String product =col.get(2).getText();
			String price = col.get(3).getText();
			WebElement input = col.get(4).findElement(By.tagName("input"));
			String quantity = input.getAttribute("value");
			String Total = col.get(5).getText();
			
			System.out.println("Product name:"+product+"\t"+"Price:"+price+"\t"+"Quantity:"+quantity+"\t"+"Total:"+Total);
		}
		
	}

}
