package TestCases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
public class Testcase1 {
	
	@Test
	
	
	public void Test () {
		
		Playwright playwright = Playwright.create();
		
		Browser brower = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		Page page = brower.newPage();
		
		page.navigate("https://testautomationpractice.blogspot.com/");
		
		Locator slider = page.locator("div[id='slider-range']");

		// Set value
		slider.fill("70");

		// Verify
		System.out.println(slider.getAttribute("value"));
	}

}
