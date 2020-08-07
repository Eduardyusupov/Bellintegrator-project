package ru.usupov.bellintegrator.two;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectYandexMarket {
	
	WebDriver driver;
	WebElement searchField;
	
	
	public PageObjectYandexMarket(WebDriver driver) {
		this.driver = driver;
		driver.get("https://market.yandex.ru/");
		searchField = driver.findElement(By.xpath("//form[@action='/search']//input[@id='header-search']"));
	}
	
	public void findByWord(String word) throws InterruptedException {
		searchField.click();
		searchField.sendKeys(word);
		searchField.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
	}
	

}
