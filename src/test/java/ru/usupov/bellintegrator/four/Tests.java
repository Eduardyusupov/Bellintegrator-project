package ru.usupov.bellintegrator.four;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{
	
	@Test
	public void sameLinksOrNot() {
		Steps steps = new Steps();
		PageObjectYandexPogoda pageObjectYandexPogoda = new PageObjectYandexPogoda(chromeDriver);
		steps.checkingLinks(pageObjectYandexPogoda, chromeDriver);
	}
	
	@Test
	public void temperatureOfCity() throws InterruptedException, IOException {
		Steps steps = new Steps();
		PageObjectYandexPogoda pageObjectYandexPogoda = new PageObjectYandexPogoda(chromeDriver);
		pageObjectYandexPogoda.findByWord("Cергие");
		PageObjectYandexPogodaWithResults pageObjectYandexPogodaWithResults = new PageObjectYandexPogodaWithResults(chromeDriver);
		steps.existingPhraseOrNot(pageObjectYandexPogodaWithResults, chromeDriver);
		pageObjectYandexPogodaWithResults.clickOnLink("Сергиев Посад, Москва и Московская область");
		steps.makingTxtFile(chromeDriver);
		
		
		
		
	}
}
