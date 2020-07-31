package ru.usupov.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Tests extends WebDriverSettings {
	
	@Test
	public void existLinkOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle1 pageObjectGoogle1 = new PageObjectGoogle1(chromeDriver);
		pageObjectGoogle1.findByWord("Гладиолус");
		PageObjectGoogle2 pageObjectGoogle2 = new PageObjectGoogle2(chromeDriver);
		Assertions.assertTrue(pageObjectGoogle2.getLinks().stream().anyMatch(x-> x.getText().contains("Гладиолус - Википедия")));
	}
	
	@Test
	public void moreThanThreeLinksOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle1 pageObjectGoogle = new PageObjectGoogle1(chromeDriver);
		pageObjectGoogle.findByWord("Гладиолус");
		PageObjectGoogle2 pageObjectGoogle2 = new PageObjectGoogle2(chromeDriver);
		Assertions.assertTrue(pageObjectGoogle2.checkingMoreThanThreeOrNot());
	}
	
	
	
	
}
