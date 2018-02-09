package com.zodiacleo;

import com.zodiacleo.controller.Controller;
import com.zodiacleo.model.Model;
import com.zodiacleo.view.View;

import javax.swing.*;

public class DemoApplication
{
    public static void main(String[] a)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                go();
            }
        });
    }
    
    private static void go()
    {
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
