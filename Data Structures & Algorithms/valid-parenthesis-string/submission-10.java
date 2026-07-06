class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
            {
                leftMin++;
                leftMax++;
            }
            if(c == ')'){
                leftMin--;
                leftMax--;
            }
            if(c == '*')
            {
                leftMin--;
                leftMax++;
            }
            if(leftMin < 0)
            leftMin = 0;
            if(leftMax < 0)
            return false;
        }
        return leftMin == 0; 
    }
}
