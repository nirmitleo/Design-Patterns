package com.zodiacleo.view;

import com.zodiacleo.model.Model;

import javax.swing.*;

public class View extends JFrame
{
    private Model model;
    
    public View(Model model)
    {
        super("Model View Controller app");
        this.model = model;
    }
}
