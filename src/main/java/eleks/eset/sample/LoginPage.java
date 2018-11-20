package eleks.eset.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utility.AllureUtils;
import utility.Config;
import utility.Driver;

public class LoginPage extends AbstractPage {
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	private WebElement loginInput;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement passwordInput;

	@FindBy(how = How.XPATH, using = "//button[@class='Button__btn--36HpZeBst1 primary sc-bdVaJa duIlrC']")
	public WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//div[@class='header_icon icon-g_top_bar_logout']")
	public WebElement logoutButton;

	@FindBy(how = How.XPATH, using = "//a[@class='Link__link--9x4YY0FjYG BasicForm__whiteBg--2QZqfqsCA6']")
	private WebElement changePassword;

	@FindBy(how = How.XPATH, using = "//h1[@class = 'Login__headline--2J0EBbzHxA']")
	private WebElement getString;

	@FindBy(how = How.XPATH, using = "//div[@id = 'i4']")
	private WebElement someElement;

	public void loginAsUser(String login, String password) throws InterruptedException {
		loginInput.clear();
		loginInput.sendKeys(login);
		passwordInput.clear();
		passwordInput.sendKeys(password);
		loginButton.click();
		AllureUtils.makeScreenshot(Driver.Instance);
		// Thread.sleep(5000);
		new Actions(Driver.Instance).moveToElement(someElement).perform();
		Config.waitUntil(Driver.Instance, someElement);
	}

	public void ChangePassword() {
		changePassword.click();
	}

	public void logoutButton() throws InterruptedException {
		logoutButton.click();
	}

	public String getString() {
		return getString.getText();
	}

}
