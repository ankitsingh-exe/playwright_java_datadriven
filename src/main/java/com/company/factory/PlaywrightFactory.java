package com.company.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initialiseBrowser(String browserName){
        System.out.println("Browser name is " + browserName);
        playwright = Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please pass correct browser name i.g. chromium, firefox, safari, chrome");
                break;
        }

        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://www.naveenautomationlabs.com/opencart");

        return page;


    }



}
