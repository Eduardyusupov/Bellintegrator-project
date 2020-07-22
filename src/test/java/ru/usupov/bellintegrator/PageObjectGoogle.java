package ru.usupov.bellintegrator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectGoogle {
	private WebDriver chromeDriver;
	WebElement searchField;
	List<WebElement> links;
	
	PageObjectGoogle(WebDriver chromeDriver) {
		this.chromeDriver = chromeDriver;
		searchField = chromeDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
	}
	
	public void findByWord(String word) {
		searchField.click();
		searchField.sendKeys(word);
		searchField.sendKeys(Keys.ENTER);
	}
	
	public void putLinksToList() {
		links = chromeDriver.findElements(By.xpath("//*[@class=\"LC20lb DKV0Md\"]"));
	}
	
	public boolean checkingMoreThanThreeOrNot() {
		if(links.size() > 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<WebElement> getLinks() {
		return links;
	}
	
	

}
