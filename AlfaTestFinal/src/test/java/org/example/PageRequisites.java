package org.example;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRequisites
{
	 WebDriver driver = DriverLaunch.getWebDriver();
	 WebElement requisitesButton;
	 By requisitesButtonXPath = By.xpath("//span[contains(.,'ОГРН:')]");
	 
	 WebElement loanButton = driver.findElement(By.xpath("//a[@title='Кредиты']"));
	 
	 @Тогда("Пользователь подтверждает подлинность сайта")
	 public void userConfirmsCorrectWebsite()
	 {
			String correctOgrn = "1027700067328";
			String correctInn = "7728168971";
			requisitesButton = driver.findElement(requisitesButtonXPath);
			new RunnableMethods().websiteLoadDelay(1);
			loanButton.sendKeys(Keys.ESCAPE);
			new RunnableMethods().scrollToElement(requisitesButton);
			if (requisitesButton.getText().contains(correctOgrn) && requisitesButton.getText().contains(correctInn))
			{
				 System.out.println("Реквизиты банка корректные");
				 DriverLaunch.getWebDriver().get("https://alfabank.ru/");
			}
			else
			{
				 System.out.println("Что-то не так, возможно это не оригинальный сайт Альфа-Банк");
				 DriverLaunch.getWebDriver().quit();
			}
	 }
}
