package org.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility_package.Helper;

public class Select_Hotel extends Helper {

	public Select_Hotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement radio_button;

	public WebElement getRadio_button() {
		return radio_button;
	}

	@FindBy(id = "continue")
	private WebElement countinue_button;

	public WebElement getCountinue_button() {
		return countinue_button;
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement text_book_hotel;

	public WebElement getText_book_hotel() {
		return text_book_hotel;
	}

	@FindBy(id = "first_name")
	private WebElement first_name;

	public WebElement getFirst_name() {
		return first_name;
	}

	@FindBy(id = "last_name")
	private WebElement last_name;

	public WebElement getLast_name() {
		return last_name;
	}

	@FindBy(id = "address")
	private WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@FindBy(id = "cc_num")
	private WebElement creadit_card;

	public WebElement getCreadit_card() {
		return creadit_card;
	}

	@FindBy(id = "cc_type")
	private WebElement creadit_card_type;

	public WebElement getCreadit_card_type() {
		return creadit_card_type;
	}

	@FindBy(id = "cc_exp_month")
	private WebElement cc_exp_month;

	public WebElement getCc_exp_month() {
		return cc_exp_month;
	}

	@FindBy(id = "cc_exp_year")
	private WebElement cc_exp_year;

	public WebElement getCc_exp_year() {
		return cc_exp_year;
	}

	@FindBy(name = "cc_cvv")
	private WebElement cc_cvv;

	public WebElement getCc_cvv() {
		return cc_cvv;
	}

	@FindBy(id = "book_now")
	private WebElement book_now;

	public WebElement getBook_now() {
		return book_now;
	}

}
