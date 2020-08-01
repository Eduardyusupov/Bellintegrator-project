package ru.usupov.bellintegrator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectGoogle1 {
	
	private WebDriver chromeDriver;
	WebElement searchField;
	String currentUrl;
	
	PageObjectGoogle1(WebDriver chromeDriver) {
		this.chromeDriver = chromeDriver;
		chromeDriver.get("https://www.google.ru/");
		this.currentUrl = chromeDriver.getCurrentUrl();
		searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		
	}
	
	public void findByWord(String word) {
		searchField.click();
		searchField.sendKeys(word);
		searchField.sendKeys(Keys.ENTER);
	}
	
	public boolean checkingLink(String link) {
		if(currentUrl.contentEquals(link)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	

	
	

}
