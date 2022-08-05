package com.atmecs.saucedemo.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.saucedemo.page.keys.CartPageKeys;
import com.atmecs.saucedemo.page.keys.HomePageKeys;
import com.atmecs.saucedemo.page.keys.LoginPageKeys;
import com.atmecs.saucedemo.pages.CartPage;
import com.atmecs.saucedemo.pages.HomePage;
import com.atmecs.saucedemo.pages.LoginPage;
import com.atmecs.saucedemo.verification.Verify;

public class ProductOrderTest extends CartPage {
	static Logger logger = Logger.getLogger(ProductOrderTest.class);
	HomePage homePage;

	@Test
	public void checkFuntionalityOfProduct() {
		LoginPage.login(LoginPageKeys.STANDARD_USER, LoginPageKeys.STANDARD_USER_PASSWORD);

		homePage = new HomePage();
		homePage.filterLowCostToHigh();
		logger.info("Filter value Low Cost to High Cost");

		homePage.lowestValuProduct();
		logger.info("Lowest Valued Product Added to Cart");

		homePage.clickOnCart();
		logger.info("Clicked On Cart");

		Verify.assertString(HomePageKeys.ACTUAL_ADDED_TO_CART, getTextOfAddedProduct());
		logger.info("Item successfully added to cart");

		homePage.clickOnMenu();
		homePage.clickOnLogout();
		logger.info("louged Out Sucessfully");

		LoginPage.login();

		homePage.clickOnCart();
		logger.info("Clicked On Cart");

		Verify.assertString(HomePageKeys.ACTUAL_ADDED_TO_CART, getTextOfAddedProduct());
		logger.info("Checking CartProduct After Re-loging");

		checkOut();
		logger.info("User is Clicked on check Out");

		checkOutInfo();
		logger.info("User fills information and continue");

		Verify.assertString(CartPageKeys.ACTUAL_SHIPPING_INFO, getTextOfShippingInfo());
		logger.info("Shipping Infomation working fine");

		clickOnFinish();
		logger.info("User Clicked on finish button");

		Verify.assertString(CartPageKeys.ACTUAL_TEXT_AFTER_CHEKOUT, getTextCheckOutInfo());
		logger.info("Product Order Funtionality working fine");
		quit();
	}
}
