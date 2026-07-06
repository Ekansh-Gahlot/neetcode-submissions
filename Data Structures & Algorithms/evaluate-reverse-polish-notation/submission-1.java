// import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String token : tokens) {
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = st.pop();
                int num1 = st.pop();
                int res = eval(num1, num2, token);
                st.push(res);
            } else {
                // If it's a number, push it onto the stack
                st.push(Integer.valueOf(token));
            }
        }
        // The final result will be the last item left in the stack
        return st.pop();
    }

    public int eval(int num1, int num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }
}
