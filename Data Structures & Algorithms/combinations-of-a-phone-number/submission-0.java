class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz"};
        if(digits.length() == 0)
        return res;

        StringBuilder temp = new StringBuilder();
        backTrack(0, res, digitsToChar, digits, temp);
        return res;
    }

    public void backTrack(int i, List<String> res, String[] digitsToChar, String digits, StringBuilder temp){
        if(temp.length() == digits.length()){
            res.add(temp.toString());
            return;
        }

        String chars = digitsToChar[digits.charAt(i)-'0'];

        for(char c: chars.toCharArray()){
            temp.append(c);
            backTrack(i+1, res, digitsToChar, digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}
