package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

	public static WebDriver Instance = null;
	private static String browser;

	public static WebDriver Initialize() {
		String BROWSER_NAME = "browser";
		String browserName = System.getProperty(BROWSER_NAME);
		browser = browserName;
		if (browserName == null) {
			browser = "ch";
		}
		if (Instance == null) {
			System.out.println("Initializing Driver...");
			if (browser.equals("ff")) {
				Instance = new FirefoxDriver();
			} else if (browser.equals("ch")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				Instance = new ChromeDriver();
			} else if (browser.equals("ie")) {
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				Instance = new InternetExplorerDriver();
			}
		}
		return Instance;
	}

	public static void close() {
		System.out.println("Closing browser...");
		Instance.close();
		Instance = null;
	}
}
