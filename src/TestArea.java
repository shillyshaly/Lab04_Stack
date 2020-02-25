import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class TestArea {
    public static void main (String[] args){
        String lispexpr = "+abc";
        Scanner lispexprscanner = new Scanner(lispexpr);
        int i = 0;
        while (lispexprscanner.hasNext()){

            if (lispexprscanner.hasNextInt()){
                System.out.println("next int");
            }else {
                int j = 0;
                String s = lispexprscanner.next();
                char ch = ' ';
                while (j < s.length()){
                    ch = s.charAt(j);
                    System.out.println(ch);
                    j++;
                }
            }
        }


    }
}
