package dvd;

import javax.swing.JFrame;

public class dvdframe extends JFrame{
    
    dvdpanel panel;

    dvdframe()
    {
        panel = new dvdpanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
