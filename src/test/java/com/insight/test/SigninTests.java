package com.insight.test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insight.base.BaseClass;
import com.insight.pages.Signin;


public class SigninTests extends BaseClass {
	
public static Signin signin;
public static WebDriver driver; 
	
	@BeforeMethod
	public void beforeMethod(Method m) throws Exception
	{
		driver=initalizeBrowser("facebookurl");
		System.out.println("**Starting Test**"+m.getName()+"****");
	}
	
	@Test
	public void loginWithValidCredentials()
	{   
		signin = new Signin(driver);
		signin.enterEmail("sumit.sjoshi26@gmail.com");
		signin.enterPassword("Pooja@123");
		signin.clickOnLoginButton();
	}

}
