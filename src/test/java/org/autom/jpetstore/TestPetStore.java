package org.autom.jpetstore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;



public class TestPetStore {
	
	WebDriver driver;
	@Before
	public void setUp() {
		if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
			options.addPreference("browser.tabs.remote.autostart", false);
			
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Formation\\Downloads\\geckodriver.exe");
		 driver = new FirefoxDriver(options);	}
		
		else if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Formation\\Documents\\chromedriver.exe");
		 driver = new ChromeDriver();		
		
		}
	
		driver.get("http://localhost:8888/jpetstore");
		
	}
		
	@Test
	public void petsStoreTest() throws InterruptedException {
	
		
		
		WebElement linkJPetStore = driver.findElement(By.linkText("Enter the Store"));
		
		linkJPetStore.click();
		
		Thread.sleep(3000);
		WebElement imageDisponible = driver.findElement(By.id("MainImageContent"));
		
		assert imageDisponible.isDisplayed();
		
		WebElement linkFish = driver.findElement(By.xpath("//div[@id='SidebarContent']/a"));
		linkFish.click();
		
		
		
	}
	@After
	public void endTest () {
		driver.close();
		
	}
}
