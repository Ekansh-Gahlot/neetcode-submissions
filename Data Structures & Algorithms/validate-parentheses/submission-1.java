class Solution {
    Stack<Character> st = new Stack<>();
    public boolean isValid(String s) {
        for(char ch: s.toCharArray())
        {

            if(isOpening(ch)){
                st.push(ch);
            } 
            else if(!isOpening(ch) && st.isEmpty()) return false;
            else
            {
                if(isMatching(ch, st.peek()))
                {
                    st.pop();
                    // continue;
                }
                else
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }


    public boolean isOpening(char ch){
        if(ch == '{' || ch == '[' || ch == '(')
        return true;
        return false;
    }

    public boolean isMatching(char ch2, char ch1){
        if(ch1 == '{' && ch2 == '}' || ch1 == '[' && ch2 == ']' || ch1 == '(' && ch2 == ')')
        return true;
        return false;
    }
}
