package com.john.sandbox;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App {

	private WebDriver driver = null;
	
	protected void initializeDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		//File modifyHeaders = new File(System.getProperty("user.dir")
		//		+ "/resources/modify_headers.xpi");
		profile.setEnableNativeEvents(false);
//		try {
//			profile.addExtension(modifyHeaders);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		profile.setPreference("modifyheaders.headers.count", 1);
		profile.setPreference("modifyheaders.headers.action0", "Add");
		profile.setPreference("modifyheaders.headers.name0", "X-Forwarded-For");
		profile.setPreference("modifyheaders.headers.value0", "2.160.0.0");
		profile.setPreference("modifyheaders.headers.enabled0", true);
		profile.setPreference("modifyheaders.config.active", true);
		profile.setPreference("modifyheaders.config.alwaysOn", true);

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);

		driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.initializeDriver();
		app.doIt();
	}
	
	private void doIt() {
		
		// declaration and instantiation of objects/variables
		String baseUrl = "http://infinity.disney.com";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);
		
		driver.findElement(By.cssSelector("#ok-cookie > div.label")).click();
		
		driver.findElement(By.cssSelector("#account-sidebar > a.disneyid-login.did-click-zone")).click();
	    
		driver.switchTo().frame("content");
		
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame | disneyid-iframe | ]]
	    new Select(driver.findElement(By.id("birthdate-month"))).selectByVisibleText("February");
	    new Select(driver.findElement(By.id("birthdate-day"))).selectByVisibleText("3");
	    new Select(driver.findElement(By.id("birthdate-year"))).selectByVisibleText("2012");
	    driver.findElement(By.id("create-account-from-login")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("sflkm23lkm2l3k44r");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("stupid911");
	    driver.findElement(By.id("password-check")).clear();
	    driver.findElement(By.id("password-check")).sendKeys("stupid911");
	    driver.findElement(By.id("parentEmail")).clear();
	    driver.findElement(By.id("parentEmail")).sendKeys("sflkm23lkm2l3k44r@mailinator.com");
	    driver.findElement(By.id("firstName")).clear();
	    driver.findElement(By.id("firstName")).sendKeys("John");
	    new Select(driver.findElement(By.id("gender"))).selectByVisibleText("Male");
	    driver.findElement(By.name("terms")).click();
	    driver.findElement(By.id("create-account")).click();
	    driver.findElement(By.id("btnEmailParent")).click();
	    driver.findElement(By.xpath("//div[@id='btnOk']/button")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.id("impliedsubmit")).click();
	    driver.findElement(By.id("inboxfield")).clear();
	    driver.findElement(By.id("inboxfield")).sendKeys("sflkm23lkm2l3k44r");
	    driver.findElement(By.cssSelector("btn.btn.btn-success")).click();
	    driver.findElement(By.cssSelector("div.subject.ng-binding")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | rendermail | ]]
	    driver.findElement(By.linkText("Approve this request")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
	    driver.findElement(By.linkText("Continue to Disney Infinity »")).click();
		
		
		
		
		

		// close Firefox
		driver.close();

		// exit the program explicitly
		System.exit(0);
	}
}
