import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class firstWindow extends JFrame implements ActionListener {
 
    JLabel gameTitle;
    JButton playButton;
    JButton exitButton;

    JCheckBox gridCheckBox;
    
    final Color playButtonColor = Color.decode("#6feb10");
    final Color exitButtonColor = Color.decode("#eb1018");

    final Font buttonFont = new Font("Times New Roman", Font.BOLD, 35);
    //Font titleFont = new Font("src\\fonts\\Gerald.otf", Font.PLAIN, 150);
    final Font customFont;

    {
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\fonts\\Gerald.otf"));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    final Font newTitleFont = customFont.deriveFont(Font.PLAIN, 150);

    final ImageIcon gameLogo = new ImageIcon("src/imgs/gameLogo.png");

    firstWindow() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(gameDesign.SCREEN_WIDTH, gameDesign.SCREEN_HEIGHT);
        this.getContentPane().setBackground(Color.decode("#303030"));
        this.setTitle("Snake Game by ITSFSL");
        this.setIconImage(gameLogo.getImage());
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        gameTitle = new JLabel("Snakesss");
        gameTitle.setFont(newTitleFont);
        gameTitle.setForeground(Color.WHITE);
        gameTitle.setBounds(80, 150, 1200, 200);

        playButton = new JButton("Play");
        playButton.setBounds(550, 500, 200, 50);
        playButton.setFocusable(false);
        playButton.setBackground(playButtonColor);
        playButton.setFont(buttonFont);
        playButton.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.setBounds(550, 600, 200, 50);
        exitButton.setFocusable(false);
        exitButton.setBackground(exitButtonColor);
        exitButton.setForeground(Color.decode("#ffffff"));
        exitButton.setFont(buttonFont);
        exitButton.addActionListener(this);

        gridCheckBox = new JCheckBox("Enable Grid");
        gridCheckBox.setBounds(900, 500, 100, 20);
        gridCheckBox.setOpaque(false);
        gridCheckBox.setFocusable(false);
        gridCheckBox.setForeground(Color.WHITE);
        gridCheckBox.addActionListener(this);

        this.add(gameTitle);
        this.add(playButton);
        this.add(exitButton);
        this.add(gridCheckBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playButton) {

            this.dispose();
            try {
                new gameWindow();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == exitButton) {

            this.dispose();
        }

        if (e.getSource() == gridCheckBox) {

            gameDesign.gridIsOn = true;
        }
    }
}