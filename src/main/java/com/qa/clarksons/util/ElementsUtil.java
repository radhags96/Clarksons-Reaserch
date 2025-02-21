package com.qa.clarksons.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtil {
	private WebDriver driver;

	public ElementsUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	public void clickElementWhenReady(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("element is not displayed");
			return false;
		}
	}

	public By getLocator(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;
		default:
			System.out.println("please pass right locator");
		}
		return locator;
	}

	public WebElement waitForElementPresence(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	public WebElement waitForElementVisible(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public String waitForTitleContains(String fractionTitle, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(fractionTitle))) {
				return driver.getTitle();
			}
		} catch (TimeoutException e) {
			System.out.println("title is not found after " + timeOut + "seconds");
		}
		return null;
	}

	public String waitForURLContains(String fractionURL, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.urlContains(fractionURL))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			System.out.println("title is not found after " + timeOut + "seconds");
		}
		return null;
	}
	// ******Select tag drop downs****//

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropDownByContains(By locator, String partialText) {
		Select select = new Select(getElement(locator));
		select.selectByContainsVisibleText(partialText);
	}

	public void printDropDownOptionsTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println(optionsList.size());

		List<String> optionsValueList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValueList.add(text);
		}
	}

	public List<String> getDropDownOptionsTextList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("options size: " + optionsList.size());

		List<String> optionsValueList = new ArrayList<String>();// []
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsValueList.add(text);
		}
		return optionsValueList;
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> countryOptionsList = select.getOptions();
		System.out.println("options size: " + countryOptionsList.size());
		return countryOptionsList.size();
	}

	public void selectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		boolean flag = false;

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println(value + " is available and selected");
		} else {
			System.out.println(value + " is not available");
		}
	}
	

}
