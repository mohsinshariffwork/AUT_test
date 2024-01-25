package utilities;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class baseTest {
	protected static WebDriver driver;

	public String randomGenerator() {
		Random rand = new Random();
		return String.valueOf(rand.nextInt(1000));
	}

	public void clickElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getText(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText().trim();
	}
	public void setInputValue(String xpath, String value) {
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}

	public void clickEnter(String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.RETURN);
	}

	public void waitforElementVisible(String xpath) {
	}

	public void dragAndDrop(String from, String to) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(from)))
				.moveToElement(driver.findElement(By.xpath(to))).release(driver.findElement(By.xpath(to))).build();

		dragAndDrop.perform();
	}

	public void dragAndDrop(String from, int x, int y) {
		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(from))).moveByOffset(x, y).release()
				.build();

		dragAndDrop.perform();
	}

	public void dragAndDropScroll(String from, int x, int y) {
		Actions builder = new Actions(driver);
		scrollJs();
		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(from))).moveByOffset(x, y).release()
				.build();

		dragAndDrop.perform();
	}

	public void dragAndDrop(String from, String to, int x, int y) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath(from)))
				.moveToElement(driver.findElement(By.xpath(to)), x, y).release().build();

		dragAndDrop.perform();
	}
	public void doubleClick(WebElement ele) {
		Actions builder = new Actions(driver);
		Action doubleclick = builder.doubleClick(ele).build();
		doubleclick.perform();
	}
	public void doubleClick(String ele) {
		Actions builder = new Actions(driver);
		Action doubleclick = builder.doubleClick(driver.findElement(By.xpath(ele))).build();
		doubleclick.perform();
	}
	public void contextClick(String ele) {
		Actions builder = new Actions(driver);
		Action contextClick = builder.contextClick(driver.findElement(By.xpath(ele))).build();
		contextClick.perform();
	}
	
	public void moveToEle(String ele) {
		Actions builder = new Actions(driver);
		Action moveToEle = builder.moveToElement(driver.findElement(By.xpath(ele))).click().build();
		moveToEle.perform();
	}
	public void mouseHover(String ele) {
		Actions builder = new Actions(driver);
		Action a = builder.moveToElement(driver.findElement(By.xpath(ele))).build();
		a.perform();
	}
	
	  public void scrollJs() { JavascriptExecutor j = (JavascriptExecutor) driver;
	  j.executeScript("window.scrollBy(0,-350)", ""); }
	 

	public void scroll() {
		Actions s = new Actions(driver);
		s.keyDown(Keys.PAGE_DOWN).build().perform();
	}

	public void scrollPgUp() {
		Actions s = new Actions(driver);
		s.keyDown(Keys.PAGE_UP).build().perform();
	}

	public void selectAll() {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	}
	public void esc() {
		new Actions(driver).keyDown(Keys.ESCAPE).perform();
	}

	public void delete() {
		new Actions(driver).keyDown(Keys.DELETE).perform();
	}
	public void pasteFromClipBoard(String text) {
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	}

}
