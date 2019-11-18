package pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Login extends Page {

	private final Logger log = Logger.getLogger(Login.class);

	public Login(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	WebElement LoginFind;

	@FindBy(xpath = "//*[@id='nav-flyout-ya-signin']/a")
	WebElement login;
	@FindBy(xpath = "//*[@id='ap_email']")
	WebElement UserName;

	@FindBy(xpath = "//*[@id='continue']")
	WebElement UserSubmit;

	@FindBy(xpath = "//*[@id='ap_password']")
	WebElement Password;

	@FindBy(xpath = "//*[@id='signInSubmit']")
	WebElement PassSubmit;
	// Test2
	

	public void putUsername() {
		try {
			Thread.sleep(1000);
			UserName.sendKeys("7839405080");
		} catch (Exception e) {

			login.click();
			UserName.sendKeys("7839405080");
		}
		UserSubmit.click();
		log.info("Wrong Pass!!");
		UserName.clear();
		UserName.sendKeys("7739405080");
		UserSubmit.click();
		log.info("Right Pass :)");

	}

	public void putPassword() {

		Password.sendKeys("facker@123");
		PassSubmit.click();
		log.info("Wrong Username!!");
		Password.clear();
		Password.sendKeys("hacker@123");
		PassSubmit.click();
		log.info("Right Username :)");

	}

	public void loginClick() {
	try {
		LoginFind.click();
	}catch(Exception e) {
		
	}

	}



	
	
}
