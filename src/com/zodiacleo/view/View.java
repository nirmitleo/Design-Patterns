package com.zodiacleo.view;

import com.zodiacleo.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener
{
    private Model model;
    private JButton helloButton;
    private JButton goodByeButton;
    
    
    private final static int WIDTH = 900;
    private final static int HEIGHT = (9 * WIDTH) / 16;
    
    public View(Model model)
    {
        super("Observer pattern app!");
        this.model = model;
        this.helloButton = new JButton("Hello Button!");
        this.goodByeButton = new JButton("Goodbye Button!");
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        this.add(this.helloButton, gc);
        
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        this.add(this.goodByeButton, gc);
        
        
        this.helloButton.addActionListener(this);
        this.goodByeButton.addActionListener(this);
        this.goodByeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Did I say hello first?");
            }
        });
        
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = ((JButton) e.getSource());
        System.out.println(button.getText() + " was clicked!");
    }
}
