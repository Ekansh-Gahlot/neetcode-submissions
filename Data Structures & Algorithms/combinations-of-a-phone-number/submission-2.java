class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String temp = "";

        if(digits.length()==0)
        return res;
      
        backTrack("", digits, digitsToChar, 0);
        return res;
    }

    public void backTrack(String temp, String digits, String[] digitsToChar, int i){
        if(temp.length() == digits.length()){
            res.add(temp);
            return;
        }

        String chars = digitsToChar[digits.charAt(i)-'0'];

        for(char c: chars.toCharArray())
        backTrack(temp+c, digits, digitsToChar, i+1);
    }
}
