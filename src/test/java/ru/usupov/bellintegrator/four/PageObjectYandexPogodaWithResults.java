package ru.usupov.bellintegrator.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectYandexPogodaWithResults {
	
	private WebDriver driver;
	
	private WebElement wordInSearch;
	private List<WebElement> links = new ArrayList<>();
	private Map<String, WebElement> webElements = new HashMap<>();
	
	public PageObjectYandexPogodaWithResults(WebDriver driver) {
		this.driver = driver;
		wordInSearch = driver.findElement(By.xpath("//div[@class='header-title']/h1"));
		links = driver.findElements(By.xpath("//div[@class='grid clearfix']//li[@class='place-list__item']//a"));
	}
	
	public boolean containsWordOrNot(String word) {
		if(wordInSearch.getText().contains(word)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickOnLink(String key) {
		fillingHashMap();
		webElements.get(key).click();
	}

	public boolean rightSearchOrNot(String word) {
		return  wordInSearch.getText().contains(word);
	}
	
	public boolean checkingExistingLinkOrNot(String phrase) {	
		return links.stream().anyMatch(x-> x.getText().contentEquals(phrase));
	}
	
	public List<WebElement> getLinks() {
		return links;
	}
	
	public WebElement getWordInSearch() {
		return wordInSearch;
	}
	
	private void fillingHashMap() {
		for(int i = 0; i < links.size(); i++) {
			webElements.put(links.get(i).getText(), links.get(i));
		}
	}

	
	
	
	
	
	
	
	
	
}
