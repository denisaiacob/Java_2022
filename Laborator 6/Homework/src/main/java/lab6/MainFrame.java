package lab6;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame()  {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(canvas,BorderLayout.CENTER); //this is BorderLayout.CENTER

        //invoke the layout manager
        pack();
    }
}

