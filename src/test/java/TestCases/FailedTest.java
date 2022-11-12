package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreeshot;
import Utility.ReadData;

public class FailedTest extends TestBase {

	LoginPage login;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		login = new LoginPage();
	}
	
	//Test case to verify visibility of login logo
	@Test 
	public void verifyLoginLogoTest()
	{
		boolean result = login.verifyLoginLogo();
		AssertJUnit.assertEquals(result, true);
		System.out.println("verifyLoginLogoTest");
	}
	
	//Test case to verify visibility of login logo
	@Test 
	public void verifyBotLogoTest()
	{
		boolean result = login.verifyBotLogo();
		AssertJUnit.assertEquals(result, false);
		System.out.println("verifyBotLogoTest");
	}
	
	//Test case to login to application and verify label
	@Test 
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		AssertJUnit.assertEquals(label, "PRODUCTS");
		System.out.println("loginToApp1Test");
	}
	
	//Test case to login to application and verify URL
	@Test 
	public void loginToApp2Test() throws Exception
	{
		AssertJUnit.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
		System.out.println("loginToApp2Test");
	}
	
	//Test case to verify current URL
	@Test 
	public void verifyUrlTest() throws Exception
	{
		String url = login.verifyUrl();
		AssertJUnit.assertEquals(url, "https://www.saucedemo.com/");
		System.out.println("verifyUrlTest");
	}
		
	//Test case to verify title
			@Test 
			public void verifyTitleTest() throws Exception
			{
				String title = login.verifyTitle();
				AssertJUnit.assertEquals(title, "Swag Labs");
				System.out.println("verifyTitleTest");
			}
						
	@AfterMethod
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			CaptureScreeshot.screenshot(it.getName());
		}
		driver.close();
	}
}

//Total 6 TC
//2 TC passed and 4 failed
//I modify 2 test


