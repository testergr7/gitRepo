package eleks.eset.sample;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import utility.AllureUtils;
import utility.Config;
import utility.Driver;

public class SmokeTests {

	Logger log = Logger.getLogger(SmokeTests.class);

	@BeforeClass
	public void setUp() {
		Driver.Initialize();
		Config.browserSetUp();
	}

	@AfterClass
	public void close() {
		Driver.Instance.quit();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if (ITestResult.FAILURE == result.getStatus()) {
			Config.captureScreenshot(Driver.Instance, result.getName());
			AllureUtils.makeScreenshot(Driver.Instance);
		}
	}

	@DataProvider(name = "TestData")
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "Administrator";
		data[0][1] = "Passw0rd1234";
		data[0][2] = "MyName";

		data[1][0] = "Administrator1";
		data[1][1] = "Passw0rd1";
		data[1][2] = "MyName1";

		return data;
	}

	@DataProvider(name = "TestData1")
	public Object[][] getData1() {
		Object[][] data = new Object[1][3];
		data[0][0] = "Administrator";
		data[0][1] = "Passw0rd1234";
		data[0][2] = "MyName";

		return data;
	}

	@Test(priority = 1, dataProvider = "TestData1") // login-logout test as Administrator
	public void logInTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		log.info("-------------------------------------------------------------------> INFO");
		log.warn("-------------------------------------------------------------------> Warn");
		log.fatal("-------------------------------------------------------------------> FATAL");
		log.debug("-------------------------------------------------------------------> DEBUG");
		loginPage.logoutButton();
		Assert.assertTrue(loginPage.getString().contains("Log in"));
	}

	// @Test(priority = 2, dataProvider = "TestData1") // creating new Dashboard tab
	public void createNewDashboardTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.addNewDashboard();
		dashboardPage.inputDashboardName(name);
		dashboardPage.addButton();
		loginPage.logoutButton();
	}

	// @Test(priority = 3, dataProvider = "TestData1") // create new Permission Sets
	public void NewPermissionSetsTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.more();
		dashboardPage.permissionSets().newButton();
		WizardPage wizard = new WizardPage();
		wizard.inputNameLarge(name);
		wizard.continueButton();
		wizard.selectGroup();
		wizard.selectCheckBox();
		wizard.clickOK();
		wizard.continueButton();
		wizard.grandFullAccess();
		wizard.continueButton();
		wizard.continueButton();
		wizard.addAllButton();
		wizard.continueButton();
		wizard.finishButton();
		loginPage.logoutButton();
	}

	// @Test(priority = 4, dataProvider = "TestData1") // create new Native User
	public void NewNativeUserTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.more();
		dashboardPage.nativeUsers().newButton();
		WizardPage wizard = new WizardPage();
		wizard.inputNameLarge(name);
		wizard.clickHomeGroup();
		wizard.selectHomeGroup();
		wizard.clickOK();
		wizard.showPassword();
		wizard.setPassword(password);
		wizard.continueButton();
		wizard.addAllButton();
		wizard.continueButton();
		wizard.finishButton();
		loginPage.logoutButton();
	}

	// @Test(priority = 5, dataProvider = "TestData1") // create new Report Category
	public void NewCategoryTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.reports().newCategoryButton();
		WizardPage wizard = new WizardPage();
		wizard.inputNameLarge(name);
		wizard.finishButton();
		loginPage.logoutButton();
	}

//	@Test(priority = 6, dataProvider = "TestData1") // Collapse Expand Report Category
	public void CollapseExpandTest(String username, String password, String name) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.loginAsUser(username, password);
		DashboardPage dashboardPage = new DashboardPage();
		dashboardPage.reports().collapseButton();
		dashboardPage.reports().expandButton();
		loginPage.logoutButton();
	}
	
//	@Test(priority = 7) // REST APi response code 200
	public void ValidateResponseStatusCode_200() {
		RestAssured.baseURI = "http://172.25.115.76:8080/era/webconsole/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("http://172.25.115.76:8080/era/webconsole/");
		Assert.assertEquals(200, response.getStatusCode());
	}

}