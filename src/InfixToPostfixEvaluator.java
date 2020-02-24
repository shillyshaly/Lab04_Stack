import java.awt.event.WindowFocusListener;import java.util.Stack;/** * A class that represents a postfix expression. * * @author Jamie Hernandez * @version 02/18/2020 */public class InfixToPostfixEvaluator{    /**     * Creates a postfix expression that represents a given infix expression.     * Segment 5.16     *     * @param infix a string that is a valid infix expression     */    public void convertToPostfix(String infix)    {        // TODO PROJECT #4 - DONE        System.out.println("Infix:   " + infix);        Stack<Character> operatorStack = new Stack<>();        StringBuilder postfix = new StringBuilder();        int characterCount = infix.length();        char topOperator;        // IMPLEMENT ALGORITHM 5.16        // utilize Character.isLetter method        // utilize getPrecedence method        int i = 0;        char ch = ' ';        while (i < characterCount){            ch = infix.charAt(i);            if (Character.isLetter(ch)){                postfix.append(ch);            }else if (ch == '^'){                operatorStack.push(ch);            }else if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){                while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())){                    postfix.append(operatorStack.peek());                    operatorStack.pop();                }                operatorStack.push(ch);            }else if (ch == '('){                operatorStack.push(ch);            }else if (ch == ')'){                topOperator = operatorStack.pop();                while (topOperator != '('){                    postfix.append(topOperator);                    topOperator = operatorStack.pop();                }            }            i++;        }        while (!operatorStack.isEmpty()){            topOperator = operatorStack.pop();            postfix.append(topOperator);        }        System.out.println("InfixToPostfixEvaluator: " + postfix.toString());        System.out.println("\n");    } // end convertToPostfix    /**     * Indicates the precedence of a given operator.     *     * @param operator a character that is (, ), +, -, *, /, or ^     * @return an integer that indicates the precedence of operator:     *         0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^, -1 if     *         anything else     */    private int getPrecedence(char operator)    {        int precedence;        switch (operator)        {            case '(':            case ')':                precedence = 0;                break;            case '+':            case '-':                precedence = 1;                break;            case '*':            case '/':                precedence = 2;                break;            case '^':                precedence = 3;                break;            default:                precedence = -1;        } // end switch        return precedence;    } // end getPrecedence    /**     * Evaluates a postfix expression.     * Segment 5.18     *     * @param postfix a string that is a valid postfix expression     * @return the value of the postfix expression     */    public double evaluatePostfix(String postfix)    {        // TODO PROJECT #4 - DONE        Stack<Double> valueStack = new Stack<>();        int characterCount = postfix.length();        // IMPLEMENT ALGORITHM 5.18        // utilize Character.isLetter method        // utilize compute and valueOf methods        int i = 0;        char ch = ' ';        while (i < characterCount){            ch = postfix.charAt(i);            if (Character.isLetter(ch)){                valueStack.push(valueOf(ch));            }else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){                double operand2 = valueStack.pop();                double operand1 = valueStack.pop();                double result = compute(operand1, operand2, ch);                valueStack.push(result);            }            i++;        }        return valueStack.peek(); // THIS IS A STUB    } // end evaluatePostfix    private double valueOf(char variable)    {        double value;        switch (variable)        {            case 'a':                value = 2.0;                break;            case 'b':                value = 3.0;                break;            case 'c':                value = 4.0;                break;            case 'd':                value = 5.0;                break;            case 'e':                value = 6.0;                break;            default:                value = 0;                break;        } // end switch        return value;    } // end valueOf    private double compute(double operandOne, double operandTwo, char operator)    {        double result = 0;        switch (operator)        {            case '+':                result = operandOne + operandTwo;                break;            case '-':                result = operandOne - operandTwo;                break;            case '*':                result = operandOne * operandTwo;                break;            case '/':                if (operandTwo != 0)                    result = operandOne / operandTwo;                break;            case '^':                result = Math.pow(operandOne, operandTwo);                break;        } // end switch        return result;    } // end compute    public static void main(String[] args)    {        InfixToPostfixEvaluator tester = new InfixToPostfixEvaluator();        System.out.println("Converting infix expressions to postfix expressions:\n");        tester.convertToPostfix("a+b");        tester.convertToPostfix("(a + b) * c");        tester.convertToPostfix("a * b / (c - d)");        tester.convertToPostfix("a / b + (c - d)");        tester.convertToPostfix("a / b + c - d");        tester.convertToPostfix("a^b^c");        tester.convertToPostfix("(a^b)^c");        tester.convertToPostfix("a*(b/c+d)");        tester.convertToPostfix("(a+b)/(c-d)");        tester.convertToPostfix("a/(b-c)*d");        tester.convertToPostfix("a-(b/(c-d)*e+f)^g");        tester.convertToPostfix("(a-b*c)/(d*e^f*g+h)");        System.out.println("Evaluating postfix expressions with\n" +                "a = 2, b = 3, c = 4, d = 5, e = 6");        System.out.println("Assuming correct input!!!\n\n");        System.out.println("ae+bd-/ : " + tester.evaluatePostfix("ae+bd-/") + "\n");        System.out.println("abc*d*- : " + tester.evaluatePostfix("abc*d*-") + "\n");        System.out.println("abc-/d* : " + tester.evaluatePostfix("abc-/d*") + "\n");        System.out.println("ebca^*+d- : " + tester.evaluatePostfix("ebca^*+d-") + "\n");        System.out.println("Done.");    }  // end main} // end InfixToPostfixEvaluator                 