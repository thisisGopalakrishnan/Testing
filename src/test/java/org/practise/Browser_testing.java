package org.practise;

import java.io.IOException;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.page_objects.Search_Hotel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utility_package.Helper;

import io.cucumber.java.gl.Logo;
import prg.objectManager.Object_Manager;

public class Browser_testing extends Helper {
	@Test
	public static void validating_login_page() throws IOException, InterruptedException {
		// Launch the browser
		launch_browser(config_properties("browser"), config_properties("url"));
		// creating the obj for parent class of the all objects
		Object_Manager Object_Manager = new Object_Manager();

		// try to get login page title
		@Nullable
		String actual_title = driver.getTitle();

		// Login page validation

		if (actual_title.equals("Adactin.com - Hotel Reservation System")) {
			System.out.println("✅ Login page launched successfully");
		} else {
			System.out.println("❌ Login page not launched. Actual title: " + actual_title);
		}

		if (Object_Manager.getLogin_page().getLogo().isDisplayed()) {
			System.out.println("✅ Login page launched successfully");
		} else {

			System.out.println("❌ Login page not launched properly");
		}

		screenshot();
// Login page
		Object_Manager.getLogin_page().getUsername().sendKeys(config_properties("username"));

		Object_Manager.getLogin_page().getPassword().sendKeys(config_properties("password"));

		Object_Manager.getLogin_page().getLogin_btn().click();

		

// Verification of login successful or not

		WebElement welcome_text = Object_Manager.getSearch_Hotel().getWelcome_text();

		if (welcome_text.getText().equals("Welcome to Adactin Group of Hotels")) {
			System.out.println("Application logged in successfully");
		} else {
			System.out.println("Application not logged");

		}

		List<WebElement> location = Object_Manager.getSearch_Hotel().getLocation();
		WebElement hotels = Object_Manager.getSearch_Hotel().getHotels();
		WebElement room_Type = Object_Manager.getSearch_Hotel().getRoom_Type();
		WebElement number_Of_rooms = Object_Manager.getSearch_Hotel().getNumber_Of_rooms();
		WebElement check_in = Object_Manager.getSearch_Hotel().getCheck_in();
		WebElement check_out = Object_Manager.getSearch_Hotel().getCheck_in();
		WebElement adult_per_room = Object_Manager.getSearch_Hotel().getAdult_per_room();
		WebElement childerns_per_room = Object_Manager.getSearch_Hotel().getChilderns_per_room();
		WebElement search = Object_Manager.getSearch_Hotel().getSearch();

		for (WebElement webElement : location) {
			
			if (webElement.getText().contains("London")) {
				
				webElement.click();
				  
				System.out.println("London has clicked");
			}
		}
		
		
		String text = hotels.getText();
		System.out.println(text);
		
//		if you are using list of webelements we cannot use select class we can use getoption and iterate and click
//		Select select = new Select(location);
//		select.selectByValue("Melbourne");
		
		Select select2 = select(hotels);
		select2.selectByValue("Hotel Sunshine");
		
		Select select4 = select(room_Type);
		select4.selectByContainsVisibleText("Double");
		check_in.clear();
		
	
		
		check_in.sendKeys("10/11/2025");
		
		Thread.sleep(2000);
		
		check_in.clear();
		
		check_out.sendKeys("10/11/2025");
		
		Select select3 = select(number_Of_rooms);
		select3.selectByIndex(2);
		
		Select select5 = select(adult_per_room);
		select5.selectByIndex(3);
		
		Select select6 = select(childerns_per_room);
		select6.selectByIndex(1);
		
		search.click();
		
		WebElement radio_button = Object_Manager.getSelect_Hotel().getRadio_button();
		element_wait(radio_button);
		Object_Manager.getSelect_Hotel().getRadio_button().click();
		
		Object_Manager.getSelect_Hotel().getCountinue_button().click();	
		
		System.out.println(driver.getTitle());
		
		Object_Manager.getSelect_Hotel().getFirst_name().sendKeys("Gopal");
		
		Object_Manager.getSelect_Hotel().getLast_name().sendKeys("Krishnan");
		
		Object_Manager.getSelect_Hotel().getAddress().sendKeys("Chennai");
		
		Object_Manager.getSelect_Hotel().getCreadit_card().sendKeys("12345678998765432123");
		
		WebElement creadit_card_type = Object_Manager.getSelect_Hotel().getCreadit_card_type();
		
		Select select = select(creadit_card_type);
		select.selectByIndex(1);
		
		WebElement cc_exp_month = Object_Manager.getSelect_Hotel().getCc_exp_month();
		
		Select select7 = select(cc_exp_month);
		select7.selectByIndex(5);
		
		WebElement cc_exp_year = Object_Manager.getSelect_Hotel().getCc_exp_year();

		Select select8 = select(cc_exp_year);
		
		select8.selectByContainsVisibleText("2026");
		
		
		Object_Manager.getSelect_Hotel().getCc_cvv().sendKeys("123");
		
		Object_Manager.getSelect_Hotel().getBook_now().click();
		
		
		WebElement confirmation_text = Object_Manager.getConfirmation_page().getConfirmation_text();
		WebElement hotel_name = Object_Manager.getConfirmation_page().getHotel_name();
		WebElement london_text = Object_Manager.getConfirmation_page().getLondon_text();
		@Nullable
		String nameof_Hotel = hotel_name.getAttribute("value");
		String London_text = london_text.getAttribute("value");
		
		System.out.println("Name of the hotel  "+nameof_Hotel);
		System.out.println("Name of the hotel  "+London_text);
		
		System.out.println(confirmation_text);
		Assert.assertEquals(nameof_Hotel, "Hotel Sunshine");
		Assert.assertEquals(London_text, "London");
		
		Object_Manager.getConfirmation_page().getBooked_Itinerary().click();
		
		WebElement booked_Itinerary = Object_Manager.getConfirmation_page().getBooked_Itinerary();
		element_wait(booked_Itinerary);
		
		click_java(booked_Itinerary);
		
		Object_Manager.getConfirmation_page().getCheckbox().click();
		
		
		List<WebElement> printthe_row = Object_Manager.getConfirmation_page().getPrintthe_row();
		
		for (WebElement webElement : printthe_row) {
			System.out.println("Row printing "+ webElement.getText());
		}
		
		
		Object_Manager.getConfirmation_page().getLogout().click();
		
		WebElement logout_Message = Object_Manager.getConfirmation_page().getLogout_Message();
		
		System.out.println();
		
		System.out.println(logout_Message.getText());
		
		
		
		
		
	}
	}
