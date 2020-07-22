package ru.usupov.bellintegrator;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
	
	WebDriver chromeDriver;
	
	
	@Before
	public void installSettings() {
		System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
		
	}

}
