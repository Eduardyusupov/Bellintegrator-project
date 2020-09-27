package ru.usupov.bellintegrator.four;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import ru.usupov.bellintegrator.two.CustomUtils;

public class Steps {
	
	@Step("Проверить что в шапке сайта есть определенные пункты меню")
	public void checkingLinks(PageObjectYandexPogoda pageObjectYandexPogoda, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObjectYandexPogoda.isThereTheSameLinks(), "Ссылки не совпадают");
	}
	
	@Step("В строку поиска город ввести частичное название 'Сергие'")
	public void rightSearchOrNot(PageObjectYandexPogodaWithResults pageObjectYandexPogodaWithResults, WebDriver driver) {
		CustomUtils.getScreen(driver);
		System.out.println(pageObjectYandexPogodaWithResults.getWordInSearch().getText().toString());
		Assertions.assertTrue(pageObjectYandexPogodaWithResults.rightSearchOrNot("Cергие"), "Поиск не прошел по фразе 'Сергие'");
	}
	
	@Step("Проверить что в предлагаемом списке есть 'Сергиев Посад, Москва и Московская область'")
	public void existingPhraseOrNot(PageObjectYandexPogodaWithResults pageObjectYandexPogodaWithResults, WebDriver driver) {
		CustomUtils.getScreen(driver);
		Assertions.assertTrue(pageObjectYandexPogodaWithResults.checkingExistingLinkOrNot("Сергиев Посад, Москва и Московская область"));
	}
	
	@Step("Cохранить как аттачмент для Allure Report текстовый файл в котором будет текущая температура")
	public void makingTxtFile(WebDriver driver) throws IOException {
		ru.usupov.bellintegrator.four.CustomUtils.getBytes(driver);
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
