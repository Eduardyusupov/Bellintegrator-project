package ru.usupov.bellintegrator;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class Tests extends WebDriverSettings {
	
	@Test
	public void existLinkOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle pageObjectGoogle = new PageObjectGoogle(chromeDriver);
		pageObjectGoogle.findByWord("Гладиолус");
		pageObjectGoogle.putLinksToList();
		Assert.assertTrue(pageObjectGoogle.getLinks().stream().anyMatch(x-> x.getText().contains("Гладиолус - Википедия")));
	}
	
	@Test
	public void moreThanThreeLinksOrNot() {
		chromeDriver.get("https://www.google.ru/");
		PageObjectGoogle pageObjectGoogle = new PageObjectGoogle(chromeDriver);
		pageObjectGoogle.findByWord("Гладиолус");
		pageObjectGoogle.putLinksToList();
		Assert.assertTrue(pageObjectGoogle.checkingMoreThanThreeOrNot());
	}
	
	
	
	
}
