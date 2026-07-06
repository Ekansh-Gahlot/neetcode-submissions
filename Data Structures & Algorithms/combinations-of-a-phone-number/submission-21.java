class Solution {
    String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        return ans;
        backTrack(digits, 0);
        return ans;
    }

    public void backTrack(String digits, int i){
        if(i>=digits.length())
        {
            ans.add(temp.toString());
            return;
        }

        String chars = digitsToChar[digits.charAt(i)-'0'];

        for(char c: chars.toCharArray()){
            temp.append(c);
            backTrack(digits, i+1);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
