package com.insight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insight.base.BaseClass;

public class Signin extends BaseClass {
	
	
	
		
		public Signin(WebDriver rdriver)
		{
			driver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy (id="email") private WebElement email;
		@FindBy (id="pass") private WebElement password;
		@FindBy (xpath="//button[@type='submit']") private WebElement loginButton;
		@FindBy (xpath="//a[text()='Forgotten password?']") private WebElement forgotPassword;
		@FindBy (xpath="//a[@data-testid='open-registration-form-button']") private WebElement createNewAccountButton;
		
		public Signin enterEmail(String text)
		{
			sendKeys(email, "sumit.sjoshi26@gmail.com");
			System.out.println("Entered email address");
			return this;
		}
		
		public Signin enterPassword(String text)
		{
			sendKeys(password, "Pooja@123");
			System.out.println("Entered Password");
			return this;
		}
		
		public Signin clickOnLoginButton()
		{
			click(loginButton);
			System.out.println("Clicked login Button");
			return this;
		}
		
		public Signin clickOnForgotPassword()
		{
			click(forgotPassword);
			System.out.println("Clicked forgot password");
			return this;
		}
		
		public Signin clickOnCreateNewAccountButton()
		{
			click(createNewAccountButton);
			System.out.println("Clicked create New account button");
			return this;

}
	}

