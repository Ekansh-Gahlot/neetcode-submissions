class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder temp = new StringBuilder();

        if(digits.length()==0)
        return res;
      
        backTrack(temp, digits, digitsToChar, 0);
        return res;
    }

    public void backTrack(StringBuilder temp, String digits, String[] digitsToChar, int i){
        if(temp.length() == digits.length()){
            res.add(new String(temp));
            return;
        }

        String chars = digitsToChar[digits.charAt(i)-'0'];

        for(char c: chars.toCharArray()){
        temp.append(c);
        backTrack(temp, digits, digitsToChar, i+1);
        temp.deleteCharAt(temp.length()-1);
        }
    }
}
