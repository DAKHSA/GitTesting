package GoogleTitle;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class simpleGoogleTest {
	
	
	static public WebDriver driver ;
	@BeforeTest
	public void simpleGoogleTester() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement r = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='gbw']/div/div/div[1]/div[2]/a"))));
		r.click();
		TakesScreenshot screen = (TakesScreenshot)driver;
		File file = screen.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//src//test//resources//scan.pnj";
		FileUtils.copyFile(file, new File(path));		
		
		}
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	@Test
	public void Result() {
		System.out.println(getTitle());
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
