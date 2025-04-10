package com.company.opencart.base;

import com.company.factory.PlaywrightFactory;
import com.company.opencart.pages.HomePage;
import com.company.opencart.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    protected PlaywrightFactory playwrightFactory;
    protected Page page;
    protected HomePage homePage;

    protected LoginPage loginPage;
    protected Properties properties;

    @BeforeTest
    public void setup(){
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.loadProperty();
        page = playwrightFactory.initialiseBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
