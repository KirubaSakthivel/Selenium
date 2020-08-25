package hottopic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://development-nam-hottopic.demandware.net/s/hottopic/account");
		driver.get("https://development-nam-hottopic.demandware.net/s/hottopic/product/funko-beetlejuice-pop-town-beetlejuice-with-dantes-inferno-room-vinyl-figures-hot-topic-exclusive/11990378.html?cgid=funko#start=6");
		driver.findElement(By.xpath("//button[@class='ui-dialog-titlebar-close']")).click();
		driver.manage().window().maximize();
		
		
		
		//driver.findElement(By.xpath("//a[@class='nav__item__link level-1 d-none d-lg-flex align-items-center w-100 h-100 px-2 text-dark'][contains(text(),'funko')]")).click();
		//driver.findElement(By.id("pVideo11990378")).click();
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.xpath("//span[@class='mini-cart-quantity text--bold']")).click();
		
		driver.findElement(By.name("dwfrm_cart_checkoutCart")).click();
		driver.findElement(By.xpath("//input[contains(@id,'dwfrm_login_username')]")).sendKeys("test12ht@gmail.com");
		driver.findElement(By.xpath("//input[@id='dwfrm_login_password']")).sendKeys("qatest123");
		driver.findElement(By.name("dwfrm_login_login")).click();
		
		
		//driver.findElement(By.name("dwfrm_singleshipping_shippingAddress_save")).click();
		driver.switchTo().frame("klarna-pay-over-time-main");
		driver.findElement(By.id("klarna-payment-type")).click();
		driver.findElement(By.id("cardNumber")).click();
		

	}

}
