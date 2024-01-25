package aut.pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class launchPage extends AbstractPage {

	private String verifyPopupText = "//*[contains(text(),'Save diagrams to:')]";
	private String decideLater = "//*[contains(text(),'Decide later')]";
	private String file = "//*[contains(text(),'File')]";
	private String help = "//*[contains(text(),'Help')]";
	private String save = "//*[text()='Save']";
	private String selectXpath = "//*[@class='geDialog']//select[contains(@style,'ellipsis')]";
	private String okXpath = "//button[@class='geBtn gePrimaryBtn' and text()='OK']";
	private String newFile = "//*[contains(text(),'New.')]";
	private String diagramName = "//*[contains(text(),'Diagram Name:')]//input";
	private String blankDiagram = "//*[contains(text(),'Blank Diagram')]";
	private String create = "//*[contains(text(),'Create')]";
	private String searchShapes = "//*[@placeholder='Search Shapes']";
	private String firstElementfrmSearch = "//*[@class='geSidebar geSearchSidebar']//a[1]";
	private String toDrop = "//*[@class='geDiagramContainer geDiagramBackdrop' and contains(@title,'Space')]//*[local-name()='svg']";
	private String firstBlock = "//*[@class='geDiagramContainer geDiagramBackdrop']//*[local-name()='g']//*[local-name()='g'][1]//*[local-name()='ellipse']";
	private String firstBlockUpdate = "//*[@class='geDiagramContainer geDiagramBackdrop']//*[local-name()='g']//*[local-name()='g'][1]//*[local-name()='rect']";
	private String Arrange = "//*[contains(text(),'Arrange')]";
	private String Layout = "//*[contains(text(),'Layout')]";
	private String HorizontalFlow = "//*[contains(text(),'Horizontal Flow')]";
	private String editDiagram = "//*[@class='mxCellEditor geContentEditable']";
	private String iterationDiagram = "//*[@class='geDiagramContainer geDiagramBackdrop']//*[local-name()='g' and contains(@style,'visibility')]";
	private String iterationDiagramLast = "//*[@class='geDiagramContainer geDiagramBackdrop']//*[local-name()='g' and contains(@style,'visibility')][last()]";
	private String cursorBottom = "//*[contains(@style,'cursor: s-resize')]";
	private String arrow = "//img[contains(@title,'Click to connect and clone')][2]";
	// private String editStyle ="//*[@class='mxPopupMenuItem' and
	// contains(text(),'Edit Style...')]";
	private String editStyle = "//*[contains(text(),'Edit Style...')]";
	private String edit = "//*[@class='geMenubar' and contains(@style,'position')]//*[text()='Edit']";
	private String textArea = "//textarea";
	private String apply = "//button[text()='Apply']";
	private String cancel = "//button[text()='Cancel']";
	private String undo = "//*[@class='geToolbar' and contains(@style,'pad')]//*[@class='geSprite geSprite-undo']";
	private String delete = "//*[@class='geToolbar' and contains(@style,'pad')]//*[@class='geSprite geSprite-delete']";
	// private String space ="//*[@class='geDiagramContainer geDiagramBackdrop' and
	// contains(@title,'Space')]//*[local-name()='svg']";
	private String space = "//*[@class='geDiagramContainer geDiagramBackdrop']";
	private String space1 = "//*[@class='geDiagramContainer geDiagramBackdrop' and contains(@title,'Space')]";
	private String noResults = "//*[contains(text(),'No results for')]";

	public int x = 0;
	public int y = 0;

	public void launchApplication() throws InterruptedException {
		setup();
		driver.get("https://app.diagrams.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void verifyAppLaunched() {
		Assert.assertTrue(driver.findElement(By.xpath(verifyPopupText)).isDisplayed());
		clickElement(decideLater);
	}

	public void createFolowchartOption() {
		clickElement(file);
		clickElement(newFile);
		setInputValue(diagramName, "Flowchart" + randomGenerator() + ".drawio");
		clickElement(blankDiagram);
		clickElement(create);
	}

	public void addShape(String shape, int x, int y) throws InterruptedException {
		Thread.sleep(1000);
		searchShape(shape);
		try {
			dragAndDrop(firstElementfrmSearch, x, y);
		} catch (NoSuchElementException e) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(noResults)).isDisplayed());
			} catch (Exception e1) {
				throw e1;
			}
		}
	}

	public void setHorizontalFlow() {
		selectAll();
		clickElement(Arrange);
		clickElement(Layout);
		clickElement(HorizontalFlow);
	}

	public void searchShape(String shape) {
		clickElement(searchShapes);
		setInputValue(searchShapes, shape);
		clickEnter(searchShapes);
	}

	public void setFlowchartValues(String arrList) throws InterruptedException {
		String[] arr = arrList.split(",");

		clickElement(space);
		Thread.sleep(1000);
		List<WebElement> eleList = driver.findElements(By.xpath(iterationDiagram));
		int i = 0;

		for (WebElement ele : eleList) {
			Thread.sleep(1000);
			doubleClick(ele);
			pasteFromClipBoard(arr[i].trim());
			i++;
		}
	}

	public void createArrow() throws InterruptedException {
		clickElement(space);
		Thread.sleep(1000);
		List<WebElement> eleList = driver.findElements(By.xpath(iterationDiagram));
		for (WebElement ele : eleList) {
			ele.click();
			Thread.sleep(2000);
			clickElement(cursorBottom);
			mouseHover(cursorBottom);
			Thread.sleep(3000);
			clickElement(arrow);
		}
	}

	public void verifyFlowchartSaved() {
		clickElement(file);
		clickElement(save);
		Select select = new Select(driver.findElement(By.xpath(selectXpath)));
		select.selectByVisibleText("Download");
		clickElement(okXpath);
	}

	public void addShapeWOScroll(String shape, int x1, int y1, String Text) throws InterruptedException {
		searchShape(shape);
		dragAndDrop(firstElementfrmSearch, x1, y1);
		Thread.sleep(1000);
		doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
		Thread.sleep(500);
		pasteFromClipBoard(Text);
		// esc();
		Thread.sleep(500);
		clickElement(space);
	}

	public void addShape(String shape, int x1, int y1, String Text) throws InterruptedException {
		searchShape(shape);
		dragAndDropScroll(firstElementfrmSearch, x1, y1);
		Thread.sleep(1000);
		doubleClick(iterationDiagramLast);
		Thread.sleep(500);
		pasteFromClipBoard(Text);
		// esc();
		Thread.sleep(500);
		clickElement(space);
	}

	public void updateShape(String from, String to) throws InterruptedException {

		// Thread.sleep(1500);
		// clickElement(help);
		// clickElement(help);
		// clickElement(space1);
		clickElement(space);
		Thread.sleep(500);
		moveToEle(firstBlock);
		Thread.sleep(500);
		// clickElement(firstBlock);
		// contextClick(firstBlock);
		clickElement(edit);
		clickElement(editStyle);
		String text = getText(textArea);
		setInputValue(textArea, text.replace(from, to));
		clickElement(apply);

	}

	public void verifyUpdateShape(String to) throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		moveToEle(firstBlockUpdate);
		/*
		 * clickElement(edit); clickElement(editStyle);
		 */
		Assert.assertEquals(driver.findElement(By.xpath(firstBlockUpdate)).isDisplayed(), true,
				"Actual shape is not equals to Expected shape");
		clickElement(undo);

	}

	public void deleteShape() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		moveToEle(firstBlock);
		Thread.sleep(500);
		clickElement(delete);
	}

	public void verifyDeleteShape() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		try {
			driver.findElement(By.xpath(firstBlock)).isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
		}
		clickElement(undo);
		Assert.assertEquals(driver.findElement(By.xpath(firstBlock)).isDisplayed(), true);
	}

	public void verifyDeleteShapeText() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		Assert.assertTrue(getText(firstBlock).equals(""), "Failed to delete");
		clickElement(undo);
	}

	public void deleteShapeText() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		moveToEle(firstBlock);
		Thread.sleep(500);
		doubleClick(firstBlock);
		delete();
	}

	public void deleteFlowchart() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		moveToEle(firstBlock);
		Thread.sleep(500);
		selectAll();
		delete();
	}

	public void verifydeleteFlowchart() throws InterruptedException {
		clickElement(space);
		Thread.sleep(500);
		try {
			driver.findElement(By.xpath(firstBlock)).isDisplayed();
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true, "Failed to delete Flowchart");
		}
	}

	public void createCode() throws InterruptedException {
		x = driver.findElement(By.xpath(firstBlock)).getLocation().getX();
		y = driver.findElement(By.xpath(firstBlock)).getLocation().getY();
		int z = 20;
		System.out.println("coordinates");
		System.out.println(x);
		System.out.println(y);
		clickElement(searchShapes);
		clickElement(firstBlock);
		searchShape("parallelogram");
		dragAndDropScroll(firstElementfrmSearch, x, y + z);
		doubleClick(iterationDiagramLast);
		pasteFromClipBoard("Read A");

		searchShape("parallelogram");
		dragAndDropScroll(firstElementfrmSearch, x, y + 2 * z);
		doubleClick(iterationDiagramLast);
		pasteFromClipBoard("Start");
		searchShape("Rectangle");
		dragAndDropScroll(firstElementfrmSearch, x, y + 3 * z);
		doubleClick(iterationDiagramLast);
		pasteFromClipBoard("Start");
		searchShape("parallelogram");
		dragAndDropScroll(firstElementfrmSearch, x, y + 4 * z);
		doubleClick(iterationDiagramLast);
		pasteFromClipBoard("Start");
		searchShape("oval");
		dragAndDropScroll(firstElementfrmSearch, x, y + z * 5);
		doubleClick(iterationDiagramLast);
		pasteFromClipBoard("Start");
		selectAll();
		clickElement(Arrange);
		clickElement(Layout);
		clickElement(HorizontalFlow);

		for (WebElement ele : driver.findElements(By.xpath(iterationDiagram))) {
			ele.click();
			Thread.sleep(2000);
			clickElement(cursorBottom);
			mouseHover(cursorBottom);
			Thread.sleep(3000);
			clickElement(arrow);

		}
	}

	/*
	 * addShapeWOScroll("Oval", x, y,"Start"); x =
	 * driver.findElement(By.xpath(firstBlock)).getLocation().getX(); y =
	 * driver.findElement(By.xpath(firstBlock)).getLocation().getY();
	 * System.out.println("coordinates"); System.out.println(x);
	 * System.out.println(y); int z=1; addShape("parallelogram", x, y,"Read A");
	 */
	/*
	 * addShape("parallelogram", x, y+z*3,"Read B"); addShape("Rectangle", x,
	 * y+z*4,"C=A+B"); addShape("parallelogram", x, y+z*5,"Print C");
	 * addShape("Oval", x, y+z*6,"End");
	 */

	/*
	 * searchShape("parallelogram"); dragAndDrop(firstElementfrmSearch, x, y);
	 * 
	 * searchShape("parallelogram"); dragAndDropScroll(firstElementfrmSearch, x, y +
	 * z); doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
	 * pasteFromClipBoard("Read A");
	 * 
	 * searchShape("parallelogram"); dragAndDropScroll(firstElementfrmSearch, x, y +
	 * 2 * z); doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
	 * pasteFromClipBoard("Start"); searchShape("Rectangle");
	 * dragAndDropScroll(firstElementfrmSearch, x, y + 3 * z);
	 * doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
	 * pasteFromClipBoard("Start"); searchShape("parallelogram");
	 * dragAndDropScroll(firstElementfrmSearch, x, y + 4 * z);
	 * doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
	 * pasteFromClipBoard("Start"); searchShape("oval");
	 * dragAndDropScroll(firstElementfrmSearch, x, y + z * 5);
	 * doubleClick(driver.findElement(By.xpath(iterationDiagramLast)));
	 * pasteFromClipBoard("Start"); selectAll(); clickElement(Arrange);
	 * clickElement(Layout); clickElement(HorizontalFlow);
	 * 
	 * for(WebElement ele: driver.findElements(By.xpath(iterationDiagram))) {
	 * ele.click(); Thread.sleep(2000); clickElement(cursorBottom);
	 * mouseHover(cursorBottom); Thread.sleep(3000); clickElement(arrow);
	 * 
	 * }
	 */

	/*
	 * x = driver.findElement(By.xpath(firstBlock)).getLocation().getX(); y =
	 * driver.findElement(By.xpath(firstBlock)).getLocation().getY(); int z = 20;
	 * System.out.println("coordinates"); System.out.println(x);
	 * System.out.println(y);
	 */

	/*
	 * addShape("Oval", x, y); addShape("parallelogram", x, y);
	 * addShape("parallelogram", x, y); addShape("Rectangle", x, y);
	 * addShape("parallelogram", x, y); addShape("Oval", x, y); setHorizontalFlow();
	 */

	/*
	 * createFolowchartOption();
	 * 
	 * String[] input = { "Start", "Read A", "Read B", "C=A+B", "Print C", "End" };
	 * setFlowchartValues(input); // clickElement(firstBlock); createArrow();
	 */

}
