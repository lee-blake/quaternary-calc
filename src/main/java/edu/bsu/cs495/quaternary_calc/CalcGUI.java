package edu.bsu.cs495.quaternary_calc;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;

public class CalcGUI {

    JFrame frame = new JFrame("Quaternary Calculator");
    JTextArea textArea1 = new JTextArea();
    JTextArea baseLabel = new JTextArea("Base 4:");

    private final JButton zeroButton = new JButton("0");
    private final JButton oneButton = new JButton("1");
    private final JButton twoButton = new JButton("2");
    private final JButton threeButton = new JButton("3");

    private final JButton addButton = new JButton("+");
    private final JButton subButton = new JButton("-");
    private final JButton mulButton = new JButton("*");
    private final JButton divButton = new JButton("/");
    private final JButton sqButton = new JButton("sq");
    private final JButton sqrtButton = new JButton("sqrt");
    private final JButton enterButton = new JButton("=");
    private final JButton flipButton = new JButton("swap base");
    private final JButton backspaceButton = new JButton("back");
    private final JButton clearButton = new JButton("clear all");

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
        switchBaseLabel();
        moveVirtualDisplayToGUI();
    }

    private void switchBaseLabel(){
        if (display.isBase10()){
            baseLabel.setText("Base 10:");
        }
        else{
            baseLabel.setText("Base 4:");
        }
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
        setupActionListenersForButtons();
        setupDisplayAndBaseLabel();
        setupWindowLayout();
    }

    private void setupWindowLayout(){
        // Grid Layout Formats
        GridLayout oneByOneGrid = new GridLayout(1,1);
        GridLayout oneByTwoGrid = new GridLayout(1,2);
        GridLayout oneByFourGrid = new GridLayout(1,4);
        GridLayout twoByTwoGrid = new GridLayout(2,2);

        // Format Display with Labels and Text Areas
        JPanel textAreaPanel = new JPanel(twoByTwoGrid);
        textAreaPanel.add(baseLabel);
        textAreaPanel.add(textArea1);

        // Add Buttons to row1
        JPanel row1 = buildRow1();


        // Add Buttons to row2
        JPanel row2 = buildRow2();


        // Add Buttons to row3
        JPanel row3 = buildRow3();

        // Add Buttons to row4
        JPanel row4 = buildRow4();

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
    }

    private void setupDisplayAndBaseLabel(){
        textArea1.setForeground(Color.BLACK);
        textArea1.setText("0");
        Font font2 = new Font("Verdana", Font.BOLD, 24);
        textArea1.setFont(font2);

        Font font1 = new Font("Verdana", Font.BOLD, 18);
        baseLabel.setFont(font1);
        baseLabel.setEditable(false);
        baseLabel.setBackground(null);
        baseLabel.setForeground(Color.BLACK);

        textArea1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    private void setupActionListenersForButtons(){
        // Initialize number buttons
        zeroButton.addActionListener(e -> onZeroButtonPressed());
        oneButton.addActionListener(e -> onOneButtonPressed());
        twoButton.addActionListener(e -> onTwoButtonPressed());
        threeButton.addActionListener(e -> onThreeButtonPressed());

        // Initialize operator buttons
        addButton.addActionListener(e -> onAddButtonPressed());
        subButton.addActionListener(e -> onSubButtonPressed());
        mulButton.addActionListener(e -> onMulButtonPressed());
        divButton.addActionListener(e -> onDivButtonPressed());
        sqButton.addActionListener(e -> onSqButtonPressed());
        sqrtButton.addActionListener(e -> onSqrtButtonPressed());
        enterButton.addActionListener(e -> onEnterButtonPressed());
        flipButton.addActionListener(e -> onFlipButtonPressed());
        backspaceButton.addActionListener(e -> onBackspaceButtonPressed());
        clearButton.addActionListener(e -> onClearButtonPressed());
    }

    private JPanel buildRow1() {
        JPanel row1 = new JPanel(new GridLayout(1,2));
        JPanel leftPanelRow1 = new JPanel(new GridLayout(1,2));
        leftPanelRow1.add(flipButton);
        leftPanelRow1.add(clearButton);
        JPanel rightPanelRow1 = new JPanel(new GridLayout(1,1));
        rightPanelRow1.add(backspaceButton);
        row1.add(leftPanelRow1);
        row1.add(rightPanelRow1);
        return row1;
    }
    private JPanel buildRow2() {
        JPanel row2 = new JPanel(new GridLayout(1,4));
        row2.add(zeroButton);
        row2.add(oneButton);
        row2.add(mulButton);
        row2.add(divButton);
        return row2;
    }

    private JPanel buildRow3() {
        JPanel row3 = new JPanel(new GridLayout(1,4));
        row3.add(twoButton);
        row3.add(threeButton);
        row3.add(addButton);
        row3.add(subButton);
        return row3;
    }

    private JPanel buildRow4() {
        JPanel row4 = new JPanel(new GridLayout(1,2));
        JPanel leftPanelRow4 = new JPanel(new GridLayout(1,2));
        leftPanelRow4.add(sqButton);
        leftPanelRow4.add(sqrtButton);
        JPanel rightPanelRow4 = new JPanel(new GridLayout(1,1));
        rightPanelRow4.add(enterButton);
        row4.add(leftPanelRow4);
        row4.add(rightPanelRow4);
        return row4;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalcGUI::new);
    }
}