package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.xsom.impl.scd.Iterators.Filter;

public class Mobiles extends Page {
	private final Logger log = Logger.getLogger(Mobiles.class);

	public Mobiles(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Gift Cards')]")
	WebElement Card;

	@FindBy(xpath = "//div[@class='acs-ln-nav-section acs-ln-nav-expanded']/button[@class='acs-ln-header acs-ln-no-image acs-ln-widget--ember']")
	WebElement buttonClose;

	@FindBy(xpath = "//button[contains(text(),'Amazon Gift Cards: Special Features')]")
	WebElement load;
	
	@FindBy(xpath = "//div[@class='acs-ln-links']/ul/li/a[contains(text(),'Reload Your Balance')]")
	WebElement openBal;

	@FindBy(xpath = "//div[@class='a-section a-spacing-medium a-padding-none a-text-left']/span[2]")
	WebElement CurrBal;
	
	@FindBy(xpath = "//*[@id='asv-manual-reload-amount']")
	WebElement AddDollars;
	
	@FindBy(xpath = "//input[@type='radio']")
	WebElement CardSelect;
	
	@FindBy(xpath = "//button[@id='form-submit-button']" )
	WebElement submit;
	
	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	WebElement comment;
	
	//part2
	
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	WebElement searchBar;
	
	@FindBy(xpath ="//form/div[2]/div/input" )
	WebElement SearchBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Automotive Seat Back Organizers')]")
	WebElement filter;
	
	@FindBy(xpath = "//a[@class='a-link-normal a-text-normal']/span[@class='a-size-base-plus a-color-base a-text-normal']")
	List<WebElement> list;
	public void getMobile() throws InterruptedException {
Card.click();
Thread.sleep(1000);
buttonClose.click();
Thread.sleep(1000);
load.click();
openBal.click();
System.out.println("Current Account Balance:  "+CurrBal.getText());
AddDollars.sendKeys("0.50");
CardSelect.click();
submit.click();
Thread.sleep(2000);


		
	}
	public void addtoCart()
	{
		searchBar.sendKeys("Uber");
		SearchBtn.click();
		filter.click();
		
		for(WebElement item: list) {
			
			System.out.println(item.getText()+"\n");
		}
		
	}
	

}
