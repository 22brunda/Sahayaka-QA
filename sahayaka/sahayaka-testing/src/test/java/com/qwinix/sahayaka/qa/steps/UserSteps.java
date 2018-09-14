package com.qwinix.sahayaka.qa.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qwinix.sahayaka.qa.BaseDriver;

import com.qwinix.sahayaka.qa.page.LoginPage;

public class UserSteps {
	 
	public static WebDriver driver = BaseDriver.driver;
	ConfigReader config = new ConfigReader();
	LoginPage objLP = new LoginPage();
	CommonUtil objCU = new  CommonUtil();

	public void openUrl() {
		driver.get(config.getUrl());
	    driver.manage().window().maximize();
	}
	
	public void Login() {
		
		objLP.email.sendKeys("uvenkatesh@qwinix.io");
		objLP.password.sendKeys("Password@1");
		objLP.SignIn.click();
	}
	

	public void verifyLogin() throws InterruptedException {

		Thread.sleep(10000);
		String actual = driver.findElement(By.xpath("//nav/div[2][contains(.,'QAcommunity')]")).getText();
		System.out.println("actualvalue is = "+actual);
	    Assert.assertEquals("QAcommunity", actual);
	}		
	
	public void logout() throws InterruptedException {
		objCU.waitForPageLoaded();
		CommonUtil.waitForElement(objLP.navbar);
//		objLP.navbar.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", objLP.navbar);
		CommonUtil.waitForElement(objLP.logout);
		objLP.logout.click();
		objCU.waitForPageLoaded();
	}

}