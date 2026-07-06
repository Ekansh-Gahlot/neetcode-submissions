class Solution {
    String[] digitsToChar = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
        return list;

        dfs(digits, 0);
        return list;

        
    }

    public void dfs(String digits, int i){
        if(i >= digits.length())
        {
            list.add(new String(temp));
            return;
        }


        String chars = digitsToChar[digits.charAt(i) - '0'];

        for(char ch: chars.toCharArray()){
            temp.append(ch);
            dfs(digits, i+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
