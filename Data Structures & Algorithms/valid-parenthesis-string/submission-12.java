class Solution {
    public boolean checkValidString(String s) {
        int leftMax = 0;
        int leftMin = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                leftMax++;
                leftMin++;
            }
            else if(c == ')'){
                leftMax--;
                leftMin--;
            }
            else if(c == '*'){
                leftMax++;
                leftMin--;
            }
            if(leftMin < 0) leftMin = 0;
            if(leftMax < 0) return false;
        }
        return leftMin == 0;
    }
}
