import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		/* To make headless browser:
		ChromeOptions options= new ChromeOptions();
		options.setHeadless(true);   ---or--- options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);*/
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		
		
		//get methods:
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//String text= ((WebElement) driver.findElements(By.xpath("/html/body/div[3]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[1]/td/font/b")))
		//.getText();
		//System.out.println(text);

		WebElement username= driver.findElement(By.name("userName"));
		username.sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("Mercury");
		driver.findElement(By.name("submit")).click();
		String exptitle= "Login: Mercury Tours";
		String acttitle= driver.getTitle();
		if (exptitle.equals(acttitle))
		{
			System.out.println("login success");
		}else
		{
			System.out.println("login failed");
		}
		driver.close();

	}

}

