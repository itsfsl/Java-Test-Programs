package dvd;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dvdpanel extends JPanel implements ActionListener{
    
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image dvdlogo = new ImageIcon("pok.png").getImage();
    Image bg = new ImageIcon("bg.jpg").getImage();
    Timer timer;
    int xSpeed = 5;
    int ySpeed = 2;
    int x, y = 0;

    dvdpanel()
    {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.white);
        timer = new Timer(1, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(x>=PANEL_WIDTH - dvdlogo.getHeight(null) || x<0){
            xSpeed = xSpeed * -1;
        }

        if(y>=PANEL_HEIGHT - dvdlogo.getWidth(null) || y<0){
            ySpeed = ySpeed * -1;
        }

        x = x + xSpeed;
        y = y + ySpeed;
        
        repaint();
    }

    public void paint (Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg, 0, 0, null);
        g2d.drawImage(dvdlogo, x, y, null);
    }
}
