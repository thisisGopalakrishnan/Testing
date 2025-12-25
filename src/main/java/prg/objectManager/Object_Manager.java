package prg.objectManager;

import org.page_objects.Confirmation_page;
import org.page_objects.Login_Page;
import org.page_objects.Select_Hotel;
import org.page_objects.Search_Hotel;
import org.utility_package.Helper;

public class Object_Manager extends Helper{

	
	Login_Page Login_page = new Login_Page();
	Search_Hotel Search_Hotel = new Search_Hotel();
	Select_Hotel Select_Hotel = new Select_Hotel();
	Confirmation_page Confirmation_page = new Confirmation_page();

	public Search_Hotel getSearch_Hotel() {
		return Search_Hotel;
	}

	public Login_Page getLogin_page() {
		return Login_page;
	}
	
	public Select_Hotel getSelect_Hotel() {
		return Select_Hotel;
	}
	
	public Confirmation_page getConfirmation_page() {
		return Confirmation_page;
	}
}
