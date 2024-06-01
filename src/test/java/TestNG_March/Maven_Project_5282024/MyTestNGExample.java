package TestNG_March.Maven_Project_5282024;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class MyTestNGExample {

	@BeforeClass
	public void inaugration() {
		System.out.println("Running All tests");
	}
	
	@AfterClass
	public void complete() {
		System.out.println("Test execution complete");
	}
	
	@BeforeMethod
	public void openBrowser() {
		System.out.println("Bhidoo...Opening Browser");
	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("Bhidoo...closing Browser");
	}

	@Test(invocationCount = 3)
	public void testSomething() {
		System.out.println("Bhidoo....testing something");
	}
	
	@Test
	public void testanything() {
		System.out.println("Bhidoo....testing anything");
	}
	
	
	@Test
	public void testwhatever() {
		System.out.println("Bhidoo....testing whatever");
	}

	

}
