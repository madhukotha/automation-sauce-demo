package com.atmecs.saucedemo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.atmecs.saucedemo.browser.Browser;
import com.atmecs.saucedemo.constants.Constants;
import com.atmecs.saucedemo.page.keys.HomePageKeys;

public class HomePage extends Browser {
	static Logger logger = Logger.getLogger(HomePage.class);
	protected String HOME_PAGE = "homepage";
	
	public void clickOnSauceLabsBackpack() {
		getPageObject("Sauce_Lab_Back_Pack", HOME_PAGE).click();
	}

	public void clickOnMenu() {
		getPageObjectById("React_Burger_Menu_Btn", HOME_PAGE).click();
	}

	public void clickOnAllItems() {
		getPageObjectById("Inventory_Sidebar_Link", HOME_PAGE).click();
	}

	public void clickAbout() {
		getPageObjectById("About_Sidebar_Link", HOME_PAGE).click();
	}

	public void clickResetAppState() {
		getPageObjectById("Reset_Sidebar_Link", HOME_PAGE).click();
	}

	public void backpackAddToCart() {
		getPageObjectById("Add_To_Cart_Saucelab_Backpack", HOME_PAGE).click();
	}

	public void clickOnCart(){
		getPageObjectById("Shopping_Cart_Container", HOME_PAGE).click();
	}
	
	public boolean aboutMenuPage() {
		return getCurrentURL().equalsIgnoreCase(Constants.WEBSITE_ABOUT);
	}

	public boolean logoutMenuPage() {
		return getCurrentURL().equalsIgnoreCase(Constants.WEBSITE_URL);
	}

	public boolean allItemsMenuPage() {
		return getCurrentURL().equalsIgnoreCase(Constants.HOMEPAGE_URL);
	}
	
	public void clickOnLogout() {
		getPageObjectById("Logout_Sidebar_Link", HOME_PAGE).click();
	}
	
	public void filterLowCostToHigh() {
		Select select = new Select(getPageObject("FilterLowCostToHigh", HOME_PAGE));
		select.selectByVisibleText(HomePageKeys.FILTER_LOW_TO_HIGH);
	}
	
	public void lowestValuProduct() {
		getPageObject("Add_To_Cart_Lowest_Price_Product", HOME_PAGE).click();
	}
	
	public boolean cartItemIsDisplaed() {
		return getPageObjectById("Shopping_Cart_Container", HOME_PAGE).isDisplayed();
	}
	
	public boolean cartRemove() {
		try {
			if (driver.findElements(By.xpath("Cart_Remove_Button")).size() > 0) {
				return true;
			} else
				return false;

		} finally {
			System.out.println("checking Item is removed from Cart");
		}
	}
}
