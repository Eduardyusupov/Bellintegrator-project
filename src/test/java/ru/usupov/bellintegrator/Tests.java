package ru.usupov.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Tests extends WebDriverSettings {
	
	@Test
	public void existLinkOrNot() {
		PageObjectGoogle1 pageObjectGoogle1 = new PageObjectGoogle1(chromeDriver);
		Steps.goOnGoogle(chromeDriver, pageObjectGoogle1);
		pageObjectGoogle1.findByWord("Гладиолус");
		PageObjectGoogle2 pageObjectGoogle2 = new PageObjectGoogle2(chromeDriver);
		Steps.existOrNotWordOnSearchField(chromeDriver, pageObjectGoogle2);
		Steps.sureExistLinkOrNot(pageObjectGoogle2, "Гладиолус - Википедия");
	}
	
	@Test
	public void moreThanThreeLinksOrNot() {
		PageObjectGoogle1 pageObjectGoogle1 = new PageObjectGoogle1(chromeDriver);
		Steps.goOnGoogle(chromeDriver, pageObjectGoogle1);
		pageObjectGoogle1.findByWord("Гладиолус");
		PageObjectGoogle2 pageObjectGoogle2 = new PageObjectGoogle2(chromeDriver);
		Steps.existOrNotWordOnSearchField(chromeDriver, pageObjectGoogle2);
		Steps.moreThanThreeLinksOrNot(pageObjectGoogle2);
	}
	
	
	
	
}
