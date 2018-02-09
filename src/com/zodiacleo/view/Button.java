package com.zodiacleo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button extends JPanel
{
    private final JButton button;
    
    public Button(String text)
    {
        button = new JButton(text);
        
        this.setLayout(new GridLayout());
        this.add(button);
    }
    
    public void addActionListener(ActionListener actionListener)
    {
        button.addActionListener(actionListener);
    }
}
