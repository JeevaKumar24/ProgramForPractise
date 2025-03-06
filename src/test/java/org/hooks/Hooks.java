package org.hooks;

import java.time.Duration;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.property.Configurations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Configurations {
	String input1;
	String input2;
	String url;
	protected WebDriver driver;
	WebDriverWait wait;
	@Before
	public void initialize() {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 PageFactory.initElements(driver, this);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
	}

}
