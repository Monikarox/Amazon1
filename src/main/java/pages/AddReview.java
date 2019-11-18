package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.AddWait;

public class AddReview extends Page {
private final Logger log = Logger.getLogger(AddReview.class);

	
	public AddReview(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//form/div[@class='nav-left']")
	WebElement All;

	@FindBy(xpath = "//header/div/div[1]/div[1]/a")
	WebElement Menu;

	@FindBy(xpath = "//div[contains(text(),'Echo & Alexa')]")
	WebElement echo;

	@FindBy(xpath = "//div[contains(text(),'Echo Plus')]")
	WebElement echoPlus;

	@FindBy(xpath = "//*[@id=\"a-autoid-33\"]")
	WebElement review;

	@FindBy(xpath = "//*[@id=\"reviews-medley-footer\"]/div[3]/span/span/a")
	WebElement reviewB;

	@FindBy(xpath = "//*[@alt='select to rate item five star.']")

	WebElement overallRate;
	@FindBy(xpath = "//button[@class='ryp__star__button'][5]")
	WebElement rateStar;

	@FindBy(xpath = "//div[@class=\"a-input-text-wrapper\"]/textarea")
	WebElement writtenReview;

	@FindBy(xpath = "//div[@class='a-section a-spacing-large ryp__review-title']/input")
	WebElement titleOfReview;

	@FindBy(xpath = "//div[@class='ryp__form-field-card-section']/input")
	WebElement Title;

	@FindBy(xpath = "//button[@id='a-autoid-0-announce']")
	WebElement submitReview;

	@FindBy(xpath = "//form/div[6]/span/span")
	WebElement submitR;
	
	
	public static void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick)
			throws InterruptedException {
		Actions action = new Actions(driver);

		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}
	
	
	public void getItems() throws InterruptedException {
		HoverAndClick(driver, Menu, Menu);

		AddWait.forTime(1);
		echo.click();
		AddWait.forTime(1);

		echoPlus.click();
		AddWait.forTime(1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", review);

		HoverAndClick(driver, review, review);
		AddWait.forTime(2);
		try {
			overallRate.click();
		} catch (Exception e) {
			reviewB.click();
			try {
				overallRate.click();
			} catch (Exception e1) {
				try {
					if(!rateStar.isEnabled())rateStar.click();
				} catch (Exception e2) {
				}
			}
		}

		if(!rateStar.isEnabled())rateStar.click();
		writtenReview.clear();
		writtenReview.sendKeys("Very Nice product!!!!Try it once..");

		try {
			titleOfReview.clear();
			titleOfReview.sendKeys("Awesome");
		} catch (Exception e) {
			Title.clear();
			Title.sendKeys("Awesome");
		}

		AddWait.forTime(1);
		try {

			submitReview.click();
		} catch (Exception e) {

			submitR.click();
		}

	}

}
