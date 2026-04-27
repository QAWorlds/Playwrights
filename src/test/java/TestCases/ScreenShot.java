package TestCases;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class ScreenShot {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");

        // Full page screenshot
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("full.png"))
                .setFullPage(true));

        // Element screenshot
        page.locator("//input[@type='email']")
                .screenshot(new Locator.ScreenshotOptions()
                        .setPath(Paths.get("email.png")));

        browser.close();
        playwright.close();
    }
}