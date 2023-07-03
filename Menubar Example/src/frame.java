package menubar;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;

public class frame extends JFrame implements ActionListener, ChangeListener{
    
    JFrame frame = new JFrame();
    JMenuBar menubar = new JMenuBar();
    JMenuItem loaditem = new JMenuItem("Load");
    JMenuItem saveitem = new JMenuItem("Save");
    JMenuItem exit = new JMenuItem("Exit");

    JSlider slider = new JSlider(0, 100, 50);

    JPanel panel = new JPanel();

    JLabel label = new JLabel();

    frame()
    {
        frame.setTitle("Menu with Temp Control");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenu file = new JMenu("File");
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");

        file.setMnemonic(KeyEvent.VK_F);
        view.setMnemonic(KeyEvent.VK_V);
        help.setMnemonic(KeyEvent.VK_H);

        menubar.add(file);
        menubar.add(view);
        menubar.add(help);

        loaditem.setMnemonic(KeyEvent.VK_L);
        saveitem.setMnemonic(KeyEvent.VK_S);
        exit.setMnemonic(KeyEvent.VK_E);

        file.add(loaditem);
        file.add(saveitem);
        file.add(exit);

        loaditem.addActionListener(this);
        saveitem.addActionListener(this);
        exit.addActionListener(this);

        frame.setJMenuBar(menubar);

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
  
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli",Font.PLAIN,15));
        label.setFont(new Font("MV Boli",Font.PLAIN,25));

        slider.setOrientation(SwingConstants.VERTICAL);

        label.setText("°C = "+ slider.getValue());

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == loaditem)
        {
            System.out.println("Loading Item!");
        }
        if(e.getSource() == saveitem)
        {
            System.out.println("Saving Item!");
        }
        if(e.getSource() == exit)
        {
            System.exit(ABORT);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText("°C = " + slider.getValue());
    }
}
