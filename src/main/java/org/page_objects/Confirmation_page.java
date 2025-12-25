package org.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility_package.Helper;

public class Confirmation_page extends Helper {

	public Confirmation_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement confirmation_text;

	@FindBy(xpath = "//input[@value='Hotel Sunshine']")
	private WebElement Hotel_name;

	@FindBy(xpath = "//input[@value='London']")
	private WebElement London_text;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement Booked_Itinerary;

	public WebElement getConfirmation_text() {
		return confirmation_text;
	}

	public WebElement getHotel_name() {
		return Hotel_name;
	}

	public WebElement getLondon_text() {
		return London_text;
	}

	public WebElement getBooked_Itinerary() {
		return Booked_Itinerary;
	}

	@FindBy(id = "my_itinerary")
	private WebElement my_itinerary;

	@FindBy(xpath = "//input[@name='order_id_1549519']//preceding::td[@bgcolor='#FFFFFF']//input")
	private WebElement checkbox;

	public WebElement getCheckbox() {
		return checkbox;
	}

	@FindBy(xpath = "//tr[@align='center']//following::tr[1]")
	private List<WebElement> printthe_row;

	public List<WebElement> getPrintthe_row() {
		return printthe_row;
	}

	@FindBy(id = "logout")
	private WebElement logout;
	
	public WebElement getLogout() {
		return logout;
	}
	
	@FindBy(xpath = "//td[contains(text(),'You have successfully logged out.')]")
	private WebElement logout_Message;
	
	
	public WebElement getLogout_Message() {
		return logout_Message;
	}
	
	
	
}
