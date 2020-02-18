import java.util.*;

/**
 * A class that implements math operations utilizing a stack.
 *
 * @author YOUR NAME
 * @version 02/18/2020
 */
public class FunWithStack
{
    public void decimalToBinary()
    {
        // TODO PROJECT #1
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        try
        {
            do
            {
                System.out.println("\nPlease enter a positive integer, or type \"stop\"");
                int decimalNumber = keyboard.nextInt();

                System.out.print(decimalNumber + " in binary is --> ");

                // YOUR CODE GOES HERE
                while (decimalNumber != 0){
                    int mod = decimalNumber % 2;
                    stack.push(mod);
                    decimalNumber /= 2;
                }
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }


                System.out.println();
            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done with conversion.\n");
        }
    }

    public void ancientMultiplier()
    {
        // TODO PROJECT #1
        // http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        int operand1;
        int operand2;
        try
        {
            do
            {
                System.out.println("\nPlease enter operand1, or type \"stop\"");
                operand1 = keyboard.nextInt();
                System.out.println("Please enter operand2");
                operand2 = keyboard.nextInt();
                // YOUR CODE GOES HERE
                //do not call peek()



            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done multiplying\n");
        }
    }


    public static void main(String[] args)
    {
        FunWithStack funWithStack = new FunWithStack();
        System.out.println("\u001B[35m\u001B[1m*** DECIMAL TO BINARY CONVERTER ***\u001B[0m");
        funWithStack.decimalToBinary();
        System.out.println("\u001B[35m\u001B[1m*** ANCIENT MULTIPLIER ***\u001B[0m");
        funWithStack.ancientMultiplier();

        System.out.println("Done!");
    }
}