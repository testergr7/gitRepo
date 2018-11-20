package eleks.eset.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//a[@id='i2137']")
	private WebElement refresh;

	@FindBy(how = How.XPATH, using = "//a[@id='i13']")
	private WebElement reports;

	@FindBy(how = How.XPATH, using = "//a[@id='i11']")
	private WebElement computers;

	@FindBy(how = How.XPATH, using = "//a[@id='i1821']")
	private WebElement more;

	@FindBy(how = How.XPATH, using = "//a[@id='i25']")
	private WebElement nativeUsers;

	@FindBy(how = How.XPATH, using = "//a[@id='i26']")
	private WebElement permissionSets;

	@FindBy(how = How.XPATH, using = "//div[@id='i781']")
	private WebElement addNewDashboard;

	@FindBy(how = How.XPATH, using = "//button[@id='i477']")
	private WebElement addButton;

	@FindBy(how = How.XPATH, using = "//input[@id='i779']")
	private WebElement inputDashboardName;
	

	public void refresh() {
		refresh.click();
	}

	public NativeUsersPage nativeUsers() {
		nativeUsers.click();
		return new NativeUsersPage();
	}

	public PermissionSetsPage permissionSets() {
		permissionSets.click();
		return new PermissionSetsPage();
	}

	public void more() {
		more.click();
	}

	public ReportsPage reports() {
		reports.click();
		return new ReportsPage();
	}

	public ComputersPage computers() {
		computers.click();
		return new ComputersPage();
	}

	public void addNewDashboard() {
		addNewDashboard.click();
	}

	public void addButton() {
		addButton.click();
	}

	public void inputDashboardName(String name) {
		inputDashboardName.sendKeys(name);
	}

}
