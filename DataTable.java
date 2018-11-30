package seleniumpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		//loads the Firefox Driver
		WebDriver driver =new FirefoxDriver();
		//Opens http://datatables.net page
		driver.get("http://datatables.net");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//taking the list of rows from the table in the page
		List<WebElement> rowList=driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		// taking the Rows size - finding the no of rows
		int Rsize=rowList.size();
		//taking the list of Columns from the table in the page
		List<WebElement> clmns=driver.findElements(By.xpath("//table[@id='example']/tbody/tr[1]/td"));
		//taking the column size - finding the no of columns
		int Csize=clmns.size();
		System.out.println("Number of Rows from the table in page 1 - "+Rsize);
		System.out.println("Number of Columns from the table in page 1 - "+Csize);
		int total=0;
		
		for(int i=1;i<=Rsize;i++)
		{
			int j=i+1;
			WebElement nameEle=driver.findElement(By.xpath("//table[@id='example']/tbody/tr["+i+"]/td[1]"));
			//this will click on the name, so that the salary row will be visible
			nameEle.click();
			//passing the Salary in to an WebElement
			WebElement salEle=driver.findElement(By.xpath("(//table[@id='example']/tbody/tr["+j+"]/td[1]/descendant::span)[2]"));	
			//getting the Salary
			String salary=salEle.getText().trim().replace("$", "").replace(",", "");
			//adding to the Total by converting the Salary in to Integer
			total=total+Integer.parseInt(salary);
			nameEle.click();										
		}
		System.out.println("Total of Salary in Page 1 = "+total);
		Thread.sleep(3000);
		driver.quit();
	}

}
