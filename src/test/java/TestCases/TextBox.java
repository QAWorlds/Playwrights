package TestCases;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;

public class TextBox {
														
	
	
	
	@Test
    public  void textBox() {

        // Step 1: Start Playwright engine (main entry point)
        Playwright playwright = Playwright.create();

        // Step 2: Launch browser (Edge in this case)
        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                .setChannel("chrome")   // use Microsoft Edge browser
                .setHeadless(false)    // false = browser visible (true = background)
        );

        // Step 3: Open a new tab (called Page in Playwright)
        Page page = browser.newPage();

        // Step 4: Navigate to a website
        page.navigate("https://testautomationpractice.blogspot.com/");
page.click(".wikipedia-search-button");
         page.locator("//input[@placeholder='Enter Name']").fill("aravind");
    }
}