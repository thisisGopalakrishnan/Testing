package org.page_objects_Navenlabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility_package.Helper;

public class Navenlabs extends Helper {

	public Navenlabs() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
	private WebElement My_acc;

	public WebElement getMy_acc() {
		return My_acc;
	}

	@FindBy(xpath = "//a[normalize-space()='Address Book']")
	private WebElement my_addressbook;

	public WebElement getMy_addressbook() {
		return my_addressbook;
	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement new_address;

	public WebElement getNew_address() {
		return new_address;
	}

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement last_name;

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement first_name;

	@FindBy(xpath = "//input[@id='input-company']")
	private WebElement company;

	@FindBy(xpath = "//input[@id='input-address-1']")
	private WebElement address1;

	@FindBy(xpath = "//input[@id='input-city']")
	private WebElement city;

	@FindBy(xpath = "//select[@id='input-country']")
	private WebElement country;

	@FindBy(xpath = "//select[@id='input-zone']")
	private WebElement region;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement Continue;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement confirmatio_msg;

	@FindBy(xpath = "//a[@class='btn btn-info']")
	private WebElement edit;

	@FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
	private WebElement desktop;

	@FindBy(xpath = "//a[normalize-space()='Show All Desktops']")
	private WebElement Show_All_Desktops;

	@FindBy(xpath = "//select[@id='input-sort']")
	private WebElement sort;

	@FindBy(xpath = "//select[@id='input-limit']")
	private WebElement show;

	@FindBy(xpath = "(//a[text()='iPhone']//following::button[@type='button'])[1]/i")
	private WebElement iphonecart;

	@FindBy(xpath = "(//a[text()='iPod Classic']//following::button[@type='button'])[1]/i")
	private WebElement ipad_Classi;
	
	public WebElement getIpad_Classi() {
		return ipad_Classi;
	}
	
	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement add_to_cart;

	@FindBy(xpath = "//td[text()='Product Name']//following::tr")
	private WebElement size_of_the_row;

	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement shopping_cart;

	public WebElement getShopping_cart() {
		return shopping_cart;
	}

	public WebElement getLast_name() {
		return last_name;
	}

	public WebElement getFirst_name() {
		return first_name;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress1() {
		return address1;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getRegion() {
		return region;
	}

	public WebElement getContinue() {
		return Continue;
	}

	public WebElement getConfirmatio_msg() {
		return confirmatio_msg;
	}

	public WebElement getEdit() {
		return edit;
	}

	public WebElement getDesktop() {
		return desktop;
	}

	public WebElement getShow_All_Desktops() {
		return Show_All_Desktops;
	}

	public WebElement getSort() {
		return sort;
	}

	public WebElement getShow() {
		return show;
	}

	public WebElement getIphonecart() {
		return iphonecart;
	}

	public WebElement getAdd_to_cart() {
		return add_to_cart;
	}

	public WebElement getSize_of_the_row() {
		return size_of_the_row;
	}

}
