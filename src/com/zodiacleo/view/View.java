package com.zodiacleo.view;

import com.zodiacleo.event.LoginEvent;
import com.zodiacleo.event.LoginListener;
import com.zodiacleo.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame
{
    private Model model;
    private final static Label USERNAME_LABEL = new Label("Username:");
    private final static Label PASSWORD_LABEL = new Label("Password:");
    private final static JTextField USERNAME_TEXTFIELD = new JTextField("for eg - zodiacLeo", 10);
    private final static JPasswordField PASSWORD_PASSWORDFIELD = new JPasswordField(10);
    private final static Button CLICK_BUTTON = new Button("Login..");
    
    private ArrayList<LoginListener> loginListeners;
    
    private final static int WIDTH = 900;
    private final static int HEIGHT = (WIDTH * 9) / 16;
    
    public View(Model model)
    {
        super("Model View Controller app");
        this.setLayout(new GridBagLayout());
        
        this.model = model;
        this.loginListeners = new ArrayList<>();
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        
        
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.insets = new Insets(100, 0, 0, 2);
        this.add(USERNAME_LABEL, gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.insets = new Insets(100, 0, 0, 0);
        this.add(USERNAME_TEXTFIELD, gc);
        
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 2);
        this.add(PASSWORD_LABEL, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        this.add(PASSWORD_PASSWORDFIELD, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 2;
        gc.insets = new Insets(0, 0, 200, 0);
        gc.anchor = GridBagConstraints.PAGE_START;
        this.add(CLICK_BUTTON, gc);
        
        CLICK_BUTTON.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String username = USERNAME_TEXTFIELD.getText();
                String password = new String(PASSWORD_PASSWORDFIELD.getPassword());
                for (int i = 0; i < loginListeners.size(); i++)
                {
                    LoginListener loginListener = loginListeners.get(i);
                    loginListener.loginPerformed(new LoginEvent(username, password));
                }
            }
        });
        
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void addClickListener(LoginListener loginListener)
    {
        if (loginListener != null)
        {
            loginListeners.add(loginListener);
        }
    }
    
}
