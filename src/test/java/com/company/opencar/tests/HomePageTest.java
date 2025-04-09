package com.company.opencar.tests;

import com.company.factory.PlaywrightFactory;
import com.company.opencart.pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    PlaywrightFactory playwrightFactory;
    private Page page;
    HomePage homePage;

    @BeforeTest
    public void setup(){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initialiseBrowser("chromium");
        homePage = new HomePage(page);
    }

    @Test(priority = 0)
    public void validateHomePageTitle(){
        Assert.assertEquals(homePage.getHomePageTitle(), "Your Store", "Incorrect home page title");
    }

    @Test(priority = 1)
    public void validateHomePageUrl(){
        Assert.assertEquals(homePage.getHomePageUrl(), "https://www.naveenautomationlabs.com/opencart/", "Incorrect home page URL");
    }


    @Test(priority = 2)
    public void validateHomePageSeach(){
        String searchKeyword = "Macbook";
        String searchResult = homePage.doSearch(searchKeyword);
        Assert.assertTrue(searchResult.contains(searchKeyword), "The search is not successful");
    }


    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }

}
