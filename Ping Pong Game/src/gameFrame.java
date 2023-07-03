import javax.swing.*;
import java.awt.*;

public class gameFrame extends JFrame {

    Color backgroundColor = Color.decode("#260c0c");

    gameFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pingy-Pongy");
        this.setBackground(backgroundColor);
        this.setResizable(false);
        this.add(new gamePanel());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}