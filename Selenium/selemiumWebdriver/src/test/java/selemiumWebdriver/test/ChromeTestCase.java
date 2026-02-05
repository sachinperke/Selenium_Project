package selemiumWebdriver.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriver driver=new ChromeDriver();
//
//		driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Faccounts.google.com%2F&dsh=S-1708463050%3A1770275062758972&followup=https%3A%2F%2Faccounts.google.com%2F&ifkv=AXbMIuCv911UjAkkLiQ9E3Rin-_7MWeuvBK3wdYoOUdht4jVv7zVUrQwy8mmdnyIOOZigxoYTTVzRQ&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//		
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sachinperke98@gmail.com");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
//		
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sachinperke123");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
//		
//		String actualText=driver.findElement(By.xpath("(//h1[@class='bjVOw'])[1]")).getText();
//		if(actualText=="sachin perke")
//		{
//			System.out.println("Login Successfully");
//		}
//		else
//		{
//			System.out.println("Login Unsuccessful");
//		}   // current window

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=12697211710724212122&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9301354&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='twotabsearchtextbox']")));
		
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Motorola mobiles");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow+" This is Parent ID");
		
		driver.findElement(By.xpath("//h2[contains(@aria-label,'Edge 60 Fusion 5G Smartphone')]")).click();
		for (String window : driver.getWindowHandles()) {
		    if (!window.equals(parentWindow)) {
		        driver.switchTo().window(window);
		        System.out.println(window+" This is Child ID");
		        break;
		    }
		}
		
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		
		String actualText=driver.findElement(By.xpath("//h1[normalize-space(text())='Added to cart']")).getText().trim();
		System.out.println(actualText);
		if(actualText=="Added to cart")
		{
			System.out.println("Product is successfully added");
		}
		else
		{
			System.out.println("Product is not added");
		}
	}

}
