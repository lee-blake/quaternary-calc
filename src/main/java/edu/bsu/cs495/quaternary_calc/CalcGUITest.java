package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;

public class CalcGUITest {
    private JTextArea textArea1;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton additionButton;
    private JButton subtractionButton;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton squarerootButton;
    private JButton squareButton;
    private JButton enterButton;
    private double operand1;
    private double operand2;
    private String operator;

    public CalcGUITest(){

        //initializing window and buttons
        JFrame frame = new JFrame("Quaternary Calculator");
        TextArea textArea1 = new TextArea();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textArea1, BorderLayout.NORTH);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}