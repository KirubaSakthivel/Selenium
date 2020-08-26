package hottopic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// implicit wait
		
		//driver.get("https://storefront:emo4life@staging.hottopic.com/account");// authentication popup
		
		driver.get("https://development-nam-hottopic.demandware.net/s/hottopic");
		driver.findElement(By.xpath("//button[@class='ui-dialog-titlebar-close']")).click();
		driver.manage().window().maximize();
		
		WebElement popculture= driver.findElement(By.xpath("//a[contains(@class,'nav__item__link level-1 d-none d-lg-flex align-items-center w-100 h-100 px-2 text-dark')][contains(text(),'pop culture')]"));
		WebElement Cartoons=driver.findElement(By.xpath("//div[contains(@class,'html-slot-container')]//a[contains(text(),'cartoons')]"));
		
		Actions act= new Actions(driver);
		
		act.moveToElement(popculture).moveToElement(Cartoons).click().build().perform();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
	}

}
