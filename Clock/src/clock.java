package clock;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class clock extends JFrame{
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JPanel panel;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String currentTime;
    String currentDay;
    String currentDate;

    clock()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Clock by FSL");
        this.setSize(300, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBounds(0, 0, 300, 200);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.green);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 40));
        dayLabel.setForeground(Color.white);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 40));
        dateLabel.setForeground(Color.white);

        panel.add(timeLabel);
        panel.add(dayLabel);
        panel.add(dateLabel);
        this.add(panel);
        this.setVisible(true);

        setTime();
    }

    public void setTime()
    {
        while(true)
        {
            currentTime = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(currentTime);

            currentDay = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(currentDay);

            currentDate = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(currentDate);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
