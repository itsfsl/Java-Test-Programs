package logsys;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class loginsys implements ActionListener{

    HashMap<String, String> logininfo = new HashMap<String, String>();

    JLabel username = new JLabel("Username:");
    JLabel password = new JLabel("Password:");
    JTextField inputField;
    JPasswordField passField;
    JButton loginButton;
    JButton resetButton;
    JLabel status;
    
    loginsys(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        username.setBounds(10, 30, 100, 10);
        password.setBounds(10, 90, 100, 10);

        inputField = new JTextField();
        inputField.setBounds(50, 50, 180, 30);
        
        passField = new JPasswordField();
        passField.setBounds(50, 110, 180, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(50, 160, 80, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setBounds(150, 160, 80, 30);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        status = new JLabel();
        status.setBounds(50, 210, 150, 30);

        JFrame myFrame = new JFrame("Login System");
        myFrame.setSize(300, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setLocationRelativeTo(null);

        myFrame.add(username);
        myFrame.add(inputField);
        myFrame.add(password);
        myFrame.add(passField);
        myFrame.add(loginButton);
        myFrame.add(resetButton);
        myFrame.add(status);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == resetButton) {

            inputField.setText(null);
            passField.setText(null);
            status.setText(null);
        }

        if (e.getSource() == loginButton) {

            String userID = inputField.getText();
            String pass = String.valueOf(passField.getPassword());

            if (logininfo.containsKey(userID)) {
                if (logininfo.get(userID).equals(pass)) {
                    status.setForeground(Color.GREEN);
                    status.setText("Login Successful!");
                }
                else {
                    status.setForeground(Color.RED);
                    status.setText("Incorrect Password!");
                }
            }
            else {
                status.setForeground(Color.RED);
                status.setText("Incorrect Username!");
            }
        }
    }
}
