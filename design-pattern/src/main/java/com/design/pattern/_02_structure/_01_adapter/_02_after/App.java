package com.design.pattern._02_structure._01_adapter._02_after;

import com.design.pattern._02_structure._01_adapter._02_after.security.LoginHandler;
import com.design.pattern._02_structure._01_adapter._02_after.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);

        String login = loginHandler.login("mini", "mini");
        System.out.println(login);
    }
}
