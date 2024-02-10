package org.example;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PagePrivateInfoEnter
{
	 WebDriver driver = DriverLaunch.getWebDriver();
	 
	 WebElement noButton;
	 By noButtonXPath = By.xpath("//span[contains(.,'Нет')]");
	 
	 WebElement feedbackButton;
	 By feedbackButtonXpath = By.xpath("//button[contains(.,'Оставьте отзыв')]");
	 
	 
	 @Дано("Пользователю задают дополнительные вопросы")
	 public void userGetAddQuestions()
	 {
			System.out.println("Пользователь не помнит пароль от Госуслуг");
	 }
	 
	 @Когда("Пользователь отвечает на вопросы")
	 public void userReplyQuestions()
	 {
			new RunnableMethods().websiteLoadDelay(1);
			
			if (new RunnableMethods().isElementExists(noButtonXPath))
			{
				 noButton = driver.findElement(noButtonXPath);
				 new RunnableMethods().clickToElement(noButton);
			}
			System.out.println("Пользователь недоволен необходимостью ввода персональных данных, таких как номер паспорта и дата рождения.");
	 }
	 
	 @Тогда("Пользователь решет оставить отзыв")
	 public void userLeavesFeedback()
	 {
			feedbackButton = driver.findElement(feedbackButtonXpath);
			new RunnableMethods().scrollToElement(feedbackButton);
			new RunnableMethods().clickToElement(feedbackButton);
			System.out.println("Пользователь не находит возможности оставить онлайн-отзыв и решает воспользоваться услугами другого банка.");
	 }
	 
}
