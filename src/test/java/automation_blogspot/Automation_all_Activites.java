package automation_blogspot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.utility_package.Helper;

public class Automation_all_Activites extends Helper {

	@BeforeMethod
	public void browser_launch() throws IOException {

		launch_browser("chrome", config_properties("blogspot"));

	}

	@Ignore
	@Test
	private void upload_files() throws AWTException, InterruptedException {

		WebElement element = driver.findElement(By.xpath("//span[@role='button']"));
		element.click();
		String files = "C:\\Users\\gopal\\Downloads\\Amazon India Shop, Pay, miniTV_22.14.2.350_APKPure.apk\n"
				+ "C:\\Users\\gopal\\Downloads\\Innoventes_QA_Test_2023MQAP01.pdf\n"
				+ "C:\\Users\\gopal\\Downloads\\Interview Scheduling Guidance (1).pdf\n"
				+ "C:\\Users\\gopal\\Downloads\\GopalakrishnanG_ApplicationForm.pdf";

		StringSelection datatransfer = new StringSelection(files);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(datatransfer, null);
		Thread.sleep(2000);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Ignore
	@Test
	public void calendar() {

		String target_month = "May";
		String target_year = "2027";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		String current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		WebElement next_button = driver.findElement(By.xpath("//span[contains(text(),'Next')]")); // Next button

		while (!target_year.equals(current_year)) {
			next_button.click();
			next_button = driver.findElement(By.xpath("//span[contains(text(),'Next')]")); // Next button
			current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		}

		while (!target_month.equals(current_month)) {
			next_button.click();
			next_button = driver.findElement(By.xpath("//span[contains(text(),'Next')]")); // Next button
			current_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

		}

	}

	@Ignore
	@Test
	public void dynamic_element() {

// using contains method we create the dynamic xpath for both STOP and START
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'ST')]"));

		element.click();

		String text = element.getText();

		if (text.equals("STOP")) {

			System.out.println("yes Stop clicked");

		} else {

			element.click();
			String text2 = element.getText();

			System.out.println("Yes Stop clicked");
		}

	}

	@Test
	private void shadow_dom() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement shadowhost = driver.findElement(By.xpath("//div[@id ='shadow_host']"));

//		WebElement shadowroot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowhost);

		SearchContext shadowRoot = shadowhost.getShadowRoot();

		WebElement element = shadowRoot.findElement(By.cssSelector("span[class='info']"));

		String text = element.getText();

		System.out.println(text);
		
		WebElement element2 = shadowRoot.findElement(By.cssSelector("div[id='nested_shadow_host']"));
		
		SearchContext shadowRoot2 = element2.getShadowRoot();
		
		WebElement element3 = shadowRoot2.findElement(By.cssSelector("div[id='nested_shadow_content']  div"));
		
		System.out.println(element3.getText());
	}

}
