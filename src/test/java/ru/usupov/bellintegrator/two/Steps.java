package ru.usupov.bellintegrator.two;

import org.junit.jupiter.api.Assertions;

import io.qameta.allure.Step;

public class Steps {
	
	@Step
	public static void choosePhonesOnMarket(PageObjectYandexMarketWithResults pageObject) {
		Assertions.assertTrue(pageObject.whatWordInSearch("Телефоны"));
	}
}
