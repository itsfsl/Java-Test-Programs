package keybinder;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class gaem{
    
    JFrame myFrame = new JFrame("Yellow!");
    JLabel myLabel = new JLabel();

    Action upAction;
    Action downAction;
    Action leftAction;
    Action rightAction;

    int speed = 45;
    
    gaem()
    {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(420, 420);
        myFrame.setLayout(null);

        myLabel.setBackground(Color.red);
        myLabel.setBounds(0, 0, 100, 100);
        myLabel.setOpaque(true);

        upAction = new upAction();
        downAction = new downAction();
        leftAction = new leftAction();
        rightAction = new rightAction();

        myLabel.getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
        myLabel.getActionMap().put("up", upAction);

        myLabel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "down");
        myLabel.getActionMap().put("down", downAction);

        myLabel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
        myLabel.getActionMap().put("left", leftAction);

        myLabel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
        myLabel.getActionMap().put("right", rightAction);

        myFrame.add(myLabel);
        myFrame.setVisible(true);
    }

    public class upAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            myLabel.setLocation(myLabel.getX(), myLabel.getY() - speed);
        }
    }

    public class downAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            myLabel.setLocation(myLabel.getX(), myLabel.getY() + speed);
        }
    }

    public class leftAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            myLabel.setLocation(myLabel.getX() - speed, myLabel.getY());
        }
    }

    public class rightAction extends AbstractAction
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            myLabel.setLocation(myLabel.getX() + speed, myLabel.getY());
        }
    }
}
