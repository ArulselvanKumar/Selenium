package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		List <WebElement> tableheader=driver.findElements(By.xpath("//table[@id='taskTable']//th"));
		int cpuIndex=0;
		int memory =0;
		int memoryUsage=0;
		int nameIndex=0;
		int diskIndex=0;
		int networkIndex=0;
		
		for(int i=0;i<tableheader.size();i++) {
			if(tableheader.get(i).getText().contains("CPU")) {
				cpuIndex=i;
				break;
			}}
			List<WebElement>tablerows =driver.findElements(By.xpath("//table[@id='taskTable']//tr"));
			for(int j=1;j<tablerows.size();j++) {
		
			List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));
		
			if(col.get(0).getText().equalsIgnoreCase("Chrome")) {
				System.out.println(col.get(cpuIndex).getText());
				break;
			}
		
		}
			System.out.println("----------------------");
			
			
			for(int i=0;i<tableheader.size();i++) {
				if(tableheader.get(i).getText().contains("Memory")) {
					memory=i;
					break;
				}
				}
			for(int j=1;j<tablerows.size();j++) {
		
			List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));
		
			if(col.get(0).getText().equalsIgnoreCase("Firefox")) {
				System.out.println(col.get(memory).getText());
				break;
			}
		
			}
			
			System.out.println("----------------------");

			
			
			for(int i=0;i<tableheader.size();i++) {
				if(tableheader.get(i).getText().contains("CPU")) {
					cpuIndex=i;
					break;
				}
				}
			for(int j=1;j<tablerows.size();j++) {
				
				List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));
				String name = col.get(0).getText();
				String cpu = col.get(cpuIndex).getText();
				String cpuvalue = cpu.replace("%","").trim();
				double cpufinal = Double.parseDouble(cpuvalue);
			
				if(cpufinal<80) {
					System.out.println(name+"  is less than 80% cpu usage is   "+cpu);
				
				}else {
					System.out.println(name+"  is not less than 80% cpu usage is  "+cpu);
				}
			
				}
			
			
			System.out.println("----------------------");

			
			
		
			double max = 0;
			String Name = "";
			
			for(int i=0;i<tableheader.size();i++) {
				if(tableheader.get(i).getText().contains("Memory")) {
					memoryUsage=i;
					break;
				}
				}

			for(int j=1;j<tablerows.size();j++) {
				
				List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));
				String name = col.get(0).getText();
				String memText = col.get(memoryUsage).getText();
				String memvalue = memText.replace("MB","").trim();
				double memfinal = Double.parseDouble(memvalue);
			
				if(memfinal>max) {
					max=memfinal;
					Name = name;
				}
			}
					
					System.out.println("Highest memory usage is  "+Name+"("+max+"MB)");
		
	
					System.out.println("----------------------");

					
					
					
					for(int i=0;i<tableheader.size();i++) {
						String header =tableheader.get(i).getText();
						
						if(header.contains("Name")) {
							nameIndex=i;
						}else if(header.contains("Memory")) {
							memory=i;
						}else if(header.contains("Cpu")) {
							cpuIndex=i;
						}else if(header.contains("Network")) {
							networkIndex=i;
						}else if(header.contains("Disk")) {
							diskIndex=i;
						}
					}
					
					
					
					for(int j=1;j<tablerows.size();j++) {
						
						List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));		
						String name = col.get(nameIndex).getText();
						String Memory = col.get(memory).getText();
						String CPU = col.get(cpuIndex).getText();
						String Network = col.get(networkIndex).getText();
						String disk = col.get(diskIndex).getText();
						
						System.out.println("Name: "+name+" ,Memory: "+Memory+" ,CPU: "+CPU+" ,Network: "+Network+" ,disk: "+disk);
					}
					
					
					System.out.println("-------------------------------------");
					
					
					
					
					for(int i=0;i<tableheader.size();i++) {
						if(tableheader.get(i).getText().contains("CPU")) {
							cpuIndex=i;
							break;
						}
						}
					boolean result = true;

					for(int j=1;j<tablerows.size();j++) {
						
						List<WebElement> col = tablerows.get(j).findElements(By.tagName("td"));
						String name = col.get(0).getText();
						String cpu = col.get(cpuIndex).getText();
						String cpuvalue =cpu.replace("%","").trim();
						double c = Double.parseDouble(cpuvalue);

						if(c>80) {
							 result =false;
							break;
						}
					
					
					}				
					if(result) {
						System.out.println("Pass");
					}else {
						System.out.println("Fail");
					}
	}
}
