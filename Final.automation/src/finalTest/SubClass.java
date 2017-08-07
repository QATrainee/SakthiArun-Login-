package finalTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SubClass extends BaseClass {

	public void upload() throws Exception {
		// uploading a resume from external path
		/**
		 * @author karthiga balapriya work name : upload
		 */
		Properties prop;
		FileInputStream fileInput = new FileInputStream(
				"E:\\workspace\\Final.automation\\src\\finalTest\\Upload.properties");
		prop = new Properties();
		prop.load(fileInput);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		driver.findElement(By.xpath(prop.getProperty("Uploadicon"))).click();
		// driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
		log.debug("Clicking Replacedocs");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("replacedoccontentframe");
		Thread.sleep(1000);
		driver.findElement(By.id("resumeupload")).clear();
		driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("path"));
		log.debug("Uploading Resume");

		Thread.sleep(10000);

		driver.findElement(By.xpath(prop.getProperty("Iconsave"))).click();
		// driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		log.debug("Clicking Submit button");

		Thread.sleep(3000);
		driver.findElement(By.id("btnClose")).click();
		log.debug("Clicking Close button");

	}

	public void forward() throws Exception {

		// Displaying profile detail and downloading the resume
		/**
		 * @author Arun Sakthi work name : profile
		 */

		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Profile.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Set<String> Wi = driver.getWindowHandles();
		// System.out.println("No of Windows:" + Wi.size());
		Iterator it = Wi.iterator();
		String main = (String) it.next();
		// System.out.println(it.next());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		WebElement A = driver.findElement(By.xpath(prop.getProperty("ProfileClick")));
		A.click();
		log.info("Clicking Profile");
		Wi = driver.getWindowHandles();
		log.info("No of Windows:" + Wi.size());
		System.out.println("No of Windows:" + Wi.size());
		it = Wi.iterator();
		it = Wi.iterator();
		String mmm = (String) it.next();
		String nnn = (String) it.next();
		System.out.println(mmm);
		System.out.println(nnn);
		driver.switchTo().window(nnn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(20000);
		WebElement B = driver.findElement(By.cssSelector(prop.getProperty("ProfileDownload")));
		B.click();
		log.info("Downloading Profile");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		WebElement C = driver.findElement(By.xpath(prop.getProperty("ProfileForward")));
		C.click();
		log.info("Clicking Forward Button");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("jsforwardprofilecontentframe");
		WebElement D = driver.findElement(By.xpath(prop.getProperty("ProfileForwardToMail")));
		Thread.sleep(3000);
		D.sendKeys(prop.getProperty("ProfileForwardID"));
		log.info("Entering Forward Mailid");
		Thread.sleep(2000);
		WebElement E = driver.findElement(By.xpath(prop.getProperty("ProfileSendButton")));
		E.click();
		log.info("Clicking SendButton");
		Thread.sleep(2000);
		WebElement F = driver.findElement(By.xpath(prop.getProperty("ProfileClose")));
		F.click();
		log.info("Clicking CloseButton");
		driver.close();
		driver.switchTo().window(mmm);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

	}

	public void update() throws Exception {
		// creating a profile and perform edit and update
		/**
		 * @author surya Balapriya work name : myresume
		 */
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("contentframe");
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Update.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		Logger log = Logger.getLogger("devpinoyLogger");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("MyResume"))).click();
		log.info("Opening MyResume");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("AddResume"))).click();
		log.info("Selecting AddResume");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Name1"))).sendKeys(prop.getProperty("firstname"));
		log.info("Entering FirstName");

		driver.findElement(By.xpath(prop.getProperty("Name2"))).sendKeys(prop.getProperty("middlename"));
		log.info("Entering MiddleName");
		driver.findElement(By.xpath(prop.getProperty("Name3"))).sendKeys(prop.getProperty("lastname"));
		log.info("Entering LastName");
		Thread.sleep(2000);
		Select oSelect = new Select(driver.findElement(By.xpath(prop.getProperty("Country"))));
		log.info("Selecting Country");
		oSelect.selectByIndex(12);
		driver.findElement(By.xpath(prop.getProperty("City"))).sendKeys(prop.getProperty("city"));
		log.info("Entering City,state or zip");

		driver.findElement(By.xpath(prop.getProperty("MobNo"))).sendKeys(prop.getProperty("phone(mobile)"));
		log.info("Entering MobilePhone");

		driver.findElement(By.xpath(prop.getProperty("HomeNo"))).sendKeys(prop.getProperty("phone(home)"));
		log.info("Entering HomePhone");
		driver.findElement(By.xpath(prop.getProperty("WorkNo"))).sendKeys(prop.getProperty("phone(work)"));
		log.info("Entering WorkPhone");
		driver.findElement(By.xpath(prop.getProperty("ExtensionNo"))).sendKeys(prop.getProperty("phoneextension"));
		log.info("Entering Extension");

		Select oSelect1 = new Select(driver.findElement(By.xpath(prop.getProperty("PrefferedTime"))));
		oSelect1.selectByIndex(2);
		log.info("Selecting PrefferedTime");

		Select oSelect2 = new Select(driver.findElement(By.xpath(prop.getProperty("Phone"))));
		oSelect2.selectByIndex(2);
		log.info("Selecting Home");

		Select oSelect3 = new Select(driver.findElement(By.xpath(prop.getProperty("Citizen"))));
		oSelect3.selectByIndex(2);
		log.info("Selecting Citizen");
		driver.findElement(By.xpath(prop.getProperty("WorkAuthorization"))).click();
		log.info("Clicking WorkAuthorization");

		Select oSelect4 = new Select(driver.findElement(By.xpath(prop.getProperty("NeedNewH1B"))));
		oSelect4.selectByIndex(2);
		log.info("Selecting NeedNewH1B");
		driver.findElement(By.id(prop.getProperty("Resumeupload"))).clear();
		log.info("clearing upload");
		driver.findElement(By.id(prop.getProperty("Resumeupload"))).sendKeys(prop.getProperty("upload"));

		log.info("Selecting Resume");
		Thread.sleep(10000);

		driver.findElement(By.xpath(prop.getProperty("Submitt"))).click();
		log.info("Clicking Submit button");
		Thread.sleep(100);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		log.info("Switching to Professional");
		Thread.sleep(1000);
		driver.findElement(By.id(prop.getProperty("Bachelor"))).click();
		log.info("Selecting Bachelor button on Highest degree");
		Select oSelect5 = new Select(driver.findElement(By.id(prop.getProperty("ExcpectedSalary"))));
		oSelect5.selectByVisibleText("$10K");
		log.info("Selecting Expected salary per year");

		Select oSelect6 = new Select(driver.findElement(By.id(prop.getProperty("ExpectedSalaryHour"))));
		oSelect6.selectByVisibleText("$15");
		log.info("Selecting Expected salary per hour");

		driver.findElement(By.id(prop.getProperty("JobTitle"))).clear();
		driver.findElement(By.id(prop.getProperty("JobTitle"))).sendKeys(prop.getProperty("jobtitle"));
		log.info("Entering job title");

		Select oSelect7 = new Select(driver.findElement(By.id(prop.getProperty("TotalExperience"))));
		oSelect7.selectByVisibleText("17");
		log.info("Selecting total experience");

		driver.findElement(By.cssSelector(prop.getProperty("ExpValue"))).click();
		log.info("Clicking Value ");

		Select oSelect8 = new Select(driver.findElement(By.id(prop.getProperty("USAExperience"))));
		oSelect8.selectByVisibleText("15");
		log.info("Selecting USA experience");

		driver.findElement(By.id(prop.getProperty("ResumeTitle"))).clear();
		driver.findElement(By.id(prop.getProperty("ResumeTitle"))).sendKeys(prop.getProperty("resumetitle"));
		log.info("Entering resume title");

		driver.findElement(By.id(prop.getProperty("Resumeupload"))).clear();
		driver.findElement(By.id(prop.getProperty("Resumeupload"))).sendKeys(prop.getProperty("uploadfile"));
		log.info("Uploading resume");
		Thread.sleep(10000);
		driver.findElement(By.id(prop.getProperty("Professional"))).click();
		log.info("Clicking save and next button");
		Thread.sleep(1000);

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("contentframe");

		// driver.findElement(By.linkText("*Skills(Incomplete)")).click();
		Select oSelect9 = new Select(driver.findElement(By.id(prop.getProperty("SpecializedArea"))));
		oSelect9.selectByVisibleText("Java, J2EE");
		log.info("Selecting specialized area");
		Select oSelect10 = new Select(driver.findElement(By.id(prop.getProperty("SpecializedSkill"))));
		oSelect10.selectByVisibleText("Java Front End");
		log.info("Selecting specialized skills");
		driver.findElement(By.id(prop.getProperty("Skill1"))).clear();
		driver.findElement(By.id(prop.getProperty("Skill1"))).sendKeys(prop.getProperty("skill"));
		log.info("Entering skill1");
		Select oSelect11 = new Select(driver.findElement(By.id(prop.getProperty("Years1"))));
		oSelect11.selectByVisibleText("2");
		log.info("Selecting years for skill1 ");
		driver.findElement(By.id(prop.getProperty("Skills"))).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		// driver.findElement(By.id("Skillsli")).click();

		// driver.findElement(By.cssSelector("#Preferencesli > a")).click();
		driver.findElement(By.id(prop.getProperty("BusinessDomain"))).click();
		log.info("Clicking preferred employment ");
		driver.findElement(By.id(prop.getProperty("PublishToAll"))).click();
		log.info("Selecting resume publishing options ");
		driver.findElement(By.id(prop.getProperty("prefjob"))).click();
		log.info("Selecting domain experience");
		driver.findElement(By.id(prop.getProperty("Preferences"))).click();
		log.info("Clicking save and next button");
		Thread.sleep(10000);
		driver.findElement(By.id(prop.getProperty("Keywords"))).clear();
		driver.findElement(By.id(prop.getProperty("Keywords"))).sendKeys(prop.getProperty("keyword"));
		log.info("Entering keywords ");
		driver.findElement(By.id(prop.getProperty("Contarctjobtype"))).click();
		log.info("Clicking job type ");
		driver.findElement(By.id(prop.getProperty("Contracttype"))).click();
		driver.findElement(By.id(prop.getProperty("Permanentjobtype"))).click();
		driver.findElement(By.id(prop.getProperty("Jobwithtitle"))).clear();
		driver.findElement(By.id(prop.getProperty("Jobwithtitle"))).sendKeys(prop.getProperty("title"));
		log.info("Entering job with title ");
		Select oSelect12 = new Select(driver.findElement(By.id(prop.getProperty("Years"))));
		oSelect12.selectByVisibleText("2");
		log.info("Selecting years");
		driver.findElement(By.cssSelector(prop.getProperty("Yearvalue"))).click();

		// new
		// Select(driver.findElement(By.id("lbPriorityList"))).selectByVisibleText("Florida
		// (FL)");
		// driver.findElement(By.xpath("//div[@onclick='javascript:
		// OptSelect();']")).click();
		// driver.findElement(By.xpath("//div[@onclick='javascript:
		// OptUnSelect();']")).click();
		driver.findElement(By.id(prop.getProperty("AlertName"))).clear();
		driver.findElement(By.id(prop.getProperty("AlertName"))).sendKeys(prop.getProperty("alert"));
		log.info("Entering alert name ");
		driver.findElement(By.id(prop.getProperty("JobAlert"))).click();
		log.info("Clicking save and next button");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Myjobsbutton"))).click();
	}

	public void fetch() throws Exception {
		// fetching the job based on resume detail
		/**
		 * @author Durga work name : myjob
		 */
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Fetch.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(prop.getProperty("myjobs"))).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[3]/a")).click();
		log.info("clicking the my jobs tab");

		driver.findElement(By.id(prop.getProperty("fetchjobs"))).click();
		log.info("clicking fetch job tab");
		Thread.sleep(1000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		log.info("move to content frame");

		driver.findElement(By.id(prop.getProperty("keyword"))).clear();

		driver.findElement(By.id(prop.getProperty("keyword"))).sendKeys(prop.getProperty("keywords"));
		log.info("Entering the keyword");

		driver.findElement(By.id(prop.getProperty("keyall"))).click();
		log.info("select the type");

		new Select(driver.findElement(By.id(prop.getProperty("country")))).selectByVisibleText("India");
		log.info("select the country");

		new Select(driver.findElement(By.id(prop.getProperty("splzdarea")))).selectByVisibleText("Java, J2EE");
		log.info("select the specialized skills");

		driver.findElement(By.id(prop.getProperty("advoption"))).click();
		log.info("click the browse button");
		Thread.sleep(1000);

		driver.findElement(By.id(prop.getProperty("state"))).clear();
		driver.findElement(By.id(prop.getProperty("state"))).sendKeys(prop.getProperty("cityname"));
		log.info("select the state");
		Thread.sleep(1000);
		// Alert A3 = driver.switchTo().alert();
		// A3.accept();
		// driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.id("chkRemote")).click();
		// driver.findElement(By.cssSelector("i.fa.fa-forward")).click();
		// driver.findElement(By.cssSelector("div.btn.btn-upload")).click();
		// driver.findElement(By.cssSelector("i.fa.fa-backward")).click();
		driver.findElement(By.id(prop.getProperty("needh1b"))).click();
		log.info("Clicking prefered employment");

		driver.findElement(By.id(prop.getProperty("securityclearance"))).click();
		log.info("Clicking the work authorization");

		driver.findElement(By.id(prop.getProperty("nedh1b"))).click();
		log.info("Clicking the work authorization");

		// driver.findElement(By.id("chkWorkAuthorization_5")).click();
		// log.info("Clicking the work authorization");

		driver.findElement(By.id(prop.getProperty("h1bworkpermit"))).click();
		log.info("Clicking the work authorization");

		driver.findElement(By.id(prop.getProperty("ead"))).click();
		log.info("Clicking the work authorization");

		driver.findElement(By.id(prop.getProperty("greencard"))).click();
		log.info("Clicking the work authorization");
		// log.info("Clicking the work authorization");
		// WebElement driver.findElement(By.id("chkWorkAuthorization_1")).click();

		// driver.findElement(By.id("chkRemote")).click();

		driver.findElement(By.id(prop.getProperty("remote"))).click();
		log.info("Clickingthe check remote option");

		// WebElement exclwrds=driver.findElement(By.id("txtExcludeWords")); //.clear();

		driver.findElement(By.id(prop.getProperty("excludewords"))).sendKeys(prop.getProperty("excludekeyword"));
		log.info("Clicking the exclude words");

		new Select(driver.findElement(By.id(prop.getProperty("jobpost")))).selectByVisibleText("2 Days");
		log.info("Selecting a job within a days/months/years");

		driver.findElement(By.id(prop.getProperty("fetchjob"))).click();
		log.info("Clicking a fetch job button");
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
	}

	public void listing() throws Exception {
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Listing.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		// jobalert menu
		driver.findElement(By.xpath(prop.getProperty("jobalertmenu"))).click();
		// create jobalert
		driver.findElement(By.xpath(prop.getProperty("createjobalert"))).click();
		log.info("Clicking Create jobalert ");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select Select = new Select(driver.findElement(By.xpath(prop.getProperty("profileselection"))));
		log.info("Selecting profile ");
		Select.selectByIndex(5);
		// driver.findElement(By.xpath(prop.getProperty("excludecompany"))).sendKeys(prop.getProperty("excludecompanyname"));
		log.info("Entering exclude company name");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("alertname1"))).sendKeys(prop.getProperty("alertname"));
		driver.findElement(By.xpath(prop.getProperty("savebutton"))).click();
		log.info("Clicking save alert");
		// Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// back to jobalert menu
		driver.findElement(By.xpath(prop.getProperty("menu"))).click();
		Thread.sleep(100);
		// alert list
		driver.findElement(By.xpath(prop.getProperty("alertlist"))).click();
		log.info("Clicking alertlist");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");
		Select select1 = new Select(driver.findElement(By.xpath(prop.getProperty("consolidatedalert"))));
		select1.selectByIndex(0);
		Select select2 = new Select(driver.findElement(By.xpath(prop.getProperty("instantalert"))));
		select2.selectByIndex(0);
		Thread.sleep(1000);
		// delete alert
		driver.findElement(By.xpath(prop.getProperty("deleteicon"))).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

	public void feature() throws InterruptedException, IOException {
		File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Feature.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		driver.findElement(By.xpath(prop.getProperty("features_click"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("demandindex"))).click();
		Thread.sleep(2000);
		driver.switchTo().frame("contentframe");
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("profile"))).click();

		Select select = new Select(driver.findElement(By.xpath(prop.getProperty("profile"))));

		Select select1 = new Select(driver.findElement(By.xpath(prop.getProperty("spealized"))));

		Select select2 = new Select(driver.findElement(By.xpath(prop.getProperty("date"))));

		Select select3 = new Select(driver.findElement(By.xpath(prop.getProperty("state"))));

		for (int i = 0; i < 1; i++) {
			select.selectByIndex(i);
			for (int i1 = 0; i1 < 1; i1++) {
				Thread.sleep(1000);
				select1.selectByIndex(i1);
				for (int i2 = 0; i2 < 1; i2++) {
					select2.selectByIndex(i2);

					for (int i3 = 0; i3 < 1; i3++) {

						select3.selectByVisibleText("CA");
						driver.findElement(By.xpath(prop.getProperty("seeresult"))).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("FL");
						driver.findElement(By.xpath(prop.getProperty("seeresult"))).click();
						Thread.sleep(5000);
						select3.selectByVisibleText("SC");
						driver.findElement(By.xpath(prop.getProperty("seeresult"))).click();
						Thread.sleep(2000);
					}
				}
			}
		}
		Thread.sleep(3000);

		Actions action = new Actions(driver);

		driver.findElement(By.xpath(prop.getProperty("profile"))).click();
		List<WebElement> list = select.getOptions();

		for (int i = 0; i < list.size(); i++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();

			Thread.sleep(100);
		}
		for (int i1 = 0; i1 < list.size(); i1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}

		driver.findElement(By.xpath(prop.getProperty("spealized"))).click();
		List<WebElement> list1 = select1.getOptions();
		for (int j = 0; j < list1.size(); j++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int j1 = 0; j1 < list1.size(); j1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}

		driver.findElement(By.xpath(prop.getProperty("date"))).click();
		List<WebElement> list2 = select2.getOptions();
		for (int k = 0; k < list2.size(); k++) {

			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int k1 = 0; k1 < list2.size(); k1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}
		driver.findElement(By.xpath(prop.getProperty("state"))).click();
		List<WebElement> list3 = select3.getOptions();
		for (int m = 0; m < list3.size(); m++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(100);
		}
		for (int m1 = 0; m1 < list3.size(); m1++) {
			action.sendKeys(Keys.ARROW_UP).build().perform();
			Thread.sleep(100);
		}
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(100);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(100);

	}

	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		SubClass bc = new SubClass();
		bc.browserOpen();
		bc.logIn();
		// bc.upload();
		// bc.forward();
		bc.update();
		bc.fetch();
		bc.listing();
		bc.feature();
		bc.logOut();
		bc.browserClose();
	}
}
