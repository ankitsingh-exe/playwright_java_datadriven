package org.playwright.main;

import com.microsoft.playwright.*;

public class TextSelector {

    public static void main(String[] args) {

        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();
            page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
            Locator contactUs =  page.locator("text=Contact Sales");
            System.out.println(contactUs.count());
            System.out.println(page.locator("text=Contact Sales").first().count());


            Locator privacyLoc = page.locator("text=Privacy Policy");
            for (int i = 0;  i < privacyLoc.count(); i++){
                System.out.println(privacyLoc.nth(i).textContent());
                privacyLoc.nth(i).click();
            }


        }

    }
}
