package com.company.opencart.tests;

import com.company.constants.AppConstants;
import com.company.opencart.base.BaseTest;
import com.company.opencart.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;


    @Test(priority = 1)
    public void loginPageNavigationTest(){
        loginPage = homePage.clickLogin();
        Assert.assertEquals(loginPage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginTest(){
        boolean loginResult = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertTrue(loginResult);
    }


}
