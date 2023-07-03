import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class gamePanel extends JPanel implements Runnable{

    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = (int)(SCREEN_WIDTH * (5.0/9.0));
    static final Dimension SCREEN_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    static final int BALL_SIZE = 20;
    static final int PADDLE_WIDTH = 20;
    static final int PADDLE_HEIGHT = 120;
    Thread thread;
    Random random;
    Image image;
    Graphics graphics;
    Paddles paddle1;
    Paddles paddle2;
    Ball ball;
    Score score;
    boolean gameRunning;

    gamePanel() {

        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
        this.addKeyListener(new AL());

        newGame();
        score = new Score(SCREEN_WIDTH, SCREEN_HEIGHT);
        paddle1 = new Paddles(0, (SCREEN_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        paddle2 = new Paddles(SCREEN_WIDTH - PADDLE_WIDTH, (SCREEN_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);

        thread = new Thread(this);
        thread.start();
    }

    public void newGame() {

        random = new Random();
        gameRunning = true;
        //paddle1 = new Paddles(0, (SCREEN_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
        //paddle2 = new Paddles(SCREEN_WIDTH - PADDLE_WIDTH, (SCREEN_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
        ball = new Ball((SCREEN_WIDTH/2) - (BALL_SIZE/2), random.nextInt(SCREEN_HEIGHT - BALL_SIZE), BALL_SIZE, BALL_SIZE);
    }

    public void paint(Graphics g) {

        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {

        score.draw(g);
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {

        if (gameRunning) {

            paddle1.move();
            paddle2.move();
            ball.move();
        }
    }

    public void checkCollision() {
        //check paddles colliding with frame
        if (paddle1.y <= 20) {

            paddle1.y = 20;
        }

        if (paddle1.y >= (SCREEN_HEIGHT - PADDLE_HEIGHT) - 20) {

            paddle1.y = (SCREEN_HEIGHT - PADDLE_HEIGHT)  - 20;
        }

        if (paddle2.y <= 20) {

            paddle2.y = 20;
        }

        if (paddle2.y >= (SCREEN_HEIGHT - PADDLE_HEIGHT) - 20) {

            paddle2.y = (SCREEN_HEIGHT - PADDLE_HEIGHT) - 20;
        }
        // check ball collision with top & down frame
        if (ball.y <= 20) {

            ball.setYDirection(-ball.yVelocity);
        }

        if (ball.y >= (SCREEN_HEIGHT - BALL_SIZE)  - 20) {

            ball.setYDirection(-ball.yVelocity);
        }
        //check ball collision with paddles
        if (ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0) {
                ball.yVelocity++;
            }
            else {
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if (ball.yVelocity > 0) {
                ball.yVelocity++;
            }
            else {
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        if (ball.x >= SCREEN_WIDTH - BALL_SIZE) {
            score.p1++;
            newGame();
            System.out.println("PLAYER 1 SCORE: " + score.p1);
        }

        if (ball.x <= 0) {
            score.p2++;
            newGame();
            System.out.println("PLAYER 2 SCORE: " + score.p2);
        }
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {

                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            if (gameRunning) {

                paddle1.keyPressed(e);
                paddle2.keyPressed(e);
            }

            if(e.getKeyCode() == KeyEvent.VK_SPACE) {

                if(gameRunning) {

                    gameRunning = false;
                }
                else {

                    gameRunning = true;
                }
            }
        }

        public void keyReleased(KeyEvent e) {

            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}