package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

public class DriverLaunch
				//TODO КЛАСС ДЛЯ ИНИЦИАЛИЗАЦИИ ДРАЙВЕРА
{
	 private static WebDriver driver;
	 
	 public void setUp()
	 {
			File file = searchFile(System.getProperty("user.dir"), "chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.toString());
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>()
			{{
				 put("profile.default_content_settings.popups", 0);
				 put("download.default_directory", System.getProperty("user.dir"));
				 put("plugins.always_open_pdf_externally", false);
				 put("pdfjs.disabled", true);
			}};
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			
			driver = new ChromeDriver(chromeOptions.setExperimentalOption("prefs", chromePrefs));
			
			getWebDriver().manage().window().maximize();
			getWebDriver().get("https://alfabank.ru/");
	 }
	 
	 public static WebDriver getWebDriver()
	 {
			return driver;
	 }
	 
	 public static File searchFile(final String rootFolder, final String fileName)
	 {
			File target = null;
			Path root = Paths.get(rootFolder);
			try (Stream<Path> stream = Files.find(root, Integer.MAX_VALUE, (path, attr) -> path.getFileName().toString().equals(fileName)))
			{
				 Optional<Path> path = stream.findFirst();
				 if (path.isPresent())
				 {
						target = path.get().toFile();
				 }
			} catch (IOException e)
			{
			}
			return target;
	 }
}
