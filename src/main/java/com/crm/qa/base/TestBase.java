package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;

	public TestBase() {

		try {
			prop = new Properties();
			String propFile = System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
			FileInputStream fip = new FileInputStream(propFile);
			prop.load(fip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.trim().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		driver = e_driver;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
