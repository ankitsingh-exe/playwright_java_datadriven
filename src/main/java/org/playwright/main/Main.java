package org.playwright.main;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.channel = "chrome";
        //lp.setHeadless(true);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext context = browser.newContext();
        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));


        Page page = context.newPage();
        page.navigate("https://www.amazon.in");
        String title = page.title();
        System.out.println("title = " + title);

        String url = page.url();
        System.out.println("url = " + url);

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        browser.close();
        playwright.close();
    }
}

