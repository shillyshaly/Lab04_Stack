import java.util.Scanner;
import java.util.Stack;

/**
 * This class evaluates a simple arithmetic Lisp expression.
 *
 * @author YOUR NAME
 * @version 2/18/2020
 */
public class SimpleArithmeticLispExprEvaluator
{
    /**
     * Evaluates a simple arithmetic Lisp expression.
     *
     * @param lispExpr A string that is a valid lisp expression.
     * @return A double that is the value of the expression.
     */
    public double evaluate(String lispExpr)
    {
        // TODO PROJECT #5
        boolean nextShouldBeOperator = false;
        // Create two stacks: an expression stack and the helper stack:
        Stack<LispToken> expressionStack = new Stack<>();
        Stack<LispToken> helperStack = new Stack<>();

        // Use Scanner to process the given string representing Lisp expression
        //     one non-white space character at the time:
        Scanner lispExprScanner = new Scanner(lispExpr);
        // set the delimiter that breaks the string into single characters
        lispExprScanner = lispExprScanner.useDelimiter("\\s*");
        // the while loop instruction is commented out for now to avoid an infinite loop
//      while (lispExprScanner.hasNext())
        {
            // *** follow the algorithm from the project description ***:

            // If you see an operand (in our case it would be an integer), push it
            //   onto the expression stack:
            if (lispExprScanner.hasNextInt())
            {
                // expressionStack must not be empty since the operator should have been encountered
                //   if it is empty throw an exception

                // grab the integer,
                // create LispToken object with it and push the object on expression stack

            }
            else
            {
                // grab the character

                //	If you see "(":
                //   	- expect the next character to be an operator

                //	If you see ")":
                //      - if an operator was expected throw an exception
                //      - if the expression stack is empty throw an exception
                //      - pop operands from the expression stack and push them onto a helper stack until you find an operator;
                //           count the popped operands; if the operator is not found throw an exception
                //      - evaluate the expression: apply the operator to the operands on the helper stack
                //           NOTE: operators + and * can return value without operands
                //      - push the result on the expression stack
                //

                // If you see an operator (“+”, “-“, “*”, or “/”):
                //      - push it on the stack;
                //      - if an operator was not expected throw an exception


            }
        }
        //  If you run out of tokens, the value on the top of the expression stack
        //  is the value of the expression:
        if (expressionStack.isEmpty())
            throw new RuntimeException("mismatched )");

        LispToken token = expressionStack.pop();
        if (token.isOperator())
            throw new RuntimeException("Bad expression: did not evaluate to a value");

        return token.getValue();
    } // end evaluate

    /**
     * This private class represents either an operand or an operator
     * for an arithmetic expression in Lisp.
     */
    private class LispToken
    {
        private char operator;
        private double operand;
        private boolean isOperator;

        /**
         * Constructors for objects of class LispToken.
         */
        public LispToken(char anOperator)
        {
            this.operator = anOperator;
            this.isOperator = true;
            this.operand = 0.0;
        } // end constructor

        public LispToken(double value)
        {
            this.operator = ' ';
            this.isOperator = false;
            this.operand = value;
        } // end constructor

        /**
         * Applies this operator to two given operand values.
         *
         * @param value1 The value of the first operand.
         * @param value2 The value of the second operand.
         * @return The real result of the operation.
         */
        public double applyOperator(double value1, double value2)
        {
            double result = 0.0;

            switch (this.operator)
            {
                case '+':
                    result = value1 + value2;
                    //System.out.println("Computed " + value1 + " + " + value2 + " = " + result);
                    break;
                case '-':
                    result = value1 - value2;
                    //System.out.println("Computed " + value1 + " - " + value2 + " = " + result);
                    break;
                case '*':
                    result = value1 * value2;
                    //System.out.println("Computed " + value1 + " * " + value2 + " = " + result);
                    break;
                case '/':
                    result = value1 / value2;
                    //System.out.println("Computed " + value1 + " / " + value2 + " = " + result);
                    break;
            } // end switch

            return result;
        } // end applyOperator


        /**
         * Detects whether this operator returns a value when it has no operands.
         *
         * @return true if the operator returns a value when it has no operands,
         * or false if not.
         */
        public boolean operatorReturnsValueWhenItHasNoOperands()
        {
            boolean result = false;

            switch (this.operator)
            {
                case '+':
                case '*':
                    result = true;
                    break;
                case '-':
                case '/':
                    result = false;
                    break;
            } // end switch

            return result;
        } // end operatorReturnsValueWhenItHasNoOperands

        /**
         * Gets the identity value of this operator.
         * For example, x + 0 = x,  so 0 is the identity value for +
         * and will be the value associated with the expression (+).
         *
         * @return The identity value of the operator.
         */
        public double getOperatorIdentityValue()
        {
            double result = 0.0;

            switch (this.operator)
            {
                case '+':
                case '-':
                    result = 0.0;
                    break;
                case '*':
                case '/':
                    result = 1.0;
                    break;
            } // end switch

            return result;
        } // end getOperatorIdentityValue

        /**
         * Gets the value of this operand.
         *
         * @return The real value of the operand.
         */
        public double getValue()
        {
            return this.operand;
        } // end getValue

        /**
         * Returns true if the object is an operator.
         *
         * @return True is this object is an operator.
         */
        public boolean isOperator()
        {
            return this.isOperator;
        } // end isOperator

        public String toString()
        {
            return (this.isOperator ? this.operator + "" : this.operand + "");
        } // end toString
    } // end LispToken

    public static void main(String args[])
    {
        SimpleArithmeticLispExprEvaluator tester = new SimpleArithmeticLispExprEvaluator();
        String test1 = "(* 4 3 2)";
        System.out.print("Expression " + test1 + " evaluates to: " );
        System.out.println(tester.evaluate(test1));

        String test2 = "(*)";
        System.out.print("Expression " + test2 + " evaluates to: " );
        System.out.println(tester.evaluate(test2));

        String test3 = "(* 2)";
        System.out.print("Expression " + test3 + " evaluates to: " );
        System.out.println(tester.evaluate(test3));

        String test4 = "(+ 4 3 2)";
        System.out.print("Expression " + test4 + " evaluates to: " );
        System.out.println(tester.evaluate(test4));

        String test5 = "(+)";
        System.out.print("Expression " + test5 + " evaluates to: " );
        System.out.println(tester.evaluate(test5));

        String test6 = "(+ 1)";
        System.out.print("Expression " + test6 + " evaluates to: " );
        System.out.println(tester.evaluate(test6));

        String test7 = "(+ (+))";
        System.out.print("Expression " + test7 + " evaluates to: " );
        System.out.println(tester.evaluate(test7));

        String test8 = "(- 4 3 2)";
        System.out.print("Expression " + test8 + " evaluates to: " );
        System.out.println(tester.evaluate(test8));

        String test9 = "(/ 4 3 2)";
        System.out.print("Expression " + test9 + " evaluates to: " );
        System.out.println(tester.evaluate(test9));

        String test10 = "(/ 4)";
        System.out.print("Expression " + test10 + " evaluates to: " );
        System.out.println(tester.evaluate(test10));

        String test11 = "(* (+ 1 6 9) (/ 4))";
        System.out.print("Expression " + test11 + " evaluates to: " );
        System.out.println(tester.evaluate(test11));

        String test12 = "(+ (+) (*))";
        System.out.print("Expression " + test12 + " evaluates to: " );
        System.out.println(tester.evaluate(test12));

        String test13 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))";
        System.out.print("Expression " + test13 + " evaluates to: " );
        System.out.println(tester.evaluate(test13));

        String test14 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1)))";
        System.out.print("Expression " + test14 + " evaluates to: " );
        System.out.println(tester.evaluate(test14));

        String test15 = "(+ (/ 2) (* 2) (/ (+ 1) (+) (- 2 1 )))";
        System.out.print("Expression " + test15 + " evaluates to: " );
        System.out.println(tester.evaluate(test15));

        // the following test cases check if a RuntimeException has been thrown
        System.out.println();
        try
        {
            String testBad1 = "((+ (/ 2) (* 2)))";
            System.out.print("Expression " + testBad1 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad1));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad2 = "( 2 3 4 5 )";
            System.out.print("Expression " + testBad2 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad2));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad3 = "( / )";
            System.out.print("Expression " + testBad3 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad3));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad4 = "( ? )";
            System.out.print("Expression " + testBad4 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad4));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad5 = "( + 1 * 2 )";
            System.out.print("Expression " + testBad5 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad5));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad6 = "( )";
            System.out.print("Expression " + testBad6 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad6));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad7 = "( * ))";
            System.out.print("Expression " + testBad7 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad7));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }

        try
        {
            String testBad8 = "( (*) 1 2 3 )";
            System.out.print("Expression " + testBad8 + " evaluates to: " );
            System.out.println(tester.evaluate(testBad8));
        }catch(RuntimeException re)
        {
            System.out.println("Exception has been thrown: \"" + re.getMessage() + "\" - CORRECT");
        }
    } // end main
} // end SimpleArithmeticLispExprEvaluator