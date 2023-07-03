package NewWindow;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewWindow {
    
    JFrame myFrame = new JFrame("This is a new window");
    JLabel myLabel = new JLabel("Yellow?");

    NewWindow()
    {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(400, 400);
        myFrame.setLayout(null);

        myLabel.setBounds(140, 150, 100, 50);

        myFrame.add(myLabel);

        myFrame.setVisible(true);
    }
}
