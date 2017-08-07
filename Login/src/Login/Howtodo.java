package Login;

suryapriya

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.firefox.FirefoxDriver;

//import com.google.common.collect.Table.Cell;

public class Howtodo {

    WebDriver driver;
    Logger log = Logger.getLogger("vvv");

    /*
     * public Baseclass(WebDriver driver) throws Exception { this.driver =
     * driver;
     *
     * }
     */
@BeforeTest
    void browserOpen() throws InterruptedException {

        // BasicConfigurator.configure();

       	System.setProperty("webdriver.chrome.driver","D:\\SakthiArun\\cromedriver\\chromedriver.exe"); 
		driver = new ChromeDriver(); 

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }
@Test
    void logIn() throws Exception {
        FileInputStream fsIP = new FileInputStream(new File(
        		"D:\\workspace1\\Login\\EXCEL_LoginID.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fsIP);
        XSSFSheet worksheet = wb.getSheetAt(0);
        Cell cell;
        File file = new File(
        		"D:\\workspace1\\Login\\src\\Login\\Base.properties");
        FileInputStream fileInput;
        fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        for (int i = 0; i <= 6; i++) {
            driver.get(prop.getProperty("URL"));
            log.info("Opening Techfetch webiste");
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            Thread.sleep(10000);
            driver.findElement(By.xpath(prop.getProperty("candidatelogin")))
                    .click();
            log.info("Opening candidate menu");
            Thread.sleep(1000);
            driver.findElement(By.xpath(prop.getProperty("loginbutton")))
                    .click();
            log.info("Clicking Login button");
            driver.switchTo().defaultContent();
            driver.switchTo().frame("candidatecontentframe");
           

            driver.findElement(By.xpath(prop.getProperty("mailid"))).clear();
            String s = String.valueOf(worksheet.getRow(i).getCell(0)
                    .getStringCellValue());
            
            
            driver.findElement(By.xpath(prop.getProperty("mailid")))
                    .sendKeys(s);
            log.info("Entering mailid");
            
            driver.findElement(By.xpath(prop.getProperty("password1"))).clear();
            String ss = String.valueOf(worksheet.getRow(i).getCell(1)
                    .getStringCellValue());
            driver.findElement(By.xpath(prop.getProperty("password1")))
                    .sendKeys(ss);
            log.info("Entering password");
            Thread.sleep(1000);
            driver.findElement(By.xpath(prop.getProperty("submitbutton")))
                    .click();
            log.debug("Clicking submit button");
            try {
                WebElement web1 = driver.findElement(By
                        .xpath(".//*[@id='login']/div[1]/div"));
                boolean a2 = web1.isDisplayed();
                if (a2 = true) {
                    cell = worksheet.getRow(i).createCell(2);
                    cell.setCellValue("Login fail,,,");
                    fsIP.close();
                    FileOutputStream output_file1 = new FileOutputStream(
                            new File("D:\\workspace1\\Login\\EXCEL_LoginID.xlsx"));
                    wb.write(output_file1);
                    output_file1.close();

                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                cell = worksheet.getRow(i).createCell(2);
                cell.setCellValue("Login pass,,,");
                fsIP.close();
                FileOutputStream output_file1 = new FileOutputStream(new File(
                        "D:\\workspace1\\Login\\EXCEL_LoginID.xlsx"));
                wb.write(output_file1);
                output_file1.close();

                Thread.sleep(1000);
                driver.findElement(By.xpath(prop.getProperty("usersetting"))).click();
                log.debug("Clicking user settings ");
                Thread.sleep(10000);
                driver.findElement(By.xpath(prop.getProperty("logoutbutton"))).click();
                log.debug("Clicking logout button ");
                Thread.sleep(10000);

               // break;
            }
        }

    }
/*@AfterTest
    void logOut() throws Exception {

        driver.switchTo().defaultContent();

        Thread.sleep(10000);
        File file = new File(
        		"D:\\workspace1\\Login\\src\\Login\\Base.properties");
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
    }*/
@AfterTest
    void browserClose() {
        driver.quit();
    }

}