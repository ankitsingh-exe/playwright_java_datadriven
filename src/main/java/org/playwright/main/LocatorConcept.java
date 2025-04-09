package org.playwright.main;

import com.microsoft.playwright.*;

public class LocatorConcept {
    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext browserContext = browser.newContext();
            Page page = browserContext.newPage();
            page.navigate("https://www.orangehrm.com/");

            Locator contactSalesLoc = page.locator("#Form_submitForm_EmailHomePage");
            contactSalesLoc.fill("abc@gmail.com");

            page.locator("#Form_submitForm_action_request").click();
            //page.close();
            //browserContext.close();
        }

    }
}
