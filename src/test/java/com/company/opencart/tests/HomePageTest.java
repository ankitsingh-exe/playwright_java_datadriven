package com.company.opencart.tests;

import com.company.constants.AppConstants;
import com.company.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 0)
    public void validateHomePageTitleTest(){
        Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.LOGIN_PAGE_TITLE, "Incorrect home page title");
    }

    @Test(priority = 1)
    public void validateHomePageUrlTest(){
        Assert.assertEquals(homePage.getHomePageUrl(), properties.get("url") , "Incorrect home page URL");
    }


    @Test(priority = 2)
    public void validateHomePageSeachTest(){
        String searchKeyword = "Macbook";
        String searchResult = homePage.doSearch(searchKeyword);
        Assert.assertTrue(searchResult.contains(searchKeyword), "The search is not successful");
    }



}
