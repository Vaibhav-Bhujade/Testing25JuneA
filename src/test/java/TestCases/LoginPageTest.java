package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreeshot;
import Utility.ReadData;

public class LoginPageTest extends TestBase {

	LoginPage login;
	
	//It is prerequisite to run the test case open the browser + enter URL
	//This will execute multiple times depend on number of test cases
	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		login = new LoginPage();
	}
	
	//Test case to verify visibility of login logo
	@Test (enabled = true/*, dependsOnMethods = "verifyTitleTest"*/, priority = 2)
	public void verifyLoginLogoTest()
	{
		boolean result = login.verifyLoginLogo();
		Assert.assertEquals(result, true, "test");
		Reporter.log("Login Logo visibility :- ",true);
		System.out.println("verifyLoginLogoTest");
	}
	
	//Test case to verify visibility of login logo
	@Test (enabled = true/*, dependsOnMethods = "verifyTitleTest"*/, priority = 2)
	public void verifyBotLogoTest()
	{
		boolean result = login.verifyBotLogo();
		
		Assert.assertEquals(result, true);
		
		System.out.println("verifyBotLogoTest");
		Reporter.log("Bot Logo visibility :- ",result);
	}
	
	//Test case to login to application and verify label
	@Test (enabled = true, priority = 4)
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		
		Assert.assertEquals(label, "PRODUCTS");
		
//		Assert.assertEquals(label, ReadData.readExcelFile(1, 0));
		System.out.println("loginToApp1Test");
		Reporter.log("Label Title :- " + label);
	}
	
	//Test case to login to application and verify URL
	@Test (enabled = true, priority = 5)
	public void loginToApp2Test() throws Exception
	{
		String value = login.loginToApp2();
//		Assert.assertEquals(login.loginToApp2(), "https://www.saucedemo.com/inventory.html");
		AssertJUnit.assertEquals(login.loginToApp2(), ReadData.readExcelFile(1, 1));
		System.out.println("loginToApp2Test");
		Reporter.log("URL :- " + value);
	}
	
	//Test case to verify current URL
	@Test (enabled = true, priority = 1)
	public void verifyUrlTest() throws Exception
	{
		String url = login.verifyUrl();
//		Assert.assertEquals(url, "https://www.saucedemo.com/");
		AssertJUnit.assertEquals(url, ReadData.readExcelFile(1, 3));
		System.out.println("verifyUrlTest");
		Reporter.log("URL of web application :- " + url);
	}
		
	
	//Test case to verify title
			@Test (enabled = true, priority = 0)
			public void verifyTitleTest() throws Exception
			{
				String title = login.verifyTitle();
				AssertJUnit.assertEquals(title, "Swag Labs");
//				Assert.assertEquals(title, ReadData.readExcelFile(1, 2));
				System.out.println("verifyTitleTest");
				Reporter.log("Title of web application :- " + title);
			}
			
			
	//This is post action after running the test case and will close the browser 
	//This will execute multiple times depend on number of test cases
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

//loginToApp1Test
//verifyTitleTest
//loginToApp2Test
//verifyUrlTest
//verifyBotLogoTest
//verifyLoginLogoTest

