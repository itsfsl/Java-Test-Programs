package Encryptinator;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import javax.swing.*;

import filechooser.myframe;

public class brains {
    
    //private Scanner scan;
    private char character;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char[] letters;
    //private char[] oldKey;

    JFrame myFrame;

    JButton newButton;
    JButton setButton;
    JButton encryptButton;
    JButton decryptButton;
    JButton quitButton;

    JPanel mainPanel;

    JLabel logoLabel;

    JTextField presentKey;
    JTextField inMessage;
    JTextField outMessage;

    ImageIcon mainLogo = new ImageIcon("C:\\Users\\direc\\Desktop\\C Files\\Java\\Encryptinator\\images\\key.png");

    brains()
    {

        //scan = new Scanner(System.in);
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        
        //System.out.println("---Welcome to the Encryptinator---");

        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i = 32; i < 127; i++)
        {
            list.add(Character.valueOf(character));
            character++;
        }
        
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
    
        /* while (true)
        {
            System.out.println("--------------------------------------------------");
            System.out.println("(N)ew Key, (G)et Key, (S)et Key, (E)ncrypt, (D)ecrypt, (Q)uit");
            System.out.println("--------------------------------------------------");
            System.out.print("Enter your choice: ");
            char response = Character.toUpperCase(scan.nextLine().charAt(0));

            switch (response)
            {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'S':
                    setKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Please enter a valid input!");
                    break;
            }
        } */

        myFrame = new JFrame("Encryptinator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);
        myFrame.setSize(400, 600);
        myFrame.setResizable(false);
        myFrame.setIconImage(mainLogo.getImage());
        myFrame.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setSize(new Dimension(400, 600));
        mainPanel.setBackground(Color.black);
        mainPanel.setLayout(null);

        logoLabel = new JLabel(mainLogo);
        logoLabel.setBounds(100, 150, 200, 200);

        newButton = new JButton("New Key");
        newButton.addActionListener(e -> newKey());
        newButton.setBounds(40, 120, 100, 40);
        newButton.setFocusable(false);
        newButton.setBackground(Color.decode("#ffa000"));
        
        setButton = new JButton("Set Key");
        setButton.addActionListener(e -> setKey());
        setButton.setBounds(240, 120, 100, 40);
        setButton.setFocusable(false);

        encryptButton = new JButton("Encrypt Message");
        encryptButton.addActionListener(e -> encrypt());
        encryptButton.setBounds(40, 380, 150, 40);
        encryptButton.setFocusable(false);

        decryptButton = new JButton("Decrypt Message");
        decryptButton.addActionListener(e -> decrypt());
        decryptButton.setBounds(40, 250, 150, 40);
        decryptButton.setFocusable(false);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> quit());
        quitButton.setBounds(120, 470, 150, 40);
        quitButton.setFocusable(false);

        presentKey = new JTextField();
        //presentKey.setPreferredSize(new Dimension(300, 50));
        presentKey.setForeground(Color.white);
        presentKey.setBackground(Color.black);
        presentKey.setCaretColor(Color.white);
        presentKey.setText(shuffledList.toString());
        presentKey.setEditable(false);
        presentKey.setCaretPosition(0);
        presentKey.setBounds(40, 50, 300, 50);

        inMessage = new JTextField();
        inMessage.setPreferredSize(new Dimension(300, 50));
        inMessage.setForeground(Color.white);
        inMessage.setBackground(Color.black);
        inMessage.setCaretColor(Color.white);
        inMessage.setText("Write your encrypted text here");
        inMessage.setBounds(40, 180, 300, 50);

        outMessage = new JTextField();
        outMessage.setPreferredSize(new Dimension(300, 50));
        outMessage.setForeground(Color.white);
        outMessage.setBackground(Color.black);
        outMessage.setCaretColor(Color.white);
        outMessage.setText("Write your decrypted text here");
        outMessage.setBounds(40, 310, 300, 50);

        myFrame.add(mainPanel);
        
        mainPanel.add(presentKey);
        mainPanel.add(newButton);
        mainPanel.add(setButton);
        mainPanel.add(inMessage);
        mainPanel.add(decryptButton);
        mainPanel.add(outMessage);
        mainPanel.add(encryptButton);
        mainPanel.add(quitButton);
        mainPanel.add(logoLabel);

        myFrame.setVisible(true);
    }

    private void newKey(){

        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i = 32; i < 127; i++)
        {
            list.add(Character.valueOf(character));
            character++;
        }
        
        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        
        //System.out.println("A new key has been generated!");
        presentKey.setText(shuffledList.toString());
        presentKey.setCaretPosition(0);
    }

    /* private void getKey(){

        System.out.println("Here's your current key:");

        for (char key : list)
        {
            System.out.print(key);
        }

        System.out.println();

        for (char key : shuffledList)
        {
            System.out.print(key);
        }

        System.out.println();
    } */

    private void setKey(){

        /* System.out.println("Enter your key: "); */
        String keyInput = JOptionPane.showInputDialog(myFrame, "Set your desired key", "Set Key", JOptionPane.INFORMATION_MESSAGE);

        //oldKey = key.toCharArray();

        if (keyInput != null)
        {
            char[] key = keyInput.toCharArray();

            shuffledList.clear();

            /* for (int i = 0; i < 1; i++)
            {
                for (int j = 1; j < key.length; j++)
                {
                    shuffledList.add(key[j]);
                    j+=2;
                }
            } */

            for (int i = 1; i < key.length; i++)
            {
                shuffledList.add(key[i]);
                i+=2;
            }

            presentKey.setText(shuffledList.toString());
            presentKey.setCaretPosition(0);

            //System.out.println("Your key has been set successfully!");
        }
        else
        {
            //
        }
    }

    private void encrypt(){

        letters = outMessage.getText().toCharArray();

        //System.out.print("Enter your message: ");
        //String message = scan.nextLine();

        //letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (letters[i] == list.get(j))
                {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        inMessage.setText(new String(letters));

        /* System.out.print("Here's your encrypted message: ");

        for (char em : letters)
        {
            System.out.print(em);
        }

        System.out.println(); */
    }

    private void decrypt(){

        letters = inMessage.getText().toCharArray();

        /* System.out.print("Enter your encrypted message: ");
        String message = scan.nextLine();

        letters = message.toCharArray(); */

        for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < shuffledList.size(); j++)
            {
                if (letters[i] == shuffledList.get(j))
                {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        outMessage.setText(new String(letters));

        /* System.out.print("Here's your decrypted message: ");

        for (char em : letters)
        {
            System.out.print(em);
        }
        System.out.println(); */
    }

    private void quit(){

        System.out.println("Thanks for using the program :)");
        System.exit(0);
    }
}
