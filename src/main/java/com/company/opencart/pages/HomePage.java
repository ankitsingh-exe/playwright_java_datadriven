package com.company.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    private String search = "input[name='search']";
    private String searchButton = "div#search button";
    private String searchPageHeader = "div#content h1";

    public HomePage(Page page){
        this.page = page;
    }

    public String getHomePageTitle(){
        return page.title();
    }

    public String getHomePageUrl(){
        return page.url();
    }

    public String doSearch(String productName){
        page.fill(search, productName);
        page.click(searchButton);
        return page.locator(searchPageHeader).textContent();
    }


}
