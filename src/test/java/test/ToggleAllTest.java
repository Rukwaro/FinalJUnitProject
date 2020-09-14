package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import page.ToggleAllPage;
import util.BrowserFactory;

public class ToggleAllTest {
	WebDriver driver;

	@Test
	public void UserShouldBeAbleToGoToSite() {
		driver = BrowserFactory.startBrowser();
		driver.get("http://techfios.com/test/107/");

		ToggleAllPage toggleAll = PageFactory.initElements(driver, ToggleAllPage.class);

		toggleAll.ToToggleAll();

		Boolean result = toggleAll.isToggleAllCheckboxesSelected();
		System.out.println("All selected boxes are checked" + result);

		if (!result) {
			toggleAll.ToToggleAll();
			Assert.assertTrue(result);
		}
		Assert.assertTrue(toggleAll.checkIfAllCheckboxesSelected());
		WebElement checkbox = driver.findElement(By.name("allbox"));

		Assert.assertEquals(true, checkbox.isSelected());

	}

}