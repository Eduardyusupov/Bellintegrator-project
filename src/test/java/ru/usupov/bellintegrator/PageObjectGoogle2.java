package ru.usupov.bellintegrator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectGoogle2 {
	
	private WebDriver chromeDriver;
	List<WebElement> links;
	
	PageObjectGoogle2(WebDriver chromeDriver) {
		this.chromeDriver = chromeDriver;
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
