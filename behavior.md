# Behavior of the Windows Calculator
The columns represent the previous type of key pressed.
| Current Key | # | Unary Op | +-*/ | = |
|-------------|---|----------|------|---|
| # | Appends to number | Replaces entire current expression | Replaces the result of the previous step | Clears the calculator and starts typing
| Unary Op | Performs op on # in window | Performs op on expression (value in window) | Performs op on previous evaluation | Clears calculator and performs op on value in window
| +-*/ | Submits number to left of operation and displays the value of everything in the calculator so far | As #, only records it as an expression instead | Replaces the last operator pressed | Clears calculator, then submits value in window as if it were a typed #
| = | Computes and displays the value of the entire calculation | Computes and displays the value of the entire calculation | Computes and displays the value of the entire calculation, but with the value in the window instead of anything typed | Repeats the last binary operator, if it exists, and then computers and displays the value of the entire calculation. For example, typing 2+2== gives work 4+2=6 because the value on the first = would be 4, and the last binary operation was  +2.

# Design of the calculator middleware
To have the potential to achieve similar functionality, we should make the following choices in our design.
## Basic conceptual structure
The expressions take the form of a purely left-branching tree, where each node can have up to two children. Conveniently, node type can be inferred by the number of children.
- Pure numbers are leaf nodes
- Unary operators have exactly one child
- Binary operators have exactly two children
The reason the tree is left-branching is because without parentheses, calculators typically adopt a "greedy" approach to operations instead of the PEMDAS ordering.
## Implementation differences
The difficulty in implementing this structure directly is that it must be wrapped to achieve continuous calculation. The reason for this is that one might type "1+", but still be typing the next number. This does not translate to a tree because the right value of the "+" operator is unknown.
### 'Ideal' implementation
One way to address this is to create UnaryExpression and BinaryExpression objects and have them implement the tree, with "evaulate" (returning a QuaternaryNumber) and "toString" methods letting the children represent themselves and just putting it all together. In this case, we need a Calculator object to wrap the tree and hold on to the operator until we've gotten another binary operator or equals sign.
### First iteration implementation
If we ignore the history feature for unary operations for a second - having them just change the value displayed without actually "submitting" anything - the system becomes much simpler. In that case, the expression is just a bunch of numbers separated by binary operations. Thus, we can just keep a list of numbers and operators that we evaluate by looping through the same indices, number before operator. The following methods would then be necessary
- Calculator.reset(): We need to be able to reset the entire calculation
- Calculator.submitBinaryOperation(QuaternaryNumber, BinaryOperation): This is what the Windows calculator does implicitly every time you press a +-*/ key.
- Calculator.evaluate(QuaternaryNumber): Returns a QuaternaryNumber. This is what the Windows calculator does when you hit equals. It needs the value of the display to finish the calculation.
- Calculator.evaluateIgnoringLastOperation(): Returns a QuaternaryNumber. This is what the Windows calculator does to keep its "running total". What I mean is that when you press "1+2+", you will see 3 in the display before you type. This 3 is the running total - we ignore the second "+" and evaluate everything else to get 3.
- Calculator.replaceLastBinaryOperation(BinaryOperation): The Windows calculator does this when you press two +-*/ buttons in a row.
- Calculator.showWork(): Returns a string showing the expression so far, including the last binary operation. When you type in the Windows calculator, you see this above the number you are entering.
### Progressing to ideal implementation
Because we have defined the middleware-GUI API in terms of how the GUI will use it, we should not have to perform a full rewrite of the middleware if we choose to implement the ideal implementation and/or include unary operator history. We also should not have to change the unit tests for the Calculator under such circumstances. We may have to add additional methods and tests, but nothing should have be thrown out. The underlying implementation can be changed over by internally storing the last operator seperately from the tree, and then when a new operator is submitted, take the number from that function call and make that the right-child of a new BinaryExpression object, with the left-child being the root of the tree and the operator being the one saved. The operator from the function call is then stored until the next submission, and so on.
## First steps
**Do not leave the unit tests until afterwards. Every time you commit, the intended functionality should be verified.**
1. Make a BinaryOperator enum so we do not have to parse strings. Each operator should represent itself via toString as itself. For example OPERATION_ADDITION.toString -> "+".
2. Write Calculator::showWork with a unit test so that it just returns an empty string when nothing has been done
3. Write Calculator::submitBinaryOperation so that is just an empty void for now.
4. Write more unit tests for Calculator::showWork where showWork is tested *after* submitting some operators. Vary the operators and number values.
5. Implement Calculator::submitBinaryOperation so that the tests pass. You can keep two ArrayLists, one for QuaternaryNumbers and one for BinaryOperators, and just run through them, putting the numbers before the operators at each index.
6. Implement Calculator::evaluateIgnoringLastOperation and unit tests. It should be zero if there aren't any operations yet. Otherwise, loop through the numbers and operators, keeping a running total, until you hit the last operation, returning the value at that point. **Do not try to implement PEMDAS, simple calculators do not use it.**
7. Implement Calculator::evaluate and unit tests. **Do not duplicate code from the previous step.** Think how you can reuse the Calculator::evaluateIgnoringLastOperation to your advantage.
8. Implement Calculator::reset and unit tests. Test that both Calculator::showWork and Calculator::evaluateIgnoringLastOperation both behave as if the Calculator object was freshly constructed.
9. Implement Calculator::replaceLastBinaryOperation and unit tests. Test that both Calculator::showWork and Calculator::evaluate both use the new operation instead of the old.
