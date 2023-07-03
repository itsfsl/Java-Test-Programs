package filechooser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class myframe extends JFrame implements ActionListener{
    
    JButton button = new JButton("File Chooser");
    JButton colorchoose = new JButton("Color Chooser");

    myframe()
    {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        colorchoose.setBounds(0,0, 120, 50);
        colorchoose.setFocusable(false);
        colorchoose.addActionListener(this);

        button.setBounds(0,0, 120, 50);
        button.setFocusable(false);
        button.addActionListener(this);

        this.add(colorchoose);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            JFileChooser fileChooser = new JFileChooser("C:\\Users\\direc\\Desktop");
            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION)
            {
                System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
        if(e.getSource() == colorchoose)
        {
            JColorChooser colorchoose = new JColorChooser();
            Color color = JColorChooser.showDialog(colorchoose, "Choose baby", Color.black);
            this.getContentPane().setBackground(color);
        }
    }
}
