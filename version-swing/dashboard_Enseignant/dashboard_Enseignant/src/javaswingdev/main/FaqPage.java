package javaswingdev.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FaqPage extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextArea question1, question2, question3, answer1, answer2, answer3;
    private JButton showAnswer1, showAnswer2, showAnswer3;

    public FaqPage() {
        super("FAQ Page");

        // create the panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // create the questions and answers
        question1 = new JTextArea("What is ENSAKH?");
        answer1 = new JTextArea("Java is a high-level programming language developed by Sun Microsystems.");

        question2 = new JTextArea("What is Swing?");
        answer2 = new JTextArea("Swing is a set of GUI components for Java.");

        question3 = new JTextArea("How do I create a JFrame?");
        answer3 = new JTextArea("To create a JFrame, you need to create a new instance of the JFrame class and add components to it.");

        // create the show answer buttons
        showAnswer1 = new JButton("Show Answer");
        showAnswer1.addActionListener(this);
        showAnswer2 = new JButton("Show Answer");
        showAnswer2.addActionListener(this);
        showAnswer3 = new JButton("Show Answer");
        showAnswer3.addActionListener(this);

        // add the components to the panel
        panel.add(question1);
        panel.add(showAnswer1);
        panel.add(answer1);
        answer1.setVisible(false);

        panel.add(question2);
        panel.add(showAnswer2);
        panel.add(answer2);
        answer2.setVisible(false);

        panel.add(question3);
        panel.add(showAnswer3);
        panel.add(answer3);
        answer3.setVisible(false);

        // add the panel to the frame
        add(panel);

        // set the frame properties
        setSize(862	, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showAnswer1) {
            answer1.setVisible(!answer1.isVisible());
        } else if (e.getSource() == showAnswer2) {
            answer2.setVisible(!answer2.isVisible());
        } else if (e.getSource() == showAnswer3) {
            answer3.setVisible(!answer3.isVisible());
        }
    }

    public static void main(String[] args) {
        new FaqPage();
    }
}
