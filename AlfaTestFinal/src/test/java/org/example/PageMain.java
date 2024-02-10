package org.example;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMain

{
	 WebDriver driver = DriverLaunch.getWebDriver();
	 WebElement requisitesButton = driver.findElement(By.xpath("//a[contains(@title,'Реквизиты')]"));
	 WebElement loanButton = driver.findElement(By.xpath("//a[@title='Кредиты']"));
	 
	 @BeforeAll
	 public static void before_all()
	 {
			new DriverLaunch().setUp();
	 }
	 
	 @AfterAll
	 public static void after_all()
	 {
			int resultPassed = Hooks.getResultPassed();
			int resultFailed = Hooks.getResultFailed();
			if (resultFailed > 0)
			{
				 System.out.println("Тестов пройдено - " + resultPassed);
				 System.out.println("Тестов провалено - " + resultFailed);
			}
			else
			{
				 System.out.println("Тестов пройдено - " + resultPassed);
				 System.out.println("Тестов провалено - " + resultFailed);
				 DriverLaunch.getWebDriver().quit();
			}
	 }
	 
	 
	 @Дано("Пользователь находится на главной странице")
	 public void userOnMainPage()
	 {
			System.out.println("Пользователь находится на главной странице " + driver.getCurrentUrl());
			new RunnableMethods().websiteLoadDelay(1);
			loanButton.sendKeys(Keys.ESCAPE);
	 }
	 
	 @Когда("Пользователь нажимает кнопу \"Реквизиты\"")
	 public void userClickRequisitesButton()
	 {
			new RunnableMethods().scrollToElement(requisitesButton);
			new RunnableMethods().clickToElement(requisitesButton);
			System.out.println("Пользователь проверяет подлинность сайта");
	 }
	 
	 @Дано("Пользователь находится на главной странице после проверки подлинности сайта")
	 public void userOnMainPageAfterWebsiteCheck()
	 {
			new RunnableMethods().websiteLoadDelay(1);
			loanButton.sendKeys(Keys.ESCAPE);
			System.out.println("После проверки реквизитов, пользователь вернулся на главную страницу " + driver.getCurrentUrl());
	 }
	 
	 @Когда("Пользователь нажимает кнопку \"Кредиты\"")
	 public void userClickLoanButton()
	 {
			new RunnableMethods().clickToElement(loanButton);
			System.out.println("Пользователь переходит на вкладку \"Кредиты\"");
	 }
}
