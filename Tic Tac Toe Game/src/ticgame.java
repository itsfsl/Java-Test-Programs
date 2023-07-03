import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ticgame implements ActionListener{
    
    Color backgroundColor = Color.decode("#2F4858");
    Color buttonColor = Color.decode("#33658A");
    Color foregroundColor = Color.decode("#55DDE0");
    Color playerX = Color.decode("#F6AE2D");
    Color playerO = Color.decode("#F26419");
    Color winner = Color.decode("#23912f");

    JFrame gameFrame = new JFrame("Tic-Tac-Toe");
    JPanel titlePanel = new JPanel();
    JPanel playPanel = new JPanel();
    JLabel titleLabel = new JLabel();
    JButton[] playButtons = new JButton[9];
    JButton restartButton = new JButton("New Game");

    Random random = new Random();

    boolean xTurn = false;
    boolean gameRunning = true;

    ticgame() {
        
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(600, 600);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.getContentPane().setBackground(backgroundColor);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 600, 50);
        titlePanel.add(titleLabel);

        titleLabel.setText("Tic-Tac-Toe");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe Script", Font.ITALIC, 60));
        titleLabel.setBackground(backgroundColor);
        titleLabel.setForeground(foregroundColor);
        titleLabel.setOpaque(true);

        restartButton.setBounds(440, 20, 120, 50);
        restartButton.setFocusable(false);
        restartButton.setFont(new Font("Segoe Script", Font.ITALIC, 15));
        restartButton.addActionListener(this);
        restartButton.setVisible(false);
        gameFrame.add(restartButton);

        for (int i = 0; i < 9; i++) {

            playButtons[i] = new JButton();
            playButtons[i].setBackground(buttonColor);
            playButtons[i].setFocusable(false);
            playButtons[i].setFont(new Font("Segoe Script", Font.ITALIC, 75));
            playButtons[i].addActionListener(this);
            playPanel.add(playButtons[i]);
        }

        playPanel.setLayout(new GridLayout(3, 3, 5, 5));
        playPanel.setBackground(backgroundColor);
        
        gameFrame.add(titlePanel, BorderLayout.NORTH);
        gameFrame.add(playPanel);
        gameFrame.setVisible(true);

        newTurn();
    }

    public void newTurn() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        int player = random.nextInt(2);
        if (player == 1) {
            xTurn = true;
            titleLabel.setText("X Turn");
        }
        else {
            xTurn = false;
            titleLabel.setText("O Turn");
        }
    }

    public void checkWinner() {
        // X Wins
        if (playButtons[0].getText() == "X" &&
            playButtons[1].getText() == "X" &&
            playButtons[2].getText() == "X") {
                xWins(0, 1, 2);
            }

        if (playButtons[3].getText() == "X" &&
            playButtons[4].getText() == "X" &&
            playButtons[5].getText() == "X") {
                xWins(3, 4, 5);
            }
            
        if (playButtons[6].getText() == "X" &&
            playButtons[7].getText() == "X" &&
            playButtons[8].getText() == "X") {
                xWins(6, 7, 8);
            }

        if (playButtons[1].getText() == "X" &&
            playButtons[4].getText() == "X" &&
            playButtons[7].getText() == "X") {
                xWins(1, 4, 7);
            }

        if (playButtons[2].getText() == "X" &&
            playButtons[5].getText() == "X" &&
            playButtons[8].getText() == "X") {
                xWins(2, 5, 8);
            }
        
        if (playButtons[0].getText() == "X" &&
            playButtons[3].getText() == "X" &&
            playButtons[6].getText() == "X") {
                xWins(0, 3, 6);
            }

        if (playButtons[0].getText() == "X" &&
            playButtons[4].getText() == "X" &&
            playButtons[8].getText() == "X") {
                xWins(0, 4, 8);
            }
            
        if (playButtons[2].getText() == "X" &&
            playButtons[4].getText() == "X" &&
            playButtons[6].getText() == "X") {
                xWins(2, 4, 6);
            }
        // Y Wins
        if (playButtons[0].getText() == "O" &&
            playButtons[1].getText() == "O" &&
            playButtons[2].getText() == "O") {
                oWins(0, 1, 2);
            }

        if (playButtons[3].getText() == "O" &&
            playButtons[4].getText() == "O" &&
            playButtons[5].getText() == "O") {
                oWins(3, 4, 5);
            }
            
        if (playButtons[6].getText() == "O" &&
            playButtons[7].getText() == "O" &&
            playButtons[8].getText() == "O") {
                oWins(6, 7, 8);
            }
        
        if (playButtons[1].getText() == "O" &&
            playButtons[4].getText() == "O" &&
            playButtons[7].getText() == "O") {
                oWins(1, 4, 7);
            }

        if (playButtons[2].getText() == "O" &&
            playButtons[5].getText() == "O" &&
            playButtons[8].getText() == "O") {
                oWins(2, 5, 8);
            }

        if (playButtons[0].getText() == "O" &&
            playButtons[3].getText() == "O" &&
            playButtons[6].getText() == "O") {
                oWins(0, 3, 6);
            }

        if (playButtons[0].getText() == "O" &&
            playButtons[4].getText() == "O" &&
            playButtons[8].getText() == "O") {
                oWins(0, 4, 8);
            }
            
        if (playButtons[2].getText() == "O" &&
            playButtons[4].getText() == "O" &&
            playButtons[6].getText() == "O") {
                oWins(2, 4, 6);
            }
            
        boolean isDraw = true;
        for (int i = 0; i < 9; i++) {
            if (playButtons[i].getText().isEmpty()) {
                isDraw = false;
                break;
            }
        }

        if (isDraw && gameRunning) {
            draw();
        }
    }

    public void xWins(int a, int b, int c) {

        gameRunning = false;
        playButtons[a].setBackground(winner);
        playButtons[b].setBackground(winner);
        playButtons[c].setBackground(winner);

        for (int i = 0; i < 9; i++) {

            playButtons[i].setEnabled(false);
        }

        titleLabel.setText("X Wins!");
        restartButton.setVisible(true);
    }

    public void oWins(int a, int b, int c) {

        gameRunning = false;
        playButtons[a].setBackground(winner);
        playButtons[b].setBackground(winner);
        playButtons[c].setBackground(winner);

        for (int i = 0; i < 9; i++) {

            playButtons[i].setEnabled(false);
        }

        titleLabel.setText("O Wins!");
        restartButton.setVisible(true);
    }

    public void draw() {

        for (int i = 0; i < 9; i++) {

            playButtons[i].setEnabled(false);
        }

        titleLabel.setText("Draw!");
        restartButton.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == playButtons[i]) {
                if (xTurn) {
                    if (playButtons[i].getText() == "") {
                        playButtons[i].setForeground(playerX);
                        playButtons[i].setText("X");
                        xTurn = false;
                        titleLabel.setText("O Turn");
                        checkWinner();
                    }
                }
                else {
                    if (playButtons[i].getText() == "") {
                        playButtons[i].setForeground(playerO);
                        playButtons[i].setText("O");
                        xTurn = true;
                        titleLabel.setText("X Turn");
                        checkWinner();
                    }
                }
            }
        }

        if (e.getSource() == restartButton) {
            
            newTurn();

            for (int i = 0; i < 9; i++) {

                playButtons[i].setEnabled(true);
                playButtons[i].setBackground(buttonColor);
                playButtons[i].setText("");
            }
            restartButton.setVisible(false);
        }
    }
}