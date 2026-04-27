package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.*;

import utils.ExtentManager;

public class DropDown  {

	 ExtentReports extent;
	
	
	@Test
    public  void drodown() {
		extent = ExtentManager.getInstance();
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

        
        
        
        
        page.locator("select[id='country']").selectOption("India");
        
        
        
        
        

    }
}