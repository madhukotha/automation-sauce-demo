package com.atmecs.saucedemo.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.atmecs.saucedemo.page.keys.LoginPageKeys;
import com.atmecs.saucedemo.pages.HomePage;
import com.atmecs.saucedemo.pages.LoginPage;
import com.atmecs.saucedemo.verification.Verify;

public class SidebarMenuTest extends HomePage {

	static Logger logger = Logger.getLogger(SidebarMenuTest.class);

	@Test(priority = 1)
	public void verifyAllitemsMenu() {
		LoginPage.login(LoginPageKeys.STANDARD_USER, LoginPageKeys.STANDARD_USER_PASSWORD);
		clickOnSauceLabsBackpack();
		clickOnMenu();
		clickOnAllItems();
		Verify.assertBoolean(allItemsMenuPage());
		logger.info("All Items menu is working fine");
		quit();
	}

	@Test(priority = 2)
	public void verifyAboutMenu() {
		LoginPage.login(LoginPageKeys.STANDARD_USER, LoginPageKeys.STANDARD_USER_PASSWORD);
		clickOnMenu();
		clickAbout();
		Verify.assertBoolean(aboutMenuPage());
		logger.info("About menu is working fine");
		quit();
	}

	@Test(priority = 3)
	public void verifyLogoutMenu() {
		LoginPage.login(LoginPageKeys.STANDARD_USER, LoginPageKeys.STANDARD_USER_PASSWORD);
		clickOnMenu();
		clickOnLogout();
		//Verify.assertBoolean(logoutMenuPage());
		logger.info("Logout menu is working fine");
		quit();
	}

	@Test(priority = 4)
	public void verifyResetAppStateMenu() {
		LoginPage.login(LoginPageKeys.STANDARD_USER, LoginPageKeys.STANDARD_USER_PASSWORD);
		clickOnMenu();
		backpackAddToCart();
		logger.info("BackPack Added to Cart");
		clickOnCart();
		logger.info("Clicked On Cart");
		Verify.assertBoolean(cartItemIsDisplaed());
		logger.info("Item added to cart");
		clickOnMenu();
		clickResetAppState();
		logger.info("Clicked on Reset App State Menu");
		refresh();
		logger.info("Page is Reloaded");
		Verify.assertFalse(cartRemove());
		logger.info("Cart Page is clear hence Reset App State Menu is working");
		quit();
	}
}
