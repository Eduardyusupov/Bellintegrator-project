package ru.usupov.bellintegrator.two;


import java.time.Duration;import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
	
	 WebDriver chromeDriver;
	 WebDriverWait wait; 
	
	@BeforeEach
	public void installSettings() {
		System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
		chromeDriver = new ChromeDriver();
		wait = new WebDriverWait(chromeDriver, 60);
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		chromeDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	
	@AfterEach
	public void closeBrowser() {
		//chromeDriver.quit();
	}

}
