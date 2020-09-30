package ru.usupov.bellintegrator.four;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Attachment;

public class PageObjectYandexPogodaSergie {
	
	private WebDriver driver;
	
	private WebElement pogodaSergie;
	
	public PageObjectYandexPogodaSergie(WebDriver driver) {
		this.driver = driver;
		pogodaSergie = driver.findElement(By.xpath("//div[@class='temp fact__temp fact__temp_size_s']//span[@class='temp__value']"));
	}
	
	@Attachment(type = "application/json", fileExtension = ".txt")
	public  byte[] getPogodaSergiePosad(WebDriver driver) throws IOException {
		
		return pogodaSergie.getText().getBytes();
	     
	}
	
	
	
	
	

}
