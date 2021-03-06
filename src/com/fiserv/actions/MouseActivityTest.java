package com.fiserv.actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActivityTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		
		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");

		driver.findElement(By.xpath("//input[@id='authUser']")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		Select selectLanguage=new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));
		
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Reports']")))
		.pause(Duration.ofSeconds(1))
		.moveToElement(driver.findElement(By.xpath("//div[text()='Clients']")))
		.build().perform();
		
		
		driver.findElement(By.xpath("//div[text()='List']")).click();
		
		//not recommended
//		action.moveToElement(driver.findElement(By.xpath("//div[text()='Reports']")))
//		.pause(Duration.ofSeconds(1))
//		.moveToElement(driver.findElement(By.xpath("//div[text()='Clients']")))
//		.pause(1000)
//		.moveToElement(driver.findElement(By.xpath("//div[text()='List']")))
//		.pause(Duration.ofSeconds(1))
//		.click()
//		.build().perform();
		

	}

}
