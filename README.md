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



