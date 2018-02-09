package com.zodiacleo.controller;

import com.zodiacleo.event.LoginEvent;
import com.zodiacleo.event.LoginListener;
import com.zodiacleo.model.Model;
import com.zodiacleo.view.View;

public class Controller implements LoginListener
{
    private Model model;
    private View view;
    
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }
    
    public void loginPerformed(LoginEvent event)
    {
        String username = event.getUsername();
        String password = event.getPassword();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
