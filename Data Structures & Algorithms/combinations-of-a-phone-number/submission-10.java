class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length() == 0)
        return res;
        StringBuilder temp = new StringBuilder();
        dfs(digitsToChar, digits, temp, 0);
        return res;
    }

    public void dfs(String[] digitsToChar, String digits,StringBuilder temp, int i){
        if(i==digits.length()){
            res.add(new String(temp));
            return;
        }
        String chars = digitsToChar[digits.charAt(i) - '0'];

        for(char c: chars.toCharArray()){
            temp.append(c);
            dfs(digitsToChar, digits, temp, i+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
