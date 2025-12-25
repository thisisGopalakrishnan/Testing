package org.practise;

import java.io.Flushable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.page_objects_Navenlabs.Navenlabs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.utility_package.Extent_Report;
import org.utility_package.Helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@org.testng.annotations.Listeners(Listener.class)
public class Project_2 extends Helper {

	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	private void report() {
		

		Extent_Report.report();
		test = Extent_Report.extent.createTest("New test case");

	}

	@Test
	public void navenlabs() throws IOException {
		
		test.pass("test Started");
		launch_browser(config_properties("browser"), config_properties("navenlabs"));
		test.pass("browser launched ");
		Navenlabs Navenlabs = new Navenlabs();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Navenlabs.getUsername().sendKeys(config_properties("user"));
		Navenlabs.getPassword().sendKeys(config_properties("pass"));
		Navenlabs.getLogin().click();

		org.testng.Assert.fail();

		try {
			Navenlabs.getMy_addressbook().click();
		} catch (Exception e) {
			Navenlabs.getMy_addressbook().click();
		}

		Navenlabs.getNew_address().click();

		Navenlabs.getFirst_name().sendKeys("Gopal");
		Navenlabs.getLast_name().sendKeys("krishnan");
		Navenlabs.getCompany().sendKeys("HCl");
		Navenlabs.getAddress1().sendKeys("chennai");
		Navenlabs.getCity().sendKeys("Chennai");
		WebElement country = Navenlabs.getCountry();
		Select select = select(country);
		select.selectByIndex(2);

		WebElement region = Navenlabs.getRegion();
		element_wait(region);

		try {
			Select select2 = select(region);
			select2.selectByIndex(2);
		} catch (Exception e) {
			Select select2 = select(region);
			select2.selectByIndex(2);
		}

		Navenlabs.getContinue().click();

		WebElement confirmatio_msg = Navenlabs.getConfirmatio_msg();
		System.out.println(confirmatio_msg.getText());

		Navenlabs.getEdit().click();
		WebElement desktop = Navenlabs.getDesktop();
		Actions a = new Actions(driver);
		a.moveToElement(desktop).perform();
		Navenlabs.getShow_All_Desktops().click();
		WebElement sort = Navenlabs.getSort();
		Select select3 = select(sort);
		select3.selectByIndex(2);
		WebElement show = Navenlabs.getShow();
		element_wait(show);
		Select select4 = select(show);
		select4.selectByIndex(0);

		WebElement iphonecart = Navenlabs.getIphonecart();
		click_JSE(iphonecart);

		WebElement ipad_Classi = Navenlabs.getIpad_Classi();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ipad_Classi);

		click_JSE(ipad_Classi);
		try {
			WebElement shopping_cart = Navenlabs.getShopping_cart();
			click_JSE(shopping_cart);

//			WebElement add_to_cart = Navenlabs.getAdd_to_cart();
//			click_JSE(add_to_cart);
		} catch (Exception e) {
			WebElement shopping_cart = Navenlabs.getShopping_cart();
			click_JSE(shopping_cart);
			System.out.println(e);
		}

		List<WebElement> elements = driver.findElements(By.xpath("//td[text()='Product Name']//following::tr"));

		int size = elements.size();
		System.out.println(size);
	}

	@Test
	private void Method_TWO() {
		System.out.println("method Two");
		
	}

	@Test
	private void Method_THREE() {
		System.out.println("method Three");
		test.pass("Method Three executing");

	}

}
