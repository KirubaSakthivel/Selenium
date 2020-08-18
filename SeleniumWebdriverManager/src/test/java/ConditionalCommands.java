
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalCommands {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
				
		WebElement email= driver.findElement(By.name("userName"));
		WebElement password= driver.findElement(By.name("password"));
		
		if (email.isDisplayed() && email.isEnabled())
		{
			email.sendKeys("test12ht@gmail.com");
		}
		
		if(password.isDisplayed() && password.isEnabled())
		{
			password.sendKeys("qatest123");
		}
		
		/*WebElement checkbox= driver.findElement(By.xpath("//*[@id=\"dwfrm_login\"]/fieldset/div[4]/div/label"));
		
		if(checkbox.isSelected()==true)
		{
			System.out.println("Checkbox is selected");
		}*/

	}

}
