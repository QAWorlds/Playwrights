package TestCases;

import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.*;

public class Assertions  {

	
	 String actualtext; 
	
	@Test
    public  void Assertions () {

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

        
       page.dragAndDrop("//p[text()='Drag me to my target']", "//p[text()='Drop here']");
        
        
         actualtext = page.locator("//h2[text()='Upload Files']").textContent();
        
        
       

        System.out.println(actualtext);

        assertThat(page.locator(actualtext))
                .hasText("Upload Files");
    }
}