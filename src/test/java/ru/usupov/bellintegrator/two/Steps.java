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
	
	@Step("Установить фильтр айфоны")
	public static void selectIphoneFilter(PageObjectYandexMarketWithResults pageObject, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObject.isSelected());
	}
	
	@Step("Убедится что на всех страницах (если их несколько), присутствуют только айфоны.")
	public static void sureThereIsOnlyIphones(PageObjectYandexMarketWithResults pageObject, WebDriver driver) throws InterruptedException {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObject.isThereOnlyIphones("iPhone"));
	}
	
	
	
	
}
