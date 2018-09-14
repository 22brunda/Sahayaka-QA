package com.qwinix.sahayaka.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qwinix.sahayaka.qa.BaseDriver;


public class LoginPage {
	
	public LoginPage() 
	{
		PageFactory.initElements(BaseDriver.driver, this);
	}
	
	@FindBy(id="username")
	public WebElement username;

	@FindBy(id="inputPassword")
	public WebElement phonenumber;
	
	@FindBy(xpath="//button[contains(.,'Sign In')]")
	public WebElement LogIn;

}
