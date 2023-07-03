import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stopWatch implements ActionListener{
    
    JFrame myFrame = new JFrame("Gajab Smartwatch");
    JLabel timeLabel = new JLabel();
    int timeElapsed = 0;
    int seconds, minutes, hours = 0;
    int milliseconds;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    boolean watchRunning = false;

    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                timeElapsed+= 1000;
                hours = timeElapsed / (60 * 60 * 1000);
                minutes = (timeElapsed / (60 * 1000)) % 60;
                seconds = (timeElapsed / 1000) % 60;
                seconds_string = String.format("%02d", seconds);
                minutes_string = String.format("%02d", minutes);
                hours_string = String.format("%02d", hours);
                timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            }
    });

    stopWatch()
    {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setSize(400, 400);
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);

        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 45));
        timeLabel.setBounds(90, 100, 200, 100);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.decode("#212121"));
        timeLabel.setForeground(Color.white);

        startButton.setBounds(90, 200, 100, 50);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        startButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        startButton.setBackground(Color.decode("#35bf0f"));
        startButton.setForeground(Color.BLACK);

        resetButton.setBounds(190, 200, 100, 50);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        resetButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        resetButton.setBackground(Color.decode("#0f68db"));
        resetButton.setForeground(Color.BLACK);

        myFrame.add(timeLabel);
        myFrame.add(startButton);
        myFrame.add(resetButton);
        myFrame.setVisible(true);
    }

    void start()
    {
        timer.start();
    }

    void stop()
    {
        timer.stop();
    }

    void reset()
    {
        timer.stop();
        watchRunning = false;
        timeElapsed = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        startButton.setText("Start");
        startButton.setBackground(Color.decode("#35bf0f"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == startButton)
        {
            if(!watchRunning)
            {
                watchRunning = true;
                startButton.setText("Stop");
                startButton.setBackground(Color.decode("#ba2613"));
                start();
            }
            else
            {
                watchRunning = false;
                startButton.setText("Start");
                startButton.setBackground(Color.decode("#35bf0f"));
                stop();
            }
        }

        if(e.getSource() == resetButton)
        {
            reset();
        }
    }
}