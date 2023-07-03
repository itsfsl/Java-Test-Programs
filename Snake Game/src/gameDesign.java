import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class gameDesign extends JPanel implements ActionListener{

    public static final int SCREEN_WIDTH = 1300;
    public static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int DELAY = 100;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / (UNIT_SIZE * UNIT_SIZE);

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    boolean gameRunning = false;
    boolean gamePaused = false;
    static boolean gridIsOn = false;

    final Color gameBackground = Color.decode("#303030");
    final Color appleColor = Color.decode("#eb1018");
    final Color snakeHeadColor = Color.decode("#6feb10");
    final Color snakeBodyColor = Color.decode("#459409");
    final Color gameOverColor = Color.decode("#ff1717");
    final Color scoreColor = Color.decode("#ebda44");

    final Font gameOverFont = new Font("Times New Roman", Font.BOLD, 150);
    final Font gameOverScoreFont = new Font("Times New Roman", Font.BOLD, 85);
    final Font scoreFont = new Font("Times New Roman", Font.BOLD, 45);

    int appleX;
    int appleY;

    int score = 0;

    int snakeBodyParts = 1;

    char direction = 'R';

    Random random;
    Timer timer;

    static final File bgmAudio = new File("src/audio/bgm.wav");
    static final File popAudio = new File("src/audio/pop.wav");

    static final AudioInputStream bgmStream;

    static {
        try {
            bgmStream = AudioSystem.getAudioInputStream(bgmAudio);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static final Clip clipBGM;

    static {
        try {
            clipBGM = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    static final AudioInputStream popStream;

    static {
        try {
            popStream = AudioSystem.getAudioInputStream(popAudio);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    static final Clip clipPop;

    static {
        try {
            clipPop = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    gameDesign() throws IOException, LineUnavailableException {

        clipBGM.open(bgmStream);
        clipPop.open(popStream);

        random = new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        this.setBackground(gameBackground);

        startGame();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        if(gameRunning) {

            //GRID FOR REFERENCE
            if(gridIsOn) {

                for (int i = 0; i < SCREEN_WIDTH/UNIT_SIZE; i++) {

                    g.setColor(Color.BLACK);
                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                }
            }
            //DRAW APPLES
            if (score >= 30) {

                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            else {

                g.setColor(appleColor);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
            }
            //DRAW SNAKE
            for (int i = 0; i < snakeBodyParts; i++) {

                if (i == 0) {

                    g.setColor(snakeHeadColor);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {

                    if ( score >= 31) {

                        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                    else {

                        g.setColor(snakeBodyColor);
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
            g.setFont(scoreFont);
            g.setColor(scoreColor);
            FontMetrics metrics = getFontMetrics(scoreFont);
            g.drawString("Score: " + score, (SCREEN_WIDTH - metrics.stringWidth("Score: " + score)) / 2, 80);
        }
        else {
            gameOver(g);
        }
    }

    public void startGame() {

        timer = new Timer(DELAY, this);
        timer.start();
        clipBGM.setMicrosecondPosition(0);
        clipBGM.loop(500);
        clipBGM.start();
        gameRunning = true;
        gamePaused = false;
        newApple();
    }

    public void newApple() {

        appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
    }

    public void checkAppleEaten() {

        if (x[0] == appleX && y[0] == appleY) {

            clipPop.start();
            clipPop.setMicrosecondPosition(0);
            score++;
            snakeBodyParts++;
            newApple();
        }
    }

    public void moveSnake() {

        for (int i = snakeBodyParts; i > 0; i--) {

            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {

            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
        }
    }

    public void checkSnakeCollision() {

        for (int i = snakeBodyParts; i > 0; i--) {

            if (x[0] == x[i] && y[0] == y[i]) {

                gameRunning = false;
                break;
            }
        }

        if (x[0] < 0 || y[0] < 0 || x[0] == SCREEN_WIDTH || y[0] == SCREEN_HEIGHT) {

            gameRunning = false;
        }
        
        if (!gameRunning) {

            timer.stop();
        }
    }

    public void gameOver(Graphics g) {

        g.setFont(gameOverFont);
        g.setColor(gameOverColor);
        FontMetrics metrics = getFontMetrics(gameOverFont);
        g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        metrics = getFontMetrics(gameOverScoreFont);
        g.setFont(gameOverScoreFont);
        g.drawString("Score: " + score, (SCREEN_WIDTH - metrics.stringWidth("Score: " + score)) / 2, 200);
        g.setFont(scoreFont);
        g.setColor(scoreColor);
        metrics = getFontMetrics(scoreFont);
        g.drawString("Press space to restart the game", (SCREEN_WIDTH - metrics.stringWidth("Press space to restart the game")) / 2, 500);
        clipBGM.stop();
        clipPop.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (gameRunning) {

            moveSnake();
            checkAppleEaten();
            checkSnakeCollision();
        }
        repaint();
    }

    public class myKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {

            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {

                if (direction != 'L') {

                    direction = 'R';
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {

                if (direction != 'R') {

                    direction = 'L';
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_UP) {

                if (direction != 'D') {

                    direction = 'U';
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_DOWN) {

                if (direction != 'U') {

                    direction = 'D';
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_SPACE) {

                if (!gameRunning) {

                    score = 0;
                    snakeBodyParts = 1;
                    direction = 'R';
                    gameRunning = true;
                    x[0] = 0;
                    y[0] = 0;
                    startGame();
                }

                else if (!gamePaused) {

                    timer.stop();
                    gamePaused = true;
                }

                else {

                    timer.start();
                    gamePaused = false;
                }
            }

            /* if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

                if (!gameRunning) {

                    System.exit(0);
                }
            } */
        }
    }
}