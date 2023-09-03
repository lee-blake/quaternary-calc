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
        JTextArea textArea1 = new JTextArea();
        JTextArea textArea2 = new JTextArea("PlaceHolder Text");

        //"Base 10" and "Base 4" Text
        JTextArea base10Label = new JTextArea("Base 10:");
        JTextArea base4Label = new JTextArea("Base 4:");

        base10Label.setEditable(false);
        base4Label.setEditable(false);

        base10Label.setBackground(null);
        base4Label.setBackground(null);

        base10Label.setForeground(Color.BLACK);
        base4Label.setForeground(Color.LIGHT_GRAY);

        JPanel textAreaPanel = new JPanel(new GridLayout(2, 2));
        textAreaPanel.add(base10Label);
        textAreaPanel.add(textArea1);
        textAreaPanel.add(base4Label);
        textAreaPanel.add(textArea2);

        //Set Colors
        textArea1.setForeground(Color.BLACK);
        textArea2.setForeground(Color.LIGHT_GRAY);

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
        frame.add(textAreaPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);

        //set up button presses to append to text area
        zeroButton.addActionListener(e -> textArea1.append("0"));
        oneButton.addActionListener(e -> textArea1.append("1"));
        twoButton.addActionListener(e -> textArea1.append("2"));
        threeButton.addActionListener(e -> textArea1.append("3"));

        addButton.addActionListener(e -> textArea1.append(" + "));
        subButton.addActionListener(e -> textArea1.append(" - "));
        mulButton.addActionListener(e -> textArea1.append(" * "));
        divButton.addActionListener(e -> textArea1.append(" / "));
        sqButton.addActionListener(e -> textArea1.append(" sq "));
        sqrtButton.addActionListener(e -> textArea1.append(" sqrt "));

        flipButton.addActionListener(e -> {
            //flip font colors
            Color tempColor = textArea1.getForeground();
            textArea1.setForeground(textArea2.getForeground());
            textArea2.setForeground(tempColor);

            tempColor = base10Label.getForeground();
            base10Label.setForeground(base4Label.getForeground());
            base4Label.setForeground(tempColor);
        });

        backspaceButton.addActionListener(e -> {
            String currentText = textArea1.getText();
            if (currentText.length() > 0) {
                textArea1.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        //Handle Disabling Operators:

        JButton[] operatorButtons = {addButton, subButton, mulButton, divButton, sqButton, sqrtButton};

        final boolean[] operatorPressed = {false};

        ActionListener disableOperatorButtons = e -> {
            if (!operatorPressed[0]) {
                operatorPressed[0] = true;
                for (JButton button : operatorButtons) {
                    button.setEnabled(false);
                }
            }
        };

        addButton.addActionListener(disableOperatorButtons);
        subButton.addActionListener(disableOperatorButtons);
        mulButton.addActionListener(disableOperatorButtons);
        divButton.addActionListener(disableOperatorButtons);
        sqButton.addActionListener(disableOperatorButtons);
        sqrtButton.addActionListener(disableOperatorButtons);

        final boolean[] enterPressed = {false};

        enterButton.addActionListener(e -> {
            textArea1.append(" = ");
            enterPressed[0] = true;
            // Disable all buttons
            for (JButton button : operatorButtons) {
                button.setEnabled(false);
            }
            zeroButton.setEnabled(false);
            oneButton.setEnabled(false);
            twoButton.setEnabled(false);
            threeButton.setEnabled(false);
            backspaceButton.setEnabled(false);
            enterButton.setEnabled(false);
        });


        clearButton.addActionListener(e -> {
            textArea1.setText("");
            operatorPressed[0] = false;
            enterPressed[0] = false;
            for (JButton button : operatorButtons) {
                button.setEnabled(true);
            }
            zeroButton.setEnabled(true);
            oneButton.setEnabled(true);
            twoButton.setEnabled(true);
            threeButton.setEnabled(true);
            backspaceButton.setEnabled(true);
            enterButton.setEnabled(true);
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalcGUITest::new);
    }
}