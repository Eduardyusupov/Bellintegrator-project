package ru.usupov.bellintegrator.two;

import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{
	
	@Test
	public void iphonesOnEveryPageOrNot() {
		PageObjectYandexMarket pageObjectYandexMarket = new PageObjectYandexMarket(chromeDriver);
		pageObjectYandexMarket.findByWord("Телефоны");
		PageObjectYandexMarketWithResults pageObjectYandexMarketWithResults = new PageObjectYandexMarketWithResults(chromeDriver);
		Steps.choosePhonesOnMarket(pageObjectYandexMarketWithResults);
	}
}
