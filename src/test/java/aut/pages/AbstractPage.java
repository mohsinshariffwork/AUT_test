package aut.pages;

import utilities.baseTest;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractPage extends baseTest {

	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Browser launch");
	}
}
