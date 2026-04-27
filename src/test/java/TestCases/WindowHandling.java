package TestCases;

import com.microsoft.playwright.*;

public class WindowHandling {

    public static void main(String[] args) {

        // Launch Playwright
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Open website
        page.navigate("https://demo.automationtesting.in/Windows.html");

        // Parent page reference
        Page parentPage = page;

        // Click button + capture new tab (child)
        Page childPage = context.waitForPage(() -> {
            page.click("//button[contains(text(),'click')]");
        });

        // Wait for child page to load
        childPage.waitForLoadState();

        // Print child title
        System.out.println(childPage.title());

        // Close child
        childPage.close();

        // Back to parent
        parentPage.bringToFront();
        System.out.println("Back to Parent");

        // Close browser
        browser.close();
        playwright.close();
    }
}