package finalTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	WebDriver driver;
	Logger log = Logger.getLogger("vvv");

	/*
	 * public Baseclass(WebDriver driver) throws Exception { this.driver = driver;
	 * 
	 * }
	 */

	void browserOpen() throws InterruptedException {

		// BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	void logIn() throws Exception {
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.get(prop.getProperty("URL"));
		log.info("Opening Techfetch webiste");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("candidatelogin"))).click();
		log.info("Opening candidate menu");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("loginbutton"))).click();
		log.info("Clicking Login button");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("candidatecontentframe");

		driver.findElement(By.xpath(prop.getProperty("mailid"))).sendKeys(prop.getProperty("username"));
		log.info("Entering mailid");

		driver.findElement(By.xpath(prop.getProperty("password1"))).sendKeys(prop.getProperty("password"));
		log.info("Entering password");

		driver.findElement(By.xpath(prop.getProperty("submitbutton"))).click();
		log.debug("Clicking submit button");

		Thread.sleep(1000);

	}

	void logOut() throws Exception {

		// System.out.println("dsa");
		driver.switchTo().defaultContent();

		Thread.sleep(10000);
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Base.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// Logout...
		driver.findElement(By.xpath(prop.getProperty("usersetting"))).click();
		log.debug("Clicking user settings ");
		Thread.sleep(10000);
		driver.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
		log.debug("Clicking logout button ");
		Thread.sleep(10000);
	}

	void browserClose() {
		driver.quit();
	}

}
