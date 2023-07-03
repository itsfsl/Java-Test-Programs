package dnd;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class dragPanel extends JPanel{
    
    JLabel label = new JLabel();
    ImageIcon pok = new ImageIcon("pok.png");
    final int WIDTH = pok.getIconWidth();
    final int HEIGHT = pok.getIconHeight();
    Point imageCorner;
    Point prevPoint;

    dragPanel()
    {
        imageCorner = new Point(0, 0);
        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        pok.paintIcon(this, g, (int)imageCorner.getX(), (int)imageCorner.getY());
        
    }

    private class ClickListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            prevPoint = e.getPoint();
        }

    }

    private class DragListener extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)
        {
            Point currentPoint = e.getPoint();

            imageCorner.translate(  (int)(currentPoint.getX() - prevPoint.getX()),
                                    (int)(currentPoint.getY() - prevPoint.getY()));
            prevPoint = currentPoint;
            repaint();
        }
    }
}
