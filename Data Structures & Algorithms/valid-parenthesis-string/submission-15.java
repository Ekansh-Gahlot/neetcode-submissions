class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0;
        int leftMax = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                leftMin++;
                leftMax++;
            }
            if(ch == ')'){
                leftMin--;
                leftMax--;
            }
            if(ch == '*'){
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
