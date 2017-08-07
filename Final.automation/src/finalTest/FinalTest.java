package finalTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinalTest extends SubClass {
	SubClass ii = new SubClass();

	@BeforeTest
	public void f() throws Exception {
		ii.browserOpen();
		ii.logIn();
	}

	@Test
	public void g() throws Exception {

		ii.upload();
		ii.forward();
		ii.update();
		ii.fetch();
		ii.listing();
		ii.feature();

	}

	@AfterTest
	public void h() throws Exception {

		ii.logOut();
		ii.browserClose();

	}
}
