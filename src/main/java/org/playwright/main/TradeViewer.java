package org.playwright.main;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class TradeViewer {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

                        Page page = context.newPage();
            page.navigate("https://naveenautomationlabs.com/");
            page.locator("#menu-item-1728").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Live Training")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Handle DropDown using select")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Automation Interview Questions")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Comment *")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Comment *")).fill("gfgfgdfg");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name *")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Name *")).fill("fg");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email *")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email *")).fill("gdfggdf");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Website")).fill("fdfgdfgdf");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Post Comment")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("« Back")).click();
            page.locator("#menu-item-2448").getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Terms & Conditions")).click();
            page.getByLabel("Previous Blogs").selectOption("https://naveenautomationlabs.com/2021/10/");
            page.navigate("https://naveenautomationlabs.com/2021/10/");

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}
