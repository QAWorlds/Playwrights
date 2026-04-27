package TestCases;
import com.microsoft.playwright.*;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class FileUpload {
@Test
    public  void main() {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");

        // Upload file
        page.locator("#singleFileInput")
            .setInputFiles(Paths.get("C:/Users/YourName/Desktop/sample.txt"));

        page.waitForTimeout(5000);

        browser.close();
        playwright.close();
    }
}