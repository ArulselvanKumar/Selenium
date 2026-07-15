package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.id("alertBtn")).click();
		Alert popup = driver.switchTo().alert();
		String a = popup.getText();
		System.out.println(a);
		popup.accept();
		
		driver.findElement(By.id("confirmBtn")).click();
		Alert confirmPopup = driver.switchTo().alert();
		String c = confirmPopup.getText();
		System.out.println(c);
		confirmPopup.dismiss();
		
		if(c.equalsIgnoreCase("Press a button!")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		driver.findElement(By.id("promptBtn")).click();
		Alert Prompt = driver.switchTo().alert();
		String p = Prompt.getText();
		System.out.println(p);
		String myname = "Arulselvan";
		Prompt.sendKeys(myname);
		System.out.println(myname);
		Prompt.accept();
		
		if(myname.equals("Arulselvan")) {
			System.out.println("Pass");
		}else {
			System.out.println("fail");
		}
		
		driver.quit();
	}

}
