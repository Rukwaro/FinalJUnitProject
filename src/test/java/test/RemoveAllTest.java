package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.RemoveAllPage;
import util.BrowserFactory;

public class RemoveAllTest {

	WebDriver driver;

	@Test
	public void UserShouldBeAbleToGoToSite() {

		driver = BrowserFactory.startBrowser();

		driver.get("http://techfios.com/test/107/");

		RemoveAllPage itemsList = PageFactory.initElements(driver, RemoveAllPage.class);
		itemsList.UserShouldBeAbleToRemoveAllItems();
		
		Boolean result = itemsList.checkIfAllBoxesSelected();
		//boolean result;
		
		System.out.println("All Selected" + result);
		if (!result) {
			itemsList.UserShouldBeAbleToRemoveAllItems();
			Assert.assertTrue("All Deleted", itemsList.checkIfAllBoxesSelected());

			driver.close();
			driver.quit();
		}

	}
}
