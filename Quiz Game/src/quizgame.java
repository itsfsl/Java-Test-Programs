package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;

public class quizgame implements ActionListener{
    
    Font fontTNR = new Font("Times New Roman", Font.BOLD, 40);
    Font fontQuestions = new Font("Times New Roman", Font.BOLD, 30);
    Font fontButtons = new Font("Times New Roman", Font.BOLD, 20);
    Font fontOptions = new Font("Times New Roman", Font.BOLD, 25);
    Font fontResult = new Font("Times New Roman", Font.BOLD, 50);

    JFrame gameFrame = new JFrame("Quiz Game by ITSFSL");
    JTextField mainHeading = new JTextField();
    JTextArea questionsHeading = new JTextArea();
    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");
    JButton buttonC = new JButton("C");
    JButton buttonD = new JButton("D");
    JLabel optionA = new JLabel();
    JLabel optionB = new JLabel();
    JLabel optionC = new JLabel();
    JLabel optionD = new JLabel();
    JLabel displayScore = new JLabel();
    JLabel displayPercentage = new JLabel();
    JTextField secondsLeft = new JTextField();

    int seconds = 10;
    int index = 0;
    int score = 0;

    String[] quizQuestions =    {
                                    "Which company created Java?",
                                    "Which year was Java created?",
                                    "What was Java originally called?",
                                    "Who is credited with creating Java?"
                                };

    String[][] quizOptions = 	{
                                    {"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
                                    {"1989","1996","1972","1492"},
                                    {"Apple","Latte","Oak","Koffing"},
                                    {"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
                                };

    char[] quizAnswers = 		{
                                    'A',
                                    'B',
                                    'C',
                                    'C'
                                };

    int totalQuestion = quizQuestions.length;

    Timer remainingSeconds = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            seconds --;
            secondsLeft.setText(String.valueOf(seconds));

            if (seconds <= 0) {

                displayAnswers();
            }
            else if (seconds <= 3){

                secondsLeft.setBackground(Color.RED);
                secondsLeft.setForeground(Color.WHITE);
            }
        }
    });

    quizgame() {

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(null);
        gameFrame.setSize(500, 500);
        gameFrame.setResizable(false);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.getContentPane().setBackground(Color.decode("#1c1c1c"));

        mainHeading.setBounds(0, 0, 500, 60);
        mainHeading.setBackground(Color.decode("#8f0159"));
        mainHeading.setForeground(Color.WHITE);
        mainHeading.setFocusable(false);
        mainHeading.setFont(fontTNR);
        mainHeading.setHorizontalAlignment(JTextField.CENTER);
        mainHeading.setEditable(false);

        questionsHeading.setBounds(0, 60, 500, 60);
        questionsHeading.setBackground(Color.decode("#a02ded"));
        questionsHeading.setForeground(Color.WHITE);
        questionsHeading.setFocusable(false);
        questionsHeading.setFont(fontQuestions);
        questionsHeading.setEditable(false);
        questionsHeading.setLineWrap(true);
        questionsHeading.setWrapStyleWord(true);

        buttonA.setBounds(20, 140, 60, 60);
        buttonA.setFocusable(false);
        buttonA.setFont(fontButtons);
        buttonA.setBackground(Color.decode("#e8e8e8"));
        buttonA.addActionListener(this);

        optionA.setBounds(100, 140, 400, 60);
        optionA.setFont(fontOptions);
        optionA.setForeground(Color.decode("#f2f2f2"));

        buttonB.setBounds(20, 220, 60, 60);
        buttonB.setFocusable(false);
        buttonB.setFont(fontButtons);
        buttonB.setBackground(Color.decode("#e8e8e8"));
        buttonB.addActionListener(this);

        optionB.setBounds(100, 220, 400, 60);
        optionB.setFont(fontOptions);
        optionB.setForeground(Color.decode("#f2f2f2"));

        buttonC.setBounds(20, 300, 60, 60);
        buttonC.setFocusable(false);
        buttonC.setFont(fontButtons);
        buttonC.setBackground(Color.decode("#e8e8e8"));
        buttonC.addActionListener(this);

        optionC.setBounds(100, 300, 400, 60);
        optionC.setFont(fontOptions);
        optionC.setForeground(Color.decode("#f2f2f2"));

        buttonD.setBounds(20, 380, 60, 60);
        buttonD.setFocusable(false);
        buttonD.setFont(fontButtons);
        buttonD.setBackground(Color.decode("#e8e8e8"));
        buttonD.addActionListener(this);

        optionD.setBounds(100, 380, 400, 60);
        optionD.setFont(fontOptions);
        optionD.setForeground(Color.decode("#f2f2f2"));

        displayScore.setBounds(50, 150, 400, 60);
        displayScore.setFont(fontResult);
        displayScore.setForeground(Color.WHITE);
        displayScore.setVisible(false);

        displayPercentage.setBounds(50, 200, 400, 60);
        displayPercentage.setFont(fontResult);
        displayPercentage.setForeground(Color.WHITE);
        displayPercentage.setVisible(false);

        secondsLeft.setBounds(400, 390, 50, 50);
        secondsLeft.setText(String.valueOf(seconds));
        secondsLeft.setFocusable(false);
        secondsLeft.setFont(new Font("Times New Roman", Font.BOLD, 40));
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);

        gameFrame.add(mainHeading);
        gameFrame.add(questionsHeading);
        gameFrame.add(buttonA);
        gameFrame.add(optionA);
        gameFrame.add(buttonB);
        gameFrame.add(optionB);
        gameFrame.add(buttonC);
        gameFrame.add(optionC);
        gameFrame.add(buttonD);
        gameFrame.add(optionD);
        gameFrame.add(secondsLeft);
        gameFrame.add(displayScore);
        gameFrame.add(displayPercentage);
        gameFrame.setVisible(true);

        displayQuestions();
    }

    public void displayQuestions() {

        if (index >= totalQuestion) {
            result();
        }
        else {
            mainHeading.setText("Question #" + (index + 1));
            questionsHeading.setText(quizQuestions[index]);
            optionA.setText(quizOptions[index][0]);
            optionB.setText(quizOptions[index][1]);
            optionC.setText(quizOptions[index][2]);
            optionD.setText(quizOptions[index][3]);
            remainingSeconds.start();
        }
    }

    public void displayAnswers() {

        remainingSeconds.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(quizAnswers[index] != 'A') {
            optionA.setForeground(Color.RED);
        }

        if(quizAnswers[index] != 'B') {
            optionB.setForeground(Color.RED);
        }

        if(quizAnswers[index] != 'C') {
            optionC.setForeground(Color.RED);
        }

        if(quizAnswers[index] != 'D') {
            optionD.setForeground(Color.RED);
        }

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                seconds = 10;
                secondsLeft.setText(String.valueOf(seconds));
                secondsLeft.setBackground(Color.WHITE);
                secondsLeft.setForeground(Color.BLACK);

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                optionA.setForeground(Color.decode("#f2f2f2"));
                optionB.setForeground(Color.decode("#f2f2f2"));
                optionC.setForeground(Color.decode("#f2f2f2"));
                optionD.setForeground(Color.decode("#f2f2f2"));

                index++;
                displayQuestions();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void result() {

        mainHeading.setText("Result");

        questionsHeading.setVisible(false);

        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        optionA.setVisible(false);
        optionB.setVisible(false);
        optionC.setVisible(false);
        optionD.setVisible(false);

        secondsLeft.setVisible(false);

        displayScore.setText("Score: " + String.valueOf(score) + "/" + String.valueOf(totalQuestion));
        displayScore.setVisible(true);

        displayPercentage.setText("Percentage: " + (int)((score/(double)totalQuestion) * 100) + "%");
        displayPercentage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonA) {
            if (quizAnswers[index] == 'A') {

                score++;
                optionA.setForeground(Color.GREEN);
            }
        }

        if (e.getSource() == buttonB) {
            if (quizAnswers[index] == 'B') {

                score++;
                optionB.setForeground(Color.GREEN);
            }
        }

        if (e.getSource() == buttonC) {
            if (quizAnswers[index] == 'C') {

                score++;
                optionC.setForeground(Color.GREEN);
            }
        }

        if (e.getSource() == buttonD) {
            if (quizAnswers[index] == 'D') {

                score++;
                optionD.setForeground(Color.GREEN);
            }
        }

        displayAnswers();
    }
}
