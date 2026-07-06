class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String temp = "";if(digits.length()==0)
        return res;
        dfs(digitsToChar, digits, 0, temp);
        return res;
    }

    public void dfs(String[] digitsToChar, String digits, int i, String temp){
        if(temp.length() == digits.length()){
            res.add(temp);
            return;
        }

        String chars = digitsToChar[digits.charAt(i)-'0'];
        for(char c: chars.toCharArray()){
            
            dfs(digitsToChar, digits, i+1, temp+c);
        }
    }
}
