package TestCases;

import java.io.IOException;

import com.microsoft.playwright.*;
   // your Excel utility

public class ReadExcelPlaywright {

    public static void main(String[] args) throws IOException {

        // 1. Read data from Excel
        String file = "C:\\Selenium\\Testdata.xlsx";
        String username = ExcelUtils.getCellValue(file, "Sheet1", 0, 1);
        String password = ExcelUtils.getCellValue(file, "Sheet1", 1, 0);

        // 2. Launch Playwright
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        // 3. Navigate
        page.navigate("https://demo.automationtesting.in/Register.html");

        // 4. Fill data (NO WebElement, NO By)
        page.fill("//input[@type='email']", username);
        page.fill("//input[@type='tel']", password);

        // 5. Print
        System.out.println("Test executed with Username: " + username);

        // 6. Close
        browser.close();
        playwright.close();
    }
}