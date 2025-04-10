package com.company.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private Locator emailAddress;
    private Locator password;
    private Locator loginButton;
    private Locator logoutLink;

    private Page page;

    public LoginPage(Page page){
        this.page = page;
        this.emailAddress = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address"));
        this.password = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"));
        this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        this.logoutLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout"));
    }

    public String getLoginPageTitle(){
        return page.title();
    }

    public boolean login(String email, String pass){
        emailAddress.fill(email);
        password.fill(pass);
        loginButton.click();

        if (logoutLink.isVisible()){
           System.out.println("login successful");
           return true;
        }else {
            System.out.println("login not successful");
            return false;
        }
    }



}
