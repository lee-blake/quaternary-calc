package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcGUITest {

    public CalcGUITest()
    {
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
        JButton flipButton = new JButton("base");
        JButton backspaceButton = new JButton("back");
        JButton clearButton = new JButton("clear");

        //initialize button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JPanel row1 = new JPanel(new GridLayout(1,2));
        JPanel leftPanelrow1 = new JPanel(new GridLayout(1,2));
        JPanel rightPanelrow1 = new JPanel(new GridLayout(1,1));
        leftPanelrow1.add(flipButton);
        leftPanelrow1.add(clearButton);
        rightPanelrow1.add(backspaceButton);
        row1.add(leftPanelrow1);
        row1.add(rightPanelrow1);

        JPanel row2 = new JPanel(new GridLayout(1, 4));
        row2.add(zeroButton);
        row2.add(oneButton);
        row2.add(twoButton);
        row2.add(threeButton);

        JPanel row3 = new JPanel(new GridLayout(1, 4));
        row3.add(addButton);
        row3.add(subButton);
        row3.add(mulButton);
        row3.add(divButton);

        JPanel row4 = new JPanel(new GridLayout(1,2));
        JPanel leftPanelrow4 = new JPanel(new GridLayout(1,2));
        JPanel rightPanelrow4 = new JPanel(new GridLayout(1,1));
        leftPanelrow4.add(sqButton);
        leftPanelrow4.add(sqrtButton);
        rightPanelrow4.add(enterButton);
        row4.add(leftPanelrow4);
        row4.add(rightPanelrow4);

        buttonPanel.add(row1);
        buttonPanel.add(row2);
        buttonPanel.add(row3);
        buttonPanel.add(row4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textArea1, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalcGUITest::new);
    }
}