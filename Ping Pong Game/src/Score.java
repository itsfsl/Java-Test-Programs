import java.awt.*;

public class Score extends Rectangle{

    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    int p1;
    int p2;

    Color scoreColor = Color.decode("#422c2c");
    Color borderColor = Color.decode("#120404");

    Score(int SCREEN_WIDTH, int SCREEN_HEIGHT) {

        Score.SCREEN_WIDTH = SCREEN_WIDTH;
        Score.SCREEN_HEIGHT = SCREEN_HEIGHT;
    }

    public void draw(Graphics g) {
        // border fill
        g.setColor(borderColor);
        g.fillRect(0, 0, SCREEN_WIDTH, 20);
        g.fillRect(0, 0, 20, SCREEN_HEIGHT);
        g.fillRect(SCREEN_WIDTH - 20, 0, 20, SCREEN_HEIGHT);
        g.fillRect(0, SCREEN_HEIGHT - 20, SCREEN_WIDTH, 20);
        // score text
        g.setColor(scoreColor);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 400));
        g.drawLine(SCREEN_WIDTH / 2, 0, SCREEN_WIDTH / 2, SCREEN_HEIGHT);
        g.drawString(String.valueOf(p1/10) + String.valueOf(p1%10), 60, 400);
        g.drawString(String.valueOf(p2/10) + String.valueOf(p2%10), 540, 400);
    }
}