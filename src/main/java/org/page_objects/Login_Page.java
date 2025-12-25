package org.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility_package.Helper;

public class Login_Page extends Helper {


	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement Username;

	public WebElement getUsername() {
		return Username;
	}

	@FindBy(id="password")
	private WebElement Password;
	
	
	public WebElement getPassword() {
		return Password;
	}
	
	@FindBy(id="login")
	private WebElement Login_btn;

	public WebElement getLogin_btn() {
		return Login_btn;
	}
	
	@FindBy(xpath="//img[@alt='AdactIn Group']")
	private WebElement Logo;

	public WebElement getLogo() {
		return Logo;
	}
	
	
	
}
