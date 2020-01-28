package com.byblosTestAuto.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class HookTest {

	static Configuration config = Configuration.getInstance();

	String USER_ID = config.getProperty("user_id");
	String USER_VALUE = config.getProperty("user_value");
	String USER_VALUE_ST = config.getProperty("user_value_st");

	String PASSWORD_ID = config.getProperty("password_id");
	String PASSWORD_VALUE = config.getProperty("password_value");

	String SIGN_IN_XPATH = config.getProperty("sign_in_xpath");

	String BASE_URL = config.getProperty("baseUrl");

	String ICON_USER_XPATH = config.getProperty("icon_user_xpath");

	String SIGN_OUT_XPATH = config.getProperty("sign_out_xpath");

	static String PATH_TO_CHROME_DRIVER = config.getProperty("path_to_chrome_driver");

	private static WebDriver INSTANCE = getChromeDriver();

	private static WebDriver driver = null;

	WebElement icon_user = null;

	WebElement sign_out = null;

	@Before
	public void setUp() {
		driver = getInstance();
	}

	public static WebDriver getInstance() {
		return INSTANCE;
	}

	@Given("je me connecte en tant que \"([^\"]*)\"")
	public void je_me_connecte_en_tant_que(String usernameInFeature) throws Throwable {
		String username = usernameInFeature.split("\\s")[0];

		driver.navigate().to(BASE_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id(USER_ID)).sendKeys(username);
		driver.findElement(By.id(PASSWORD_ID)).sendKeys(PASSWORD_VALUE);
		driver.findElement(By.xpath(SIGN_IN_XPATH)).click();
		Thread.sleep(1000);
	}

	public static WebDriver getChromeDriver() {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability("networkConnectionEnabled", true);
			capabilities.setCapability("browserConnectionEnabled", true);
			return new ChromeDriver(capabilities);
		} else
			return driver;

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		HookTest.driver = driver;
	}

//	@After
//	public void cleanUp() throws InterruptedException {
//
//		icon_user = driver.findElement(By.xpath(ICON_USER_XPATH));
//
//		icon_user.click();
//
//		Thread.sleep(2000);
//
//		sign_out = driver.findElement(By.xpath(SIGN_OUT_XPATH));
//
//		sign_out.click();
//
//		// Thread.sleep(2000);
//
//		// driver.close();
//
//	}

}
