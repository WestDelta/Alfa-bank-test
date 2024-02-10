package org.example;

import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLoan
{
	 WebDriver driver = DriverLaunch.getWebDriver();
	 String loanPageUrl = "https://alfabank.ru/get-money/";
	 WebElement applyForALoan = driver.findElement(By.xpath("//a[@href=\"/get-money/credit/credit-cash-adv/step1/?platformId=alfasite\"]"));
	 
	 @Тогда("Пользователь находится на вкладке \"Кредиты\"")
	 public void userOnPageLoan()
	 {
			new RunnableMethods().websiteLoadDelay(1);
			applyForALoan.sendKeys(Keys.ESCAPE);
			if (driver.getCurrentUrl().equals(loanPageUrl))
			{
				 System.out.println("Пользователь находится на вкладке \"Кредиты\"");
			}
			else
			{
				 System.out.println("Что-то не так, перепроверьте доступность объектов WebElement");
			}
	 }
	 
	 @Дано("Пользоватекль определяется с видом кредита и выбирает кредит наличными")
	 public void userChoosesCash()
	 {
			System.out.println("Пользователь выбрал наличку");
	 }
	 
	 @Тогда("Пользователь нажимает кнопку \"Оформить кредит\"")
	 public void userClickApplyButton()
	 {
			new RunnableMethods().clickToElement(applyForALoan);
			System.out.println("Пользователь переходит к оформлению заявки");
	 }

}
