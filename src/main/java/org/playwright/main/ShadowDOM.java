package org.playwright.main;

import com.microsoft.playwright.*;

public class ShadowDOM {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://books-pwakit.appspot.com/");
            page.locator("#input").fill("playwright books");
            System.out.println(page.locator(".books-desc").textContent());

            page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");
            System.out.println(page.locator(".books-desc").textContent());

            BrowserContext context2 = browser.newContext();
            Page page2 = context.newPage();
            page2.navigate("https://www.selectors/");
            page2.locator("#input").fill("playwright books");
            System.out.println(page2.locator(".books-desc").textContent());

        }

    }
}
