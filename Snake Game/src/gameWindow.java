import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class gameWindow extends JFrame{

    final ImageIcon gameLogo = new ImageIcon("src/imgs/gameLogo.png");
    gameWindow() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        
        this.add(new gameDesign());
        this.setTitle("Snake Game by ITSFSL");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(gameLogo.getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {

                gameDesign.bgmStream.close();
                gameDesign.clipBGM.close();
                gameDesign.popStream.close();
                gameDesign.clipPop.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }));
    }
}