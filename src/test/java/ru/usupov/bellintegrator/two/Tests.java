package ru.usupov.bellintegrator.two;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tests extends WebDriverSettings{
	
	@Test
	public void iphonesOnEveryPageOrNot() throws InterruptedException {
		PageObjectYandexMarket pageObjectYandexMarket = new PageObjectYandexMarket(chromeDriver);
		pageObjectYandexMarket.findByWord("Телефоны");
		PageObjectYandexMarketWithResults pageObjectYandexMarketWithResults = new PageObjectYandexMarketWithResults(chromeDriver, wait);
		Steps.choosePhonesOnMarket(pageObjectYandexMarketWithResults, chromeDriver);
		pageObjectYandexMarketWithResults.clickOnUrlCheckboxApple();
		pageObjectYandexMarketWithResults.findAppleItems();
		Steps.selectIphoneFilter(pageObjectYandexMarketWithResults, chromeDriver);
		Steps.sureThereIsOnlyIphones(pageObjectYandexMarketWithResults, chromeDriver);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
