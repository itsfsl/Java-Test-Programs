package NewWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LaunchPage implements ActionListener{
    
    JFrame myFrame = new JFrame("This is launch page");
    JButton myButton = new JButton("Press Me!");

    LaunchPage()
    {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(400, 400);
        myFrame.setLayout(null);

        myButton.setBounds(140, 150, 100, 50);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        myFrame.add(myButton);

        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == myButton)
        {
            myFrame.dispose();
            NewWindow myWindow = new NewWindow();
        }
    }
}
