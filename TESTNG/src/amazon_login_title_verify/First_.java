package amazon_login_title_verify;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First_ {
  WebDriver d;
	@BeforeMethod
	public void setup()
	{
		ChromeOptions e=new ChromeOptions();
		e.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");	  
		d= new ChromeDriver();
		d.get("https://www.amazon.in/");
		 d.manage().window().maximize();
		 d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 d.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		 d.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("");  //add user email/ph.no details in send keys
		 d.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		 d.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(""); //add user password in this send key
		 d.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();		
	}
	
	@Test
	public void verifytitle()
	{
		String actualTitle=d.getTitle();
		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void teardown()
	{ 
	d.close();	
	}
}
