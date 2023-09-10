# Description

QuaternaryCalc is a calculator implemented in quaternary (base 4). In this base, the only digits are
0 through 3. Currently, the calculator implements six of the most common calculator operations in
this base, with the option to switch the display into decimal (base 10). This calculator currently
operates only with integer arithmetic - division and square roots are rounded down.

# Build Instructions

## Dependencies

- Java 17+ (untested but may work on earlier versions)
- Gradle 8+
- IntelliJ 2023.1.4+

## Building & Running

1. In IntelliJ, choose "File > New > Project from Version Control...".
2. Paste in the URL GitHub displays for this repository under "<> Code".
3. Wait for the clone and build to complete.
4. Ensure you are on the branch "master" and have updated.
5. Run the class CalcGUI to run the calculator.

# Features

- Operator replacement: If you press the wrong binary operation (addition, subtraction, multiplication,
  or division), you can fix your mistake by immediately pressing the correct one.

- Operator chaining: Instead of having to press enter after every binary operation, one can immediately
  type the next operator. This will both show the subtotal and continue the computation. Note that like most
  other calculators, this does *not* support the PEMDAS order of operations and is instead just shorthand to
  avoid having to press enter.

- Autoclearing of the display: Results of a computation will disappear immediately upon pressing digits. Additionally,
  one can use the result of the computation as the right operand simply by not pressing any digits before pressing
  enter.

# Manual

## Basic Layout
- The top left text area displays the current base.
- The top right text area initially shows the number the user is inputting. It is also where the results of computations
  will appear. Note that this always displays in the base currently selected, as indicated in the top left.
- The top row of buttons relate to the display. "base" changes the displayed base between base 4 and
  base 10. "clear all" clears not only the display, but the previous values and operations. "backspace"
  functions as a backspace - erasing a single digit input by the user.
- The next two rows are the digits and the basic operations. The digits are grouped together to minimize cursor
  travel distance.
- The last row has both the unary operations square (sq) and square root (sqrt), as well as the enter key (=) to finish
  a computation.

## Display of Bases

- The base is initially set to base 4.
- Even when displaying in base 10, all input still occurs in base 4. This can lead to sudden unexpected
  changes to the displayed value if it is showing base 10 while the user is typing.
- The base can be switched at any time with the "base" key. This will not interrupt or impact the
  computation.

## Inputting Numbers

- Numbers may be input in base 4 via the four digit keys.
- Currently, none of the digit keys respond to the keyboard.
- There is currently no way to input in base 10.
- There is no need to retype the result of a computation that appears after one presses "=". If one presses
  an operator following "=", the value display will be used as the left operand.
- There is no need to clear the result of a computation that appears after one presses "=". Pressing any
  digit will reset the display to that digit.

## Inputting Operations

- Currently, none of the operator keys respond to the keyboard.
- An operator should be pressed once one is satisfied with the number in the display. Once it has been pressed, there
  is no changing the left operand.
- There is no erasing or undoing of operators. However, if one presses a standard operator and then a second standard
  operator, the second will replace the first. Thus, one can correct any bad inputs by simply pressing the correct
  operator. Note that because of operator chaining, this will not work once one has pressed any digit, unary operator,
  or
  backspace.
- Unary operators will immediately give their result when they are pressed. This will not interrupt the computation of
  the four basic operators. Thus, one can enter "2 * 3<sup>2</sup> =" and get the expected result of 102 (18 in
  decimal).
- Standard operators can be chained without pressing enter. For example, one can type "1 + 2 + 4 =" to get the result
  of that entire computation. On any operator press, it will be as if the user pressed enter first: the display will
  show
  the running total of the computation. For example, on that second addition operator press, the display will read 3
  because that is the result of 1 + 2. See the [Features](#features) section for limitations.

## Troubleshooting

- If in doubt, check the display base. It can sometimes be difficult to discern between the bases.
- If NaN shows as the result of a calculation, the result of the calculation was not a real number. Currently, this
  only occurs when performing a square root on a negative or when dividing by zero.
- No exceptions should display in the shell during normal operation. If one does occur, this is due to a mistake in
  the code.

# Course Meeting & Assignment Record

Group: QuaternaryCalc 9

### Meeting 1

9-1-2023
3:00pm - 9:00pm
LB 404

Jalen, Lee, Noah, Beethoven

Initial Task Distribution:

Jalen and Lee = Representation Backend

Noah and Beethoven = Calculator GUI

Closing Tasks Distribution:

Beethoven = Organize GUI buttons into rows

Lee = Draft middleware specifications

### Weekend assignments

Lee = Post middleware specifications

Sean = Start QuaternaryCalculator middleware

### Meeting 2

9-5-2023
9:00AM - 9:30AM
RB 369

Jalen, Lee, Noah, Beethoven, Sean

Discussed clarifications needed from professor & design of middleware

### Meeting 3

9-7-2023
10:45 AM
RB 353

Jalen, Lee, Noah, Sean

2-minute meeting for progress update and proposing VirtualDisplay class

Sean = Finish QuaternaryCalculator middleware

Lee = Develop VirtualDisplay middleware

### Meeting 4

9-8-2023
2:00 PM - 7:30 PM
RB 353

Beethoven, Jalen, Lee, Noah

All present = integrate middleware & GUI (mob programming)

Jalen = Finish README



