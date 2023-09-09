import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> value = new Stack<Double>();

        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("("));
            else if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) value.push(value.pop() + value.pop());
                else if (op.equals("-")) value.push(value.pop() - value.pop());
                else if (op.equals("/")) value.push(value.pop() / value.pop());
                else if (op.equals("*")) value.push(value.pop() * value.pop());
            }
            else value.push(Double.parseDouble(s));
        }
        StdOut.println(value.pop());
    }
}