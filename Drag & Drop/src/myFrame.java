package dnd;

import javax.swing.JFrame;

public class myFrame extends JFrame{
    
    dragPanel dragPanel = new dragPanel();

    myFrame()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(null);
        this.setSize(600, 600);

        this.add(dragPanel);
        this.setVisible(true);
    }
}
