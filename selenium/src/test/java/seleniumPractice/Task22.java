package seleniumPractice;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=813766258796&hvpos=&hvnetw=g&hvrand=13762291082736183204&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9183535&hvtargid=kwd-64107830&hydadcr=14452_2461880&gad_source=1");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
		//Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//WebElement seemore =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='See more, Brands']//span[text()='See more']")));
		WebElement seemore = driver.findElement(By.xpath("//a[@aria-label='See more, Brands']//span[text()='See more']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",seemore);
		seemore.click();
		List<WebElement> count=driver.findElements(By.xpath("//ul[contains(@id,'filter-p_123')]//li[not(.//span[text()='See Less'])]"));
		System.out.println(count.size());
		
		System.out.println("-------------");
		
		for(WebElement s : count) {
			System.out.println(s.getText());
		}
		System.out.println("-------");
		
		WebElement checkBox= driver.findElement(By.xpath("//a[contains(@aria-label,'HP')]//i[contains(@class,'a-icon-checkbox')]"));
		checkBox.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'a-size-medium')]")));

		List <WebElement> products = driver.findElements(By.xpath("//h2[contains(@class,'a-size-medium')]"));
		for(int i=1;i<6;i++) {
			System.out.println(products.get(i).getText());
		}
		System.out.println("----------------");
		
		List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class,'a-price-whole')]"));
		for(int j=0; j<5;j++) {
			System.out.println(price.get(j).getText());
		}
		System.out.println("----------------");

	   driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@aria-label,'HP')]")));

	   WebElement hp = driver.findElement(By.xpath("//a[contains(@aria-label,'HP')]"));
		if(hp.getText().contains("HP")) {
		System.out.println("HP Brand filter is applied");
	}
//		Map<String,String>ProductandPrice=new LinkedHashMap<>();
//		for(int i=0;i<5 && i<5;i++) {
//			String productName = products.get(i).getText();
//			String productPrice = price.get(i).getText();
//			ProductandPrice.put(productName,productPrice);
//		}
//	System.out.println(ProductandPrice);
//	
//	driver.navigate().refresh();
//	WebElement hp = driver.findElement(By.xpath("//a[contains(@aria-label,'HP')]"));
//	if(hp.getText().contains("HP")) {
//		System.out.println("HP filter is applied");
//	}
	
//		if(products.contains("HP")) {
//			System.out.println("Pass");
//		}else {
//			System.out.println("Fail");
//		}
//		Thread.sleep(5000);
//		WebElement slider = driver.findElement(By.xpath("//*[@id='p_36/range-slider_slider-item_lower-bound-slider']"));
//		Thread.sleep(5000);
//
//		Actions a = new Actions(driver);
//		a.dragAndDropBy(slider, 50, 0).perform();
		
	}

	}
	

