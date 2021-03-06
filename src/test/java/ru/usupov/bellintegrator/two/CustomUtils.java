package ru.usupov.bellintegrator.two;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class CustomUtils {
	
	@Attachment
	public static byte[] getScreen(WebDriver driver) {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("src/main/resources/screen.png"));
			return Files.readAllBytes(Paths.get("src/main/resources", "screen.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new byte[0];
	}
}
