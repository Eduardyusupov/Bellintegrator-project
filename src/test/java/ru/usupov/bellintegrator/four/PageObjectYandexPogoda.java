package ru.usupov.bellintegrator.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectYandexPogoda {
	
	private WebDriver driver;
	
	private WebElement searchField;
	
	private List<String> menuLinksMustBe = Arrays.asList("Прогноз на 10 дней",
			                                     "Прогнозище",
			                                     "Прогноз на месяц",
			                                     "Погода на карте",
			                                     "Прогноз вселенной");
	private List<WebElement> menuLinksExactly = new ArrayList<>();
	
	
	public PageObjectYandexPogoda(WebDriver driver) {
		this.driver = driver;
		driver.get("https://yandex.ru/pogoda/moscow");
		menuLinksExactly = driver.findElements(By.xpath("//div[@class='yandex-header__nav yandex-header__item']/a/span"));
		searchField = driver.findElement(By.xpath("//form[@action='/pogoda/search']//input"));
	}
	
	public boolean isThereTheSameLinks() {
		for(int i = 0; i < menuLinksMustBe.size(); i++) {
			if(menuLinksMustBe.get(i).contentEquals(menuLinksExactly.get(i).getText())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
		 
	}
	
	public void findByWord(String word) throws InterruptedException {
		searchField.click();
		searchField.sendKeys(word);
		searchField.sendKeys(Keys.ENTER);
	}
	
	
	
	
	
	
	
	
	
	
}
