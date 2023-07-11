package testing;



import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddMedicineTest {
	 WebDriver driver;
	 @BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lokesh\\Downloads\\chromedriver_win32\\chromeDriver.exe");
			driver =  new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
			driver.get("http://localhost:4200/admin/login");
		}
	
	 @Test
		public  void addmedicine() throws InterruptedException {
			driver.findElement(By.name("username")).sendKeys("lokeshaditya@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Lokesh@2721");
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(1000L);
			driver.get("http://localhost:4200/admin-dashboard");
		    WebElement Element=driver.findElement(By.name("addmedicine"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			driver.findElement(By.name("addmedicine")).click();
			driver.findElement(By.id("1")).click();
			driver.findElement(By.name("name")).sendKeys("paracetamol");
			driver.findElement(By.name("brand")).sendKeys("IPCA laboratory");
			driver.findElement(By.name("category")).sendKeys("Urology");
			driver.findElement(By.name("description")).sendKeys("Acetaminophen");
			driver.findElement(By.name("salt")).sendKeys(" C8H9NO2");
			WebElement Element1=driver.findElement(By.name("totalAvailable"));
			js.executeScript("arguments[0].scrollIntoView();", Element1);
			driver.findElement(By.name("totalAvailable")).sendKeys("150");
			
			WebElement Element2=driver.findElement(By.name("price"));
			js.executeScript("arguments[0].scrollIntoView();", Element2);
			driver.findElement(By.name("price")).sendKeys("10");
			
			WebElement Element3=driver.findElement(By.id("img"));
			js.executeScript("arguments[0].scrollIntoView();", Element3);
		    Element3.sendKeys("C:\\Users\\lokesh\\Desktop\\final\\pharmacy\\medi-care\\src\\assets\\Images\\all-medicines.png");
		    driver.findElement(By.name("add")).click();
		    Thread.sleep(1000L);
		    Thread.sleep(1000L);
		    driver.findElement(By.name("close")).click();
		    Thread.sleep(1000L);
			driver.get("http://localhost:4200/admin-dashboard");
			assertEquals(driver.getCurrentUrl(), "http://localhost:4200/admin-dashboard");

		}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}