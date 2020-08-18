package hottopic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.undo.StateEdit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingDataFromExcelHT {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://development-nam-hottopic.demandware.net/s/hottopic/account");
		driver.findElement(By.xpath("//button[@class='ui-dialog-titlebar-close']")).click();
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.id("header-sign-in")).click();
		//input[starts_with(@id,'dwfrm_login_username_d0uicuynmxgb')]
		
		driver.findElement(By.xpath("//input[contains(@id,'dwfrm_login_username')]")).sendKeys("test12ht@gmail.com");
		driver.findElement(By.xpath("//input[@id='dwfrm_login_password']")).sendKeys("qatest123");
		driver.findElement(By.name("dwfrm_login_login")).click();
		
		
		driver.findElement(By.xpath("//a[@href='https://development-nam-hottopic.demandware.net/s/hottopic/addressbook' and @title='Manage your billing and shipping addresses']")).click();
		
		
		//Getting data from excel sheet
		
		FileInputStream file= new FileInputStream("D:\\eclipse oxygen\\myPractice\\AddressBook-HT.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		int rowcount= sheet.getLastRowNum();
		
		System.out.println("No. of records in excel sheet= " + rowcount);
		
		for (int i=1; i<rowcount; i++)
		{
			driver.findElement(By.id("add-card")).click();
			XSSFRow currentrow= sheet.getRow(i);
			
			String Firstname= currentrow.getCell(0).getStringCellValue();
			String Lastname= currentrow.getCell(1).getStringCellValue();
			String Country= currentrow.getCell(2).getStringCellValue();
			String Zipcode= currentrow.getCell(3).toString();
			String StreetAddress1= currentrow.getCell(4).getStringCellValue();
			String City= currentrow.getCell(5).getStringCellValue();
			String State= currentrow.getCell(6).getStringCellValue();
			int PhoneNumber= (int)currentrow.getCell(7).getNumericCellValue();
			
			System.out.println(Firstname);
			System.out.println(Lastname);
			System.out.println(Country);
			System.out.println(Zipcode);
			System.out.println(StreetAddress1);
			System.out.println(City);
			System.out.println(State);
			System.out.println(PhoneNumber);
			
			driver.findElement(By.id("dwfrm_profile_address_firstname")).sendKeys(Firstname);
			driver.findElement(By.id("dwfrm_profile_address_lastname")).sendKeys(Lastname);
			//Select country= new Select(driver.findElement(By.id("dwfrm_profile_address_country")));
			//country.selectByVisibleText(Country);
			
			driver.findElement(By.id("dwfrm_profile_address_postal")).sendKeys(Zipcode);
			driver.findElement(By.id("dwfrm_profile_address_address1")).sendKeys(StreetAddress1);
			//driver.findElement(By.id("dwfrm_profile_address_city")).sendKeys(City);
			//Select state= new Select(driver.findElement(By.id("dwfrm_profile_address_states_state")));
			//state.selectByVisibleText(State);
			driver.findElement(By.id("formatted-phone")).sendKeys(String.valueOf(PhoneNumber));
			
			driver.findElement(By.name("dwfrm_profile_address_create")).click();
			
			System.out.println("Data entry is successful for:" + i);
			
		}
		
		driver.close();		

	}
	

}
