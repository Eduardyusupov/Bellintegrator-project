package ru.usupov.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Tests extends WebDriverSettings {
	
	@Test
	public void existLinkOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle pageObjectGoogle = new PageObjectGoogle(chromeDriver);
		pageObjectGoogle.findByWord("Гладиолус");
		pageObjectGoogle.putLinksToList();
		Assertions.assertTrue(pageObjectGoogle.getLinks().stream().anyMatch(x-> x.getText().contains("Гладиолус - Википедия")));
	}
	
	@Test
	public void moreThanThreeLinksOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle pageObjectGoogle = new PageObjectGoogle(chromeDriver);
		pageObjectGoogle.findByWord("Гладиолус");
		pageObjectGoogle.putLinksToList();
		Assertions.assertTrue(pageObjectGoogle.checkingMoreThanThreeOrNot());
	}
	
	
	
	
}
