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

    public CalcGUI() {
        setupActionListenersForButtons();
        setupDisplayAndBaseLabel();
        setupWindowLayout();
    }

    private void setupActionListenersForButtons(){
        zeroButton.addActionListener(e -> onZeroButtonPressed());
        oneButton.addActionListener(e -> onOneButtonPressed());
        twoButton.addActionListener(e -> onTwoButtonPressed());
        threeButton.addActionListener(e -> onThreeButtonPressed());
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

    private void moveVirtualDisplayToGUI() {
        textArea1.setText(display.getDisplayString());
    }

    private void onEnterButtonPressed() {
        display.pressEnter();
        moveVirtualDisplayToGUI();
    }

    private void onBackspaceButtonPressed() {
        display.pressBackspace();
        moveVirtualDisplayToGUI();
    }

    private void onClearButtonPressed() {
        display.clearAll();
        moveVirtualDisplayToGUI();
    }

    private void onFlipButtonPressed() {
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

    private void onZeroButtonPressed() {
        display.pressDigit("0");
        moveVirtualDisplayToGUI();
    }

    private void onOneButtonPressed() {
        display.pressDigit("1");
        moveVirtualDisplayToGUI();
    }

    private void onTwoButtonPressed() {
        display.pressDigit("2");
        moveVirtualDisplayToGUI();
    }

    private void onThreeButtonPressed() {
        display.pressDigit("3");
        moveVirtualDisplayToGUI();
    }

    private void onSqButtonPressed(){
        display.pressUnaryOperator(UnaryOperator.SQUARE);
        moveVirtualDisplayToGUI();
    }

    private void onSqrtButtonPressed(){
        display.pressUnaryOperator(UnaryOperator.SQUARE_ROOT);
        moveVirtualDisplayToGUI();
    }

    private void onAddButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.ADDITION);
        moveVirtualDisplayToGUI();
    }

    private void onSubButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.SUBTRACTION);
        moveVirtualDisplayToGUI();
    }

    private void onMulButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.MULTIPLICATION);
        moveVirtualDisplayToGUI();
    }

    private void onDivButtonPressed(){
        display.pressBinaryOperator(BinaryOperator.DIVISION);
        moveVirtualDisplayToGUI();
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

    private void setupWindowLayout(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(buildTextAreaPanel(), BorderLayout.NORTH);
        frame.add(buildButtonPanel(), BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel buildTextAreaPanel() {
        JPanel textAreaPanel = new JPanel(new GridLayout(2,2));
        textAreaPanel.add(baseLabel);
        textAreaPanel.add(textArea1);
        return textAreaPanel;
    }

    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(buildRow1());
        buttonPanel.add(buildRow2());
        buttonPanel.add(buildRow3());
        buttonPanel.add(buildRow4());
        return buttonPanel;
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