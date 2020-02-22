import java.util.Scanner;
import java.util.Stack;

public class TestArea {
    public static void main (String[] args){

        LinkedStack<String> myStack = new LinkedStack<>();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");
        myStack.displayStack();
        myStack.remove(2);
        System.out.println();
        myStack.displayStack();

    }
}
