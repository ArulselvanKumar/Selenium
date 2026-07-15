package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement>tableRow =driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		for(int i =1;i<tableRow.size();i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			String bookname =col. get(0).getText();
			String author = col.get(1).getText();
			String subject = col.get(2).getText();
			String price = col.get(3).getText();
		

			if(bookname.equalsIgnoreCase("Learn Java")) {
			
				System.out.println(price);	

			}
			
			
		}
		
		
		
		System.out.println("------------------------");

		int count = tableRow.size();
		System.out.println(count);
		
		
		System.out.println("------------------------");


		for(int i =1;i<tableRow.size();i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			String bookname =col. get(0).getText();
			System.out.println(bookname);
		
		}
		
		System.out.println("------------------------");

		for(int i =1;i<tableRow.size();i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			String bookname =col. get(0).getText();
			String author = col.get(1).getText();
			if(author.equalsIgnoreCase("Amit")) {
				System.out.println(bookname);
			}
			
		}
		
		System.out.println("------------------------");

		for(int i =1;i<tableRow.size();i++) {
			WebElement row = tableRow.get(i);
			List<WebElement> col = row.findElements(By.tagName("td"));
			String bookname =col. get(0).getText();
			String price = col.get(3).getText();
			
		if(bookname.equalsIgnoreCase("Learn Js")&&price.equals("300")) {
			System.out.println("pass");
		}
		
		}
	}

}
