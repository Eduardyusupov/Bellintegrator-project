package ru.usupov.bellintegrator.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObjectYandexMarketWithResults {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;

	
	private String wordInSearchField;
	private String urlForAppleProducts;
	private WebElement checkBoxForApple;
	
	
	private String selectorAppleItem = "//div[@data-zone-name='SearchResults']//article";
	private String selectorDescriptionTag = ".//a[@class='_27nuSZ19h7 wwZc93J2Ao cia-cs' or @class='_2IwbFpEZn7 wwZc93J2Ao']//span ";
	
	private List<WebElement> searchAppleItems = new ArrayList<>();
	
	
	public PageObjectYandexMarketWithResults(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@action='/search']//input[@id='header-search']"))));
		wordInSearchField = driver.findElement(By.xpath("//form[@action='/search']//input[@id='header-search']")).getAttribute("value");
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(checkBoxForApple = driver.findElement(By.xpath("//span[contains(., 'Apple')]/ancestor::a"))));
		
	}
	
	public boolean whatWordInSearch(String word) {
		if(wordInSearchField.contentEquals(word)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickOnUrlCheckboxApple() throws InterruptedException {
		urlForAppleProducts = checkBoxForApple.getAttribute("href");
		driver.get(urlForAppleProducts);
		
	}
	
	public boolean isThereOnlyIphones(String word) throws InterruptedException {
		for(int i = 0; i < searchAppleItems.size() - 1; i++) {
			if(searchAppleItems.get(i).findElement(By.xpath(selectorDescriptionTag)).getText().contains(word)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	
	
	public void findAppleItems() {
		searchAppleItems = driver.findElements(By.xpath(selectorAppleItem));
	}
	
	public boolean isSelected() {
		return driver.findElement(By.xpath("//input[@name='Производитель Apple'] ")).isSelected();
	}
	
	
	
	
}
