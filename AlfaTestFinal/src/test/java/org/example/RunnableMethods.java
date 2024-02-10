package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class RunnableMethods
{
	 
	 WebDriver driver = DriverLaunch.getWebDriver();
	 
	 protected void scrollToElement(WebElement newWebElement)
	 {
			Actions actions = new Actions(DriverLaunch.getWebDriver());
			try
			{
				 actions.moveToElement(newWebElement).perform();
			}
			catch (MoveTargetOutOfBoundsException e)
			{
				 try
				 {
						TimeUnit.SECONDS.sleep(1);
				 }
				 catch (InterruptedException q)
				 {
						System.out.println("Что-то не так с прогрузкой сайта");
				 }
			}
	 }
	 
	 protected void clickToElement(WebElement newWebElement)
	 {
			Actions actions = new Actions(DriverLaunch.getWebDriver());
			try
			{
				 actions.click(newWebElement).perform();
			}
			catch (MoveTargetOutOfBoundsException e)
			{
				 actions.click(newWebElement).perform();
			}
	 }
	 
	 protected void websiteLoadDelay(int seconds)
	 {
			try
			{
				 TimeUnit.SECONDS.sleep(seconds);
			}
			catch (InterruptedException e)
			{
				 System.out.println("Что-то не так с прогрузкой сайта");
				 throw new RuntimeException(e);
			}
			finally
			{
				 System.out.println("-Загрузка сайта-");
			}
	 }
	 
	 protected boolean isElementExists(By by)
	 {
			boolean isExists = true;
			try
			{
				 driver.findElement(by);
			}
			catch (NoSuchElementException e)
			{
				 isExists = false;
			}
			return isExists;
	 }
	 
}
