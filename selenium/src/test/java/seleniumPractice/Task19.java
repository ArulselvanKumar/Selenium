package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> page = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		for(int i=0;i<page.size();i++) {
			List<WebElement> number = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
			number.get(i).click();
		

		List<WebElement> table=driver.findElements(By.xpath("//table[@id='productTable']//tr"));
		int count =table.size();
		

		for(int j=1;j<table.size();j++) {
			WebElement rows = table.get(j);
			List<WebElement> col = rows.findElements(By.tagName("td"));
			String id =col.get(0).getText();
			String name = col.get(1).getText();
			double price =Double.parseDouble(col.get(2).getText().replace("$", "").trim());
			System.out.println("ID:"+id+"\t"+"Name:"+name+"\t"+"Price:"+price);
		
		}
		
	
	}	
		
		List<WebElement> page1 = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
	for(int i=0;i<page1.size();i++) {
		List<WebElement> number = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		number.get(i).click();
		
		List<WebElement> table=driver.findElements(By.xpath("//table[@id='productTable']//tr"));

		for(int k=1;k<table.size();k++) {
			WebElement rows = table.get(k);
			List<WebElement> col = rows.findElements(By.tagName("td"));
			String id =col.get(0).getText();
			String name = col.get(1).getText();
			double price =Double.parseDouble(col.get(2).getText().replace("$", "").trim());
		
		if(name.contains("Smart Home Hub")&&price==20.99) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
}
	}
	
	List<WebElement> page2 = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
	for(int i=0;i<page2.size();i++) {
		List<WebElement> number = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		number.get(i).click();
		double maximumPrice=0;
		String MaximumId="";
		String MaximumName="";
		
		List<WebElement> table=driver.findElements(By.xpath("//table[@id='productTable']//tr"));

		for(int k=1;k<table.size();k++) {
			WebElement rows = table.get(k);
			List<WebElement> col = rows.findElements(By.tagName("td"));
			String id =col.get(0).getText();
			String name = col.get(1).getText();
			double price =Double.parseDouble(col.get(2).getText().replace("$", "").trim());
			if(price>maximumPrice) {
				maximumPrice = price;
				MaximumId =id;
				MaximumName = name;

			}
		
		}
		System.out.println(MaximumId+MaximumName+maximumPrice);

	}
	
	}
	
}

