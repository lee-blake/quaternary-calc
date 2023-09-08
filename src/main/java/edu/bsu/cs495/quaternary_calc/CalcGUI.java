package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;

public class CalcGUI {

    JFrame frame = new JFrame("Quaternary Calculator");
    JTextArea textArea1 = new JTextArea();


    private final VirtualDisplay display = new VirtualDisplay();

    private void moveVirtualDisplayToGUI() {
        textArea1.setText(display.getDisplayString());

        // set up button presses to append to text area

    }

    public void onEnterButtonPressed() {
        display.pressEnter();
        moveVirtualDisplayToGUI();
    }

    public void onBackspaceButtonPressed() {
        display.pressBackspace();
        moveVirtualDisplayToGUI();
    }

    public void onClearButtonPressed() {
        display.clearAll();
        moveVirtualDisplayToGUI();
    }

    public void onFlipButtonPressed() {
        display.toggleBase();
        moveVirtualDisplayToGUI();

    }

    public void onZeroButtonPressed() {
        display.pressDigit("0");
        moveVirtualDisplayToGUI();
    }

    public void onOneButtonPressed() {
        display.pressDigit("1");
        moveVirtualDisplayToGUI();
    }

    public void onTwoButtonPressed() {
        display.pressDigit("2");
        moveVirtualDisplayToGUI();
    }

    public void onThreeButtonPressed() {
        display.pressDigit("3");
        moveVirtualDisplayToGUI();
    }

    public void onSqButtonPressed(){
        display.pressUnaryOperator(UnaryOperator.SQUARE);
        moveVirtualDisplayToGUI();
    }

    public void onSqrtButtonPressed(){
        display.pressUnaryOperator(UnaryOperator.SQUARE_ROOT);
        moveVirtualDisplayToGUI();
    }

    public void onAddButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.ADDITION);
        moveVirtualDisplayToGUI();
    }

    public void onSubButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.SUBTRACTION);
        moveVirtualDisplayToGUI();
    }

    public void onMulButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.MULTIPLICATION);
        moveVirtualDisplayToGUI();
    }

    public void onDivButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.DIVISION);
        moveVirtualDisplayToGUI();
    }

    public CalcGUI() {
        textArea1.setForeground(Color.BLACK);
        textArea1.setText("0");

        JTextArea textArea2 = new JTextArea("PlaceHolder Text");
        textArea2.setForeground(Color.LIGHT_GRAY);
        textArea2.setEditable(false); //This value can not be changed to avoid having someone type something in and mess it up

        JTextArea base10Label = new JTextArea("Base 10:");
        base10Label.setEditable(false);
        base10Label.setBackground(null);
        base10Label.setForeground(Color.BLACK);

        JTextArea base4Label = new JTextArea("Base 4:");
        base4Label.setEditable(false);
        base4Label.setBackground(null);
        base4Label.setForeground(Color.LIGHT_GRAY);

        // Initialize number buttons
        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(e -> onZeroButtonPressed());
        JButton oneButton = new JButton("1");
        oneButton.addActionListener(e -> onOneButtonPressed());
        JButton twoButton = new JButton("2");
        twoButton.addActionListener(e -> onTwoButtonPressed());
        JButton threeButton = new JButton("3");
        threeButton.addActionListener(e -> onThreeButtonPressed());

        // Initialize operator buttons
        JButton addButton = new JButton("+");
        addButton.addActionListener(e -> onAddButtonPressed());
        JButton subButton = new JButton("-");
        subButton.addActionListener(e -> onSubButtonPressed());
        JButton mulButton = new JButton("*");
        mulButton.addActionListener(e -> onMulButtonPressed());
        JButton divButton = new JButton("/");
        divButton.addActionListener(e -> onDivButtonPressed());
        JButton sqButton = new JButton("sq");
        sqButton.addActionListener(e -> onSqButtonPressed());
        JButton sqrtButton = new JButton("sqrt");
        sqrtButton.addActionListener(e -> onSqrtButtonPressed());
        JButton enterButton = new JButton("enter");
        enterButton.addActionListener(e -> onEnterButtonPressed());
        JButton flipButton = new JButton("base");
        flipButton.addActionListener(e -> onFlipButtonPressed());
        JButton backspaceButton = new JButton("back");
        backspaceButton.addActionListener(e -> onBackspaceButtonPressed());
        JButton clearButton = new JButton("clear");
        clearButton.addActionListener(e -> onClearButtonPressed());

        // Grid Layout Formats
        GridLayout oneByOneGrid = new GridLayout(1,1);
        GridLayout oneByTwoGrid = new GridLayout(1,2);
        GridLayout oneByFourGrid = new GridLayout(1,4);
        GridLayout twoByTwoGrid = new GridLayout(2,2);

        // Format Display with Labels and Text Areas
        JPanel textAreaPanel = new JPanel(twoByTwoGrid);
        textAreaPanel.add(base10Label);
        textAreaPanel.add(textArea1);
        textAreaPanel.add(base4Label);
        textAreaPanel.add(textArea2);

        // Add Buttons to row1
        JPanel row1 = new JPanel(oneByTwoGrid);
        JPanel leftPanelRow1 = new JPanel(oneByTwoGrid);
        leftPanelRow1.add(flipButton);
        leftPanelRow1.add(clearButton);

        JPanel rightPanelRow1 = new JPanel(oneByOneGrid);
        rightPanelRow1.add(backspaceButton);

        row1.add(leftPanelRow1);
        row1.add(rightPanelRow1);

        // Add Buttons to row2
        JPanel row2 = new JPanel(oneByFourGrid);
        row2.add(zeroButton);
        row2.add(oneButton);
        row2.add(twoButton);
        row2.add(threeButton);

        // Add Buttons to row3
        JPanel row3 = new JPanel(oneByFourGrid);
        row3.add(addButton);
        row3.add(subButton);
        row3.add(mulButton);
        row3.add(divButton);

        // Add Buttons to row4
        JPanel row4 = new JPanel(oneByTwoGrid);
        JPanel leftPanelRow4 = new JPanel(oneByTwoGrid);
        leftPanelRow4.add(sqButton);
        leftPanelRow4.add(sqrtButton);

        JPanel rightPanelRow4 = new JPanel(oneByOneGrid);
        rightPanelRow4.add(enterButton);

        row4.add(leftPanelRow4);
        row4.add(rightPanelRow4);

        // Add Rows to Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(row1);
        buttonPanel.add(row2);
        buttonPanel.add(row3);
        buttonPanel.add(row4);

        // Format the Window and Add Button Panels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textAreaPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);



        flipButton.addActionListener(e -> {
            // flip font colors
            Color tempColor = textArea1.getForeground();
            textArea1.setForeground(textArea2.getForeground());
            textArea2.setForeground(tempColor);

            tempColor = base10Label.getForeground();
            base10Label.setForeground(base4Label.getForeground());
            base4Label.setForeground(tempColor);
        });

        backspaceButton.addActionListener(e -> {
            String currentText = textArea1.getText();
            if (!currentText.isEmpty()) {
                textArea1.setText(currentText.substring(0, currentText.length() - 1));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalcGUI::new);
    }
}