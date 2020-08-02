package ru.usupov.bellintegrator.two;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class Steps {
	
	@Step("В яндекс маркете выбрать телефоны.")
	public static void choosePhonesOnMarket(PageObjectYandexMarketWithResults pageObject, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObject.whatWordInSearch("Телефоны"));
	}
}
