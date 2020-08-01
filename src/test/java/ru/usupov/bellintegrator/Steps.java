package ru.usupov.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class Steps {
	
	@Step("Шаг 1. Перейти на сайт google.ru")
	public static void goOnGoogle(WebDriver chromeDriver, PageObjectGoogle1 pageObject) {
		CustomUtils.getScreen(chromeDriver);
		Assertions.assertTrue(pageObject.checkingLink("https://www.google.ru/"), "Не та открытая страница");
		
	}
	
	@Step("Шаг 2. Выполнить поиск по слову 'Гладиолус'")
	public static void existOrNotWordOnSearchField(WebDriver chromeDriver, PageObjectGoogle2 pageObject) {
		Assertions.assertTrue(pageObject.rightWordOnPageOrNot("Гладиолус"), "Осуществлен поиск не потому слову");
		
	}
	
	@Step("Шаг 3. Убедится что есть ссылка 'Гладиолус - Википедия' ")
	public static void sureExistLinkOrNot(PageObjectGoogle2 pageObject, String link, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObject.getLinks()
				.stream().anyMatch(x-> x.getText().contains(link)), "Указанной ссылки не существует");
	}
	
	@Step("Шаг 3. Убедится что результатов больше трёх")
	public static void moreThanThreeLinksOrNot(PageObjectGoogle2 pageObject, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObject.checkingMoreThanThreeOrNot(), "Ссылок меньше либо равно 3");
	}

}
