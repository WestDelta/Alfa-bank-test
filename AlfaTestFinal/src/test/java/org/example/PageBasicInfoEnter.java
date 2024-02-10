package org.example;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBasicInfoEnter
{
	 WebDriver driver = DriverLaunch.getWebDriver();
	 
	 WebElement continueButton = driver.findElement(By.xpath("//span[contains(.,'Продолжить')]"));
	 WebElement phoneNumber = driver.findElement(By.xpath("//input[contains(@data-test-id,'phoneInput')]"));
	 WebElement eMail = driver.findElement(By.xpath("//input[contains(@data-test-id,'email-input')]"));
	 WebElement personalDataProcessing = driver.findElement(By.xpath("//p[contains(.,'персональных данных')]"));
	 WebElement advAccept = driver.findElement(By.xpath("//p[contains(.,'рекламную информацию')]"));
	 WebElement fullName = driver.findElement(By.xpath("//input[contains(@name,'fullName')]"));
	 
	 WebElement regularName;
	 By regularNameXpath = By.xpath("//input[contains(@data-test-id,'form-fio-first-name')]");
	 
	 WebElement fatherName;
	 By fatherNameXPath = By.xpath("//input[contains(@data-test-id,'form-fio-middle-name')]");
	 
	 WebElement genderMale;
	 By genderMaleXPath = By.xpath("//button[@data-test-id='sex-m']");
	 
	 WebElement xButton;
	 By xButtonXPath = By.xpath("//button[contains(@aria-label,'закрыть')]");
	 
	 @Тогда("Пользователь вводит персональные данные")
	 public void userEntersPersonalDeta()
	 {
			new RunnableMethods().scrollToElement(fullName);
			new RunnableMethods().clickToElement(fullName);
			fullName.sendKeys("Перейра");
			fullName.sendKeys(Keys.TAB);
			new RunnableMethods().scrollToElement(continueButton);
			new RunnableMethods().clickToElement(phoneNumber);
			regularName = driver.findElement(regularNameXpath);
			new RunnableMethods().clickToElement(regularName);
			regularName.sendKeys("Себастьян");
			fatherName = driver.findElement(fatherNameXPath);
			fatherName.sendKeys("Торговец черным деревом");
			phoneNumber.sendKeys("9035553535");
			eMail.sendKeys("Negoro@trader.com");
			new RunnableMethods().scrollToElement(continueButton);
			new RunnableMethods().clickToElement(genderMale = driver.findElement(genderMaleXPath));
			new RunnableMethods().clickToElement(personalDataProcessing);
			new RunnableMethods().clickToElement(advAccept);
			new RunnableMethods().clickToElement(continueButton);
			new RunnableMethods().websiteLoadDelay(2);
			if (new RunnableMethods().isElementExists(xButtonXPath))
			{
				 xButton = driver.findElement(xButtonXPath);
				 new RunnableMethods().clickToElement(xButton);
			}
	 }
}
