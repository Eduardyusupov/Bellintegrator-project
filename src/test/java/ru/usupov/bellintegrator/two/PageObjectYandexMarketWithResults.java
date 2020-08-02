package ru.usupov.bellintegrator.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectYandexMarketWithResults {
	
	WebDriver driver;
	String wordInSearchField;
	
	public PageObjectYandexMarketWithResults(WebDriver driver) {
		this.driver = driver;
		wordInSearchField = driver.findElement(By.xpath("//form[@action='/search']//input[@id='header-search']")).getAttribute("value");
	}
	
	public boolean whatWordInSearch(String word) {
		if(wordInSearchField.contentEquals(word)) {
			return true;
		} else {
			return false;
		}
	}
}
