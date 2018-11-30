package seleniumpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class amazon {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//navigating to AMAZON page from the driver
		driver.navigate().to("http://amazon.in");
		//passing the search Textbox to the webelement
		WebElement searchTxtEle=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchTxtEle.click();
		//passing the text "laptops" to searchbox
		searchTxtEle.sendKeys("laptops");
		Thread.sleep(3000);
		//finding the search click and passing to webelement
		WebElement searchEle =driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		searchEle.click();
		//getting the list of elements with tagname = a
		List<WebElement> linksEle=driver.findElements(By.tagName("a"));
		//getting the total no of links available
		int noOfLinks=linksEle.size();
		
		System.out.println("Total number of links in the page - "+noOfLinks);
		//loop for printing the links and text 
		for(int i=0;i<noOfLinks;i++)
		{
			WebElement linkEle= linksEle.get(i);
			
			String link=linkEle.getAttribute("href");
			System.out.println(link);
			
			String text= linkEle.getText();
			System.out.println(text);
			
		}
	}

}
