package TestCases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class WaitsDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        // 🔹 1. Auto Wait (default)
        page.navigate("https://testautomationpractice.blogspot.com/");
        page.locator("//button[text()='Click Me']").click(); 
        // 👉 Automatically waits for element
        page.locator("#msg").waitFor();
        // 🔹 2. Wait for Element Visible
        page.locator("#Wikipedia1").waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE)
        );

        // 🔹 3. Wait for Page Load
        page.waitForLoadState(LoadState.LOAD);

        // 🔹 4. Wait for URL Change
        page.locator("a[href='https://www.wikipedia.org/']").click();
        page.waitForURL("**wikipedia.org**");

        // 🔹 5. Wait for Timeout (Hard wait - avoid in real projects)
        page.waitForTimeout(3000);

        // 🔥 Bonus: Assertion (Best Practice)
        assertThat(page).hasURL("https://www.wikipedia.org/");

        browser.close();
        playwright.close();
    }
}