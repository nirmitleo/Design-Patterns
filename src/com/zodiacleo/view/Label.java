package com.zodiacleo.view;

import javax.swing.*;
import java.awt.*;

public class Label extends JPanel
{
    private final JLabel label;
    
    public Label(String text)
    {
        label = new JLabel(text);
        
        this.setLayout(new GridLayout());
        this.add(label);
    }
}
