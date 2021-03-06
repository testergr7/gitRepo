package eleks.eset.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PermissionSetsPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//button[@id='i212']")
	private WebElement newButton;

	public WizardPage newButton() {
		newButton.click();
		return new WizardPage();
	}
}
