package eleks.eset.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WizardPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//button[@id='i1819']")
	private WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//button[@id='i6']")
	private WebElement finishButton;

	@FindBy(how = How.XPATH, using = "//input[@class='textBoxLargeSize']")
	private WebElement inputNameLarge;

	@FindBy(how = How.XPATH, using = "//button[@id='i219']")
	private WebElement selectGroup;

	@FindBy(how = How.XPATH, using = "//span[@class='triStateCheckBox triStateCheckBox-notchecked']")
	private WebElement selectCheckBox;

	@FindBy(how = How.XPATH, using = "//button[@id='i68']")
	private WebElement clickOK;

	@FindBy(how = How.XPATH, using = "//button[@id='i218']")
	private WebElement grandFullAccess;

	@FindBy(how = How.XPATH, using = "//button[@id='i27']")
	private WebElement addAllButton;

	@FindBy(how = How.XPATH, using = "//button[@id='i1457']")
	private WebElement clickHomeGroup;

	@FindBy(how = How.XPATH, using = "//div[@class='GG-QS0WCAG']")
	private WebElement selectHomeGroup;

	@FindBy(how = How.XPATH, using = "//button[@id='i715-i29']")
	private WebElement showPassword;

	@FindBy(how = How.XPATH, using = "//input[@class='gwt-TextBox textBoxLargeSize']")
	private WebElement setPassword;

	public void continueButton() {
		continueButton.click();
	}

	public void finishButton() {
		finishButton.click();
	}

	public void inputNameLarge(String name) {
		inputNameLarge.clear();
		inputNameLarge.sendKeys(name);
	}

	public void selectGroup() {
		selectGroup.click();
	}

	public void selectCheckBox() {
		selectCheckBox.click();
	}

	public void clickOK() {
		clickOK.click();
	}

	public void grandFullAccess() {
		grandFullAccess.click();
	}

	public void addAllButton() {
		addAllButton.click();
	}

	public void clickHomeGroup() {
		clickHomeGroup.click();
	}

	public void selectHomeGroup() {
		selectHomeGroup.click();
	}

	public void showPassword() {
		showPassword.click();
	}

	public void setPassword(String pass) {
		setPassword.clear();
		setPassword.sendKeys(pass);
	}
}
