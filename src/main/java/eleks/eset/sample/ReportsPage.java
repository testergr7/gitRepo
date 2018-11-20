package eleks.eset.sample;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utility.Driver;

public class ReportsPage extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//button[@id='i1685']")
	private WebElement newCategoryButton;

//	@FindBy(how = How.XPATH, using = "//button[@id='i1781']")
//	private WebElement collapseButton;
	
	@FindBy(how = How.XPATH, using = "//parent::button[@id='i1781']")
	private WebElement collapseButton;

	@FindBy(how = How.XPATH, using = "//button[@id='i1780']")
	private WebElement expandButton;

	@FindBy(how = How.XPATH, using = "//div[@id = 'i4']")
	private WebElement someElement;

	public WizardPage newCategoryButton() {
		newCategoryButton.click();
		return new WizardPage();
	}

	public void collapseButton() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) Driver.Instance);
		js.executeScript("arguments[0].click();", collapseButton);
	}

	public void expandButton() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) Driver.Instance);
		js.executeScript("arguments[0].click();", expandButton);
	}

}
