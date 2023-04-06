package com.HybridDrivenFramework.classes;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HDFExample {

	public static void main(String[] args) {
		try {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileInputStream fis = new FileInputStream("C:\\Users\\sasir\\OneDrive\\Desktop\\Sasi\\Workspace\\HybridDrivenFramework\\src\\com\\HybridDrivenFramework\\classes\\input.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String url = p.getProperty("url");
			String principal_amount = p.getProperty("principal_amount");
			String rate_of_interest = p.getProperty("rate_of_interest");
			String desired_time = p.getProperty("desired_time");
			
			String General_Math_Locator = p.getProperty("General_Math_Locator");
			String topicItem_Locator = p.getProperty("topicItem_Locator");
			String principal_Locator = p.getProperty("principal_Locator");
			String interest_Locator = p.getProperty("interest_Locator");
			String desired_time_Locator = p.getProperty("desired_time_Locator");
			String Button_Locator = p.getProperty("Button_Locator");
			
			String dropdown_value = p.getProperty("dropdown_value");
			
			
			driver.get(url);
			driver.findElement(By.linkText(General_Math_Locator)).click();
			Thread.sleep(3000);
			
			Select select = new Select(driver.findElement(By.name(topicItem_Locator)));
			select.selectByVisibleText(dropdown_value);
			Thread.sleep(3000);
			driver.findElement(By.name(principal_Locator)).sendKeys(principal_amount);
			Thread.sleep(3000);
			driver.findElement(By.name(interest_Locator)).sendKeys(rate_of_interest);
			Thread.sleep(3000);
			driver.findElement(By.name(desired_time_Locator)).sendKeys(desired_time);
			Thread.sleep(3000);
			driver.findElement(By.xpath(Button_Locator)).click();
			Thread.sleep(3000);
			driver.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}


	}

}
