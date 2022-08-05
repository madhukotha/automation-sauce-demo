package com.atmecs.saucedemo.pages;

import org.apache.log4j.Logger;

import com.atmecs.saucedemo.browser.Browser;

public class CartPage extends Browser {
	static Logger logger = Logger.getLogger(CartPage.class);

	protected String cartpage = "cartpage";

	public void clickOnLogout() {
		getPageObjectById("Logout_Sidebar_Link", cartpage).click();
	}

	public void refreshCartPage() {
		driver.navigate().refresh();
	}

	public void checkOut() {
		getPageObjectById("Click_On_Checkout", cartpage).click();
	}

	public void checkOutInfo() {
		getPageObjectById("Fill_First_Name", cartpage).sendKeys("Madhu");

getPageObjectById("Fill_Last_Name", cartpage).sendKeys("Kotha");
getPageObjectById("Fill_Postal_Code", cartpage).sendKeys("500068");
getPageObjectById("Checkout_Continue", cartpage).click();
	}

	public void clickOnFinish() {
		getPageObjectById("Cart_Finish", cartpage).click();
	}
	
	public String getTextOfAddedProduct() {
		return getPageObject("cartItemCheking", cartpage).getText();
	}
	
	public String getTextOfShippingInfo() {
		return getPageObject("shippingInfo", cartpage).getText();
	}
	
	public String getTextCheckOutInfo() {
		return getPageObject("SuccessfullCheckOut", cartpage).getText();
	}
}
