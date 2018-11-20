package eleks.eset.sample;

import org.openqa.selenium.support.PageFactory;

import utility.Driver;

public abstract class AbstractPage {
	public AbstractPage() {
		PageFactory.initElements(Driver.Instance, this);
	}
}
