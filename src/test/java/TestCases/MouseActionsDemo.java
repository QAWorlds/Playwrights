package TestCases;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.MouseButton;

public class MouseActionsDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        Page page = browser.newPage();

        page.navigate("https://testautomationpractice.blogspot.com/");

        // 🔹 1. Simple Click
        page.locator("//button[text()='Click Me']").click();

        // 🔹 2. Double Click
        page.locator("//button[text()='Copy Text']").dblclick();

        // 🔹 3. Right Click (Context Click)
        page.locator("//button[text()='Point Me']").click(
                new Locator.ClickOptions().setButton(MouseButton.RIGHT)
        );

        // 🔹 4. Hover (Mouse Over)
        page.locator("//button[text()='Point Me']").hover();

        // 🔹 5. Drag and Drop
        page.dragAndDrop("#draggable", "#droppable");

        // 🔹 6. Mouse Move (coordinates)
        page.mouse().move(300, 300);

        // 🔹 7. Mouse Click using coordinates
        page.mouse().click(400, 400);

        // 🔹 8. Mouse Down & Up (manual drag example)
        page.locator("#draggable").hover();
        page.mouse().down();
        page.locator("#droppable").hover();
        page.mouse().up();

        // 🔹 9. Scroll using mouse wheel
        page.mouse().wheel(0, 500);

        page.waitForTimeout(5000);

        browser.close();
        playwright.close();
    }
}