package org.practise;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utility_package.Helper;

import io.cucumber.java.jv.Lan;
import io.github.bonigarcia.wdm.WebDriverManager;
import prg.objectManager.Object_Manager;

public class Junit extends Helper {

	static Object_Manager Object_Manager;
	static List<WebElement> location;
	 static WebElement hotels;
	 static WebElement room_Type;
	 static WebElement number_Of_rooms;
	 static WebElement check_in;
	 static WebElement check_out;
	 static WebElement adult_per_room;
	 static WebElement childerns_per_room;
	 static WebElement search;

	@BeforeClass

	public static void TC_01() throws IOException {

		launch_browser(config_properties("browser"), config_properties("url"));
		 Object_Manager = new Object_Manager();

	}

	@Before
	public void TC_02() throws IOException {
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

	}

	@Test
	public void TC_03() throws IOException {
		Object_Manager.getLogin_page().getUsername().sendKeys(config_properties("username"));

		Object_Manager.getLogin_page().getPassword().sendKeys(config_properties("password"));

		Object_Manager.getLogin_page().getLogin_btn().click();

		WebElement welcome_text = Object_Manager.getSearch_Hotel().getWelcome_text();

		if (welcome_text.getText().equals("Welcome to Adactin Group of Hotels")) {
			System.out.println("Application logged in successfully");
		} else {
			System.out.println("Application not logged");

		}
	}

	@After
	public void TC_04() {
		location = Object_Manager.getSearch_Hotel().getLocation();
		hotels = Object_Manager.getSearch_Hotel().getHotels();
		room_Type = Object_Manager.getSearch_Hotel().getRoom_Type();
		number_Of_rooms = Object_Manager.getSearch_Hotel().getNumber_Of_rooms();
		check_in = Object_Manager.getSearch_Hotel().getCheck_in();
		check_out = Object_Manager.getSearch_Hotel().getCheck_in();
		adult_per_room = Object_Manager.getSearch_Hotel().getAdult_per_room();
		childerns_per_room = Object_Manager.getSearch_Hotel().getChilderns_per_room();
		search = Object_Manager.getSearch_Hotel().getSearch();

	}

	@AfterClass
	public static void TC_05() throws InterruptedException {
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

		Thread.sleep(2000);

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

	}

	public static void main(String[] args) {

		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.get("https://www.flipkart.com/");
		 * driver.findElement(By.xpath("//input[@type='text']")).
		 * sendKeys("iphone 17 pro");
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * List<WebElement> elements1 = driver.findElements(By.
		 * xpath("//div[@data-id='MOBHFN6YV7GYZHSM']//following::div[@class='col col-7-12']//following::div[contains(text(),'Apple iPhone')]"
		 * )); int count = 1; int max = 9;
		 * 
		 * while (count < max) {
		 * 
		 * List<WebElement> elements = driver.findElements(
		 * By.xpath("//div[contains(text(),'Apple iPhone')]") );
		 * 
		 * for (WebElement product : elements) { try {
		 * System.out.println(product.getText()); } catch
		 * (StaleElementReferenceException e) { // Re-fetch element if stale elements =
		 * driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone')]")); for
		 * (WebElement retry : elements) { System.out.println(retry.getText()); } } }
		 * count++; System.out.println("Page Number "+count);
		 * System.out.println("================="); WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10));
		 * 
		 * WebElement nextbutton =
		 * driver.findElement(By.xpath("//span[text()='Next']"));
		 * wait.until(ExpectedConditions.elementToBeClickable(nextbutton));
		 * nextbutton.click(); }
		 * 
		 * System.out.println("Loop Ended");
		 */

	}

}
