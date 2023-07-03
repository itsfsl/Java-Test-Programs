package notepad;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class texteditor extends JFrame implements ActionListener{
    
    JTextArea textArea;
    JScrollPane scrollBar;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem open;
    JMenuItem save;
    JMenuItem exit;

    JSpinner fontSizeSpinner;
    JLabel fontSizeSpinnerLabel;
    JButton fontColorButton;
    JComboBox fontFamilyBox;
    
    texteditor() {

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 25));
        textArea.setForeground(Color.white);
        textArea.setBackground(Color.black);
        textArea.setCaretColor(Color.white);

        scrollBar = new JScrollPane(textArea);
        scrollBar.setPreferredSize(new Dimension(800, 500));
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        open = new JMenuItem("Open");
        open.addActionListener(this);
        save = new JMenuItem("Save");
        save.addActionListener(this);
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);

        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(exit);
        menuBar.add(fileMenu);

        fontSizeSpinner = new JSpinner();
        fontSizeSpinnerLabel = new JLabel("Font Size: ");
        fontSizeSpinner.setValue(25);
        fontSizeSpinner.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
                }
        });
        
        fontColorButton = new JButton("Font Color", null);
        fontColorButton.setFocusable(false);
        fontColorButton.addActionListener(this);
        

        String[] availableFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontFamilyBox = new JComboBox<>(availableFonts);
        fontFamilyBox.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(900, 600);
        this.setTitle("FSL Text Editor");

        this.setJMenuBar(menuBar);
        this.add(fontSizeSpinnerLabel);
        this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontFamilyBox);
        this.add(scrollBar);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == open)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileReader = null;

                try {
                    fileReader = new Scanner(file);
                    if (file.isFile())
                    {
                        textArea.setText("");
                        while(fileReader.hasNextLine())
                        {
                            String line = fileReader.nextLine() + "\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                finally {
                    fileReader.close();
                }
            }
        }
        if (e.getSource() == save)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION)
            {
                File file;
                PrintWriter printFile = null;

                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    printFile = new PrintWriter(file);
                    printFile.println(textArea.getText());

                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                finally {
                    printFile.close();
                }

            }
        }
        if (e.getSource() == exit)
        {
            System.exit(0);
        }
        if (e.getSource() == fontColorButton)
        {
            JColorChooser colorChooser = new JColorChooser();

            Color color = colorChooser.showDialog(null, "Choose font color", Color.white);

            textArea.setForeground(color);
        }
        if (e.getSource() == fontFamilyBox)
        {
            textArea.setFont(new Font((String) fontFamilyBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }
    }
}
