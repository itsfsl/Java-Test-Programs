import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle{

    Random random;
    int xVelocity;
    int yVelocity;
    int initialSpeed = 3;

    Color ballColor = Color.decode("#ffffff");

    Ball(int x, int y, int xSize, int ySize) {

        super(x, y, xSize, ySize);
        random = new Random();
        int randomXDirection = random.nextInt(2);

        if (randomXDirection == 0) {
            randomXDirection--;
        }
        setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(2);

        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(randomYDirection * initialSpeed);
    }

    public void setXDirection(int randomXDirection) {

        xVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {

        yVelocity = randomYDirection;
    }

    public void move() {

        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {

        g.setColor(ballColor);
        g.fillOval(x, y, width, height);
    }
}