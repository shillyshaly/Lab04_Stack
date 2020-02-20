import java.util.Scanner;
import java.util.Stack;

public class TestArea {
    public static void main (String[] args){

        Stack<Integer> stack1 = new Stack<>();
        int i = 1;
        int operand1 = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter some stuff");
        operand1 = keyboard.nextInt();
        while (i < operand1){
            stack1.push(i);
            i *= 2;
        }
        while (!stack1.isEmpty()){
            System.out.println(stack1.pop());
        }
    }
}
