package TestCases;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;

public class BrowserIntall {

	
	
	
	@Test
    public  void BrowserIntall() {

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

        // Step 5: Print page title in console
        System.out.println(page.title());

        // Step 6: Wait (so you can see browser before it closes)
        page.waitForTimeout(5000);
page.click("input[value='sunday']");
        // Step 7: Close browser (optional)
       // browser.close();

        // Step 8: Stop Playwright engine
       // playwright.close();
    }
}