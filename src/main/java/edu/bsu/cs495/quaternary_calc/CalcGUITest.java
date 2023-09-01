package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcGUITest {
    private double operand1;
    private double operand2;
    private String operator;

    public CalcGUITest(){

        //initializing window and buttons
        JFrame frame = new JFrame("Quaternary Calculator");
        TextArea textArea1 = new TextArea();

        //initialize number buttons
        JButton zeroButton = new JButton("0");
        JButton oneButton = new JButton("1");
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");

        //initialize operator buttons
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton sqButton = new JButton("sq");
        JButton sqrtButton = new JButton("sqrt");
        JButton enterButton = new JButton("enter");


        //initialize button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3));

        //add buttons to panel
        buttonPanel.add(zeroButton);
        buttonPanel.add(oneButton);
        buttonPanel.add(twoButton);
        buttonPanel.add(threeButton);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(sqButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(enterButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textArea1, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);

    }
    
}