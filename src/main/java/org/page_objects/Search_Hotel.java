package org.page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility_package.Helper;

public class Search_Hotel extends Helper {

	public Search_Hotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Welcome to Adactin Group of Hotels']")
	private WebElement welcome_text;

	public WebElement getWelcome_text() {
		return welcome_text;
	}

	@FindBy(xpath = "//select[@id='location']//option")
	private List<WebElement> Location;

	public List<WebElement> getLocation() {
		return Location;
	}

	@FindBy(css = "#hotels")
	private WebElement Hotels;

	@FindBy(css = "#room_type")
	private WebElement Room_Type;

	@FindBy(css = "#room_nos")
	private WebElement Number_Of_rooms;

	@FindBy(css = "#datepick_in")
	private WebElement check_in;

	@FindBy(css = "#rdatepick_out")
	private WebElement check_out;

	@FindBy(css = "#adult_room")
	private WebElement adult_per_room;

	@FindBy(css = "#child_room")
	private WebElement childerns_per_room;

	@FindBy(css = "#Submit")
	private WebElement search;

	public WebElement getHotels() {
		return Hotels;
	}

	public WebElement getCheck_in() {
		return check_in;
	}

	public WebElement getCheck_out() {
		return check_out;
	}

	public WebElement getAdult_per_room() {
		return adult_per_room;
	}

	public WebElement getChilderns_per_room() {
		return childerns_per_room;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getRoom_Type() {
		return Room_Type;
	}

	public WebElement getNumber_Of_rooms() {
		return Number_Of_rooms;
	}

}
