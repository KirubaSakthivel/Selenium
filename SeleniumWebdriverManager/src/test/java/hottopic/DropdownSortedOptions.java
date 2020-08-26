package hottopic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSortedOptions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// implicit wait
		
		driver.get("https://development-nam-hottopic.demandware.net/s/hottopic/account");
		driver.findElement(By.xpath("//button[@class='ui-dialog-titlebar-close']")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[contains(@id,'dwfrm_login_username')]")).sendKeys("test12ht@gmail.com");
		driver.findElement(By.xpath("//input[@id='dwfrm_login_password']")).sendKeys("qatest123");
		driver.findElement(By.name("dwfrm_login_login")).click();
		
		
		driver.findElement(By.xpath("//a[@href='https://development-nam-hottopic.demandware.net/s/hottopic/addressbook' and @title='Manage your billing and shipping addresses']")).click();
		driver.findElement(By.id("add-card")).click();
		
		WebElement element= driver.findElement(By.id("dwfrm_profile_address_country"));
		
		Select se= new Select(element);
		
		List OriginalList= new ArrayList();
		List TempList= new ArrayList();
		
		List <WebElement>options= se.getOptions();
		
		for(WebElement e:options) 
		{
			OriginalList.add(e.getText());
			TempList.add(e.getText());
			
		}
		
		System.out.println("OriginalList:" +OriginalList);
		System.out.println("TempList" +TempList);
		
		Collections.sort(TempList);
		
		System.out.println("sorted temp list:" +TempList);
		
		if(OriginalList==TempList)
		{
			System.out.println("Elements are sorted");
		}else
		{
			System.out.println("Elements are not sorted");
		}
		driver.close();
	}

}
