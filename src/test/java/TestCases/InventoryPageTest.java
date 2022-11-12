package TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;
import Utility.ReadData;

public class InventoryPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initalization();
		invent = new InventoryPage();
		login = new LoginPage();
	}
	
	@Test (enabled = true, timeOut = 2000)
	public void verifySmallLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifySmallLogo();
		Assert.assertEquals(result, false, "Failed zali ka????????");
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		System.out.println("This is verifySmallLogoTest");
	}
	
	@Test (enabled = true, invocationCount = 5)
	public void verifyBigLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyBigLogo();
		Assert.assertEquals(result, true);
	}
	
	@Test (enabled = true)
	public void add6ProductTest() throws Exception
	{
		login.loginToApp1();
		String result = invent.add6Product();
		Assert.assertEquals(result, ReadData.readExcelFile(1, 4));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
