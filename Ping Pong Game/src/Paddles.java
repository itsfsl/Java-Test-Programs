import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddles extends Rectangle {

    int id;
    int yVelocity = 0;
    int paddleSpeed = 20;

    Color p1Color = Color.decode("#389c17");
    Color p2Color = Color.decode("#7732a8");

    Paddles(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {

        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {

        switch (id) {

            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {

                    setYDirection(-paddleSpeed);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {

                    setYDirection(paddleSpeed);
                    move();
                }
                break;

            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    setYDirection(-paddleSpeed);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    setYDirection(paddleSpeed);
                    move();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

        switch (id) {

            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {

                    setYDirection(0);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_S) {

                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    setYDirection(0);
                    move();
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    setYDirection(0);
                    move();
                }
                break;
        }
    }

    public void setYDirection(int yDirection) {

        yVelocity = yDirection;
    }

    public void move() {

        y += yVelocity;
    }

    public void draw(Graphics g) {

        if (id == 1) {

            g.setColor(p1Color);
        }
        else {
            g.setColor(p2Color);
        }

        g.fillRect(x, y, width, height);
    }
}