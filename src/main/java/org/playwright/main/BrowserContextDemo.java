package org.playwright.main;

import com.microsoft.playwright.*;

public class BrowserContextDemo {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();
        page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        page1.fill("#Form_getForm_subdomain", "ankit--");
        System.out.println(page1.title());

        BrowserContext browserContext2 = browser.newContext();
        Page page2 = browserContext2.newPage();
        page2.navigate("https://www.amazon.in");
        page2.fill("#twotabsearchtextbox", "headphone");
        page2.click("nav-search-submit-button");
        System.out.println(page2.title());

        page2.close();
        browserContext2.close();

        page1.close();
        browserContext1.close();

    }
}
