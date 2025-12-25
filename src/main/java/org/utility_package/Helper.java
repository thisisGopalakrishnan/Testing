package org.utility_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.google.common.io.Files;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class Helper {
	
	 public static WebDriver driver;
	 
	public static  void launch_browser(String browser,String url) {
		
		switch (browser) {
		
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
			
		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
			
		default:
			System.out.println("Invalid broswer type");
			break;
		}
	}
	
	public static  void click_java(WebElement element) {
		
		element.click();
	}
	
	public static void click_JSE(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void sendkey(WebElement element, String Value) {
		
		element.sendKeys(Value);

	}
	public static String config_properties(String key) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\gopal\\eclipse-workspace\\Testing\\src\\test\\resources\\config.properties");
		
		Properties pro = new Properties();
		
		pro.load(file);
		
		
		String property = pro.getProperty(key);
		
		return property;
		

	}

	public static void element_wait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	public static void element_wait(By Locator) {
		
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	public static  void window_handling(int window_ID) {
		
		try {	
		List<String> list = new ArrayList<>(driver.getWindowHandles());
		String string = list.get(window_ID);
		driver.switchTo().window(string);
		}
		catch(Exception e){
			System.out.println("Window ID has not found");
			
		}
	
	}
	
	public static  String excel_reader( String sheetname, int rownumber,int cellnumber) throws IOException {
		
		String excel_path = config_properties("excelPath");
		
		FileInputStream file = new FileInputStream(excel_path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetname);
		XSSFRow row = sheet.getRow(rownumber);
		XSSFCell cell = row.getCell(cellnumber);
		DataFormatter format = new DataFormatter();
		String formatCellValue = format.formatCellValue(cell);
		
		return formatCellValue;
	
	}
	
	public static void screenshot() throws IOException {
	try {
		File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String date = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
		
		File dest = new File
				("C:\\Users\\gopal\\eclipse-workspace\\Testing\\target\\"+date+"\\image"+System.currentTimeMillis()+".jpeg");
		
		dest.getParentFile().mkdirs();
			
		Files.copy(s, dest);
	}
	catch(Exception e){
		
		System.out.println("Failed to take a Screenshot  "+e);
		
	}
	
	}
	
	
	public static Select select(WebElement element) {
		
		Select select = new Select(element);
		
		return select;
		
		
	}
	
	public static void main(String[] args) throws IOException {
	
}
}
