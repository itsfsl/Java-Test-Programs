import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calci implements ActionListener{
    
    JFrame myFrame;
    JTextField textField = new JTextField();
    JButton[] numberButtons = new JButton[10];
    JButton[] funcButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton, negButton;
    JPanel myPanel;

    Font myFont = new Font("Times New Roman", Font.PLAIN, 25);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    calci()
    {
        myFrame = new JFrame("Calci");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(350, 500);
        myFrame.setLocationRelativeTo(null);
        myFrame.setResizable(false);
        myFrame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 300, 50);
        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setText("0");
        textField.setFont(myFont);
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createBevelBorder(1));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        negButton = new JButton("(-)");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;
        funcButtons[8] = negButton;

        for (int i = 0; i < 9; i++){

            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(myFont);
            funcButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){

            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.WHITE);
        }

        negButton.setBounds(20, 390, 100, 50);
        delButton.setBounds(120, 390, 100, 50);
        clrButton.setBounds(220, 390, 100, 50);

        myPanel = new JPanel();
        myPanel.setBounds(20, 80, 300, 300);
        myPanel.setLayout(new GridLayout(4, 4, 10, 10));
        myPanel.add(numberButtons[7]);
        myPanel.add(numberButtons[8]);
        myPanel.add(numberButtons[9]);
        myPanel.add(mulButton);
        myPanel.add(numberButtons[4]);
        myPanel.add(numberButtons[5]);
        myPanel.add(numberButtons[6]);
        myPanel.add(subButton);
        myPanel.add(numberButtons[1]);
        myPanel.add(numberButtons[2]);
        myPanel.add(numberButtons[3]);
        myPanel.add(addButton);
        myPanel.add(divButton);
        myPanel.add(numberButtons[0]);
        myPanel.add(decButton);
        myPanel.add(eqButton);

        myFrame.add(myPanel);
        myFrame.add(textField);
        myFrame.add(negButton);
        myFrame.add(delButton);
        myFrame.add(clrButton);
        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i])
            if(textField.getText().equals("0")) {
                textField.setText(String.valueOf(i));
            }
            else {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton)
        {
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(null);
        }

        if(e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(null);
        }

        if(e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(null);
        }

        if(e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(null);
        }

        if(e.getSource() == eqButton)
        {
            num2 = Double.parseDouble(textField.getText());
            
            switch(operator)
            {
                case '+':
                result = num1 + num2;
                break;

                case '-':
                result = num1 - num2;
                break;
                
                case '*':
                result = num1 * num2;
                break;

                case '/':
                result = num1 / num2;
                break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if(e.getSource() == negButton)
        {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }

        if(e.getSource() == delButton)
        {
            String string = textField.getText();
            textField.setText(null);
            
            for(int i = 0; i < string.length() - 1; i++)
            {
                textField.setText(textField.getText() + string.charAt(i));
            }

            if (textField.getText().isEmpty()) {
                textField.setText("0");
            }
        }

        if(e.getSource() == clrButton)
        {
            num1 = 0;
            num2 = 0;
            result = 0;
            textField.setText("0");
        }
    }
}